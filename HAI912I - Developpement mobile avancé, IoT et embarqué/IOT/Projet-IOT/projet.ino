#include <Arduino.h>
#include <WiFi.h>
#include <WebServer.h>
#include <TFT_eSPI.h>
#include <SPI.h>
//#include <ArduinoJson.h>
#include <FreeRTOS.h>

#include "esp_wifi.h"
#include "html.h"
TFT_eSPI tft = TFT_eSPI();       // Invoke custom library

#define TFT_GREY 0x5AEB // New colour

const double VCC = 3.3;
const double R2 = 560;           
const double adc_resolution = 1023; 

const double A = 0.001129148;   
const double B = 0.000234125;
const double C = 0.0000000876741; 

#define VIN 5 // V power voltage
#define R 0.56 //ohm resistance value


bool led = false;

int mode = 2;



/*
 *      Parametres réseaux  
 */

const char* ssid     = "ESP_32_MM";                     // SSID Name
const char* password = "";// "123123MartinMatthieu";           // SSID Password - Set to NULL to have an open AP

const int   channel        = 10;                        // WiFi Channel number between 1 and 13
const bool  hide_SSID      = false;                     // To disable SSID broadcast -> SSID will not appear in a basic WiFi scan
const int   max_connection = 2;                         // Maximum simultaneous connected clients on the AP
double temperature = 0;
int lux = 0;


IPAddress local_ip(192,168,10,1);
IPAddress gateway(192,168,0,1);
IPAddress subnet(255,255,255,0);
void initWifi() {
  //  Serial.print("\n SSID: ");
   // Serial.print(ssid) ;
   // Serial.print("\n PSW: ");
   // Serial.println(password) ;  
    
    WiFi.mode(WIFI_AP);
    WiFi.softAP(ssid, password);
    
    //Serial.println("Point d'accès ouvert !") ;
    //Serial.println(WiFi.softAPIP());
}

void printConnectedUsers(){ // Source : https://www.upesy.fr/blogs/tutorials/how-create-a-wifi-acces-point-with-esp32
    wifi_sta_list_t wifi_sta_list;
    tcpip_adapter_sta_list_t adapter_sta_list;
    esp_wifi_ap_get_sta_list(&wifi_sta_list);
    tcpip_adapter_get_sta_list(&wifi_sta_list, &adapter_sta_list);
    
    if (adapter_sta_list.num > 0)
        Serial.println("-----------");
    for (uint8_t i = 0; i < adapter_sta_list.num; i++){
        tcpip_adapter_sta_info_t station = adapter_sta_list.sta[i];
        Serial.print((String)"[+] Device " + i + " | MAC : ");
        Serial.printf("%02X:%02X:%02X:%02X:%02X:%02X", station.mac[0], station.mac[1], station.mac[2], station.mac[3], station.mac[4], station.mac[5]);
        Serial.println((String) " | IP " + ip4addr_ntoa(&(station.ip)));
    }
}

/*
 *      Serveur WEB // https://github.com/survivingwithandroid/ESP32-Rest-API-Server/blob/master/src/main.cpp
 */
WebServer server(80);



void serverRoot() {
  Serial.println("racine du webservice");
  server.send(200, "text/html", HTML);
}

void readTemp() {
  Serial.println("/readTemperature = X");
  server.send(200, "application/json", {"Temperature = " + String(temperature)});
}
void readLum() {
  Serial.println("/readLumiere = X");
  server.send(200, "application/json", {"Lumiere = "+ String(lux)});
}
void statusLedOn() {
  Serial.println("/led = ON");
  server.send(200, "application/json", {"Led = On"});
  mode = 0;
}
void statusLedOff() {
  Serial.println("/led = OFF");
  server.send(200, "application/json", {"Led = Off"});
  mode = 1;
}
void statusLedAuto() {
  Serial.println("/led = AUTO");
  server.send(200, "application/json", {"Led = Auto"});
  mode = 2;
}

void setup_routing() {
  server.on("/", serverRoot);
  server.on("/readTemperature", readTemp);
  server.on("/readLumiere", readLum);
  server.on("/led/on", statusLedOn);
  server.on("/led/off", statusLedOff);
  server.on("/led/auto", statusLedAuto);
 
  // start server
  server.begin();
}
void setup() {
  tft.init();
  tft.setRotation(1);
  tft.fillScreen(random(0xFFFF));
  Serial.begin(9600);
  pinMode(13, OUTPUT); // définit la broche 13 en sortie
  initWifi();
  setup_routing(); 

}

void loop() {
  double Vout, Rth, adc_value; 

  int valeurlum = analogRead(39);
  float Vout0=valeurlum*0.0048828125;   
   lux = sensorRawToPhys(Vout0);
    int analgtemp = analogRead(38);
  Serial.println(analgtemp);
    Vout = (analgtemp * VCC) / adc_resolution;
  Rth = (VCC * R2 / Vout) - R2;

  temperature = (1 / (A + (B * log(Rth)) + (C * pow((log(Rth)),3))));   // Temperature in kelvin

  temperature = temperature - 273.15;  // Temperature in degree celsius
  Serial.print("Temperature = ");
  Serial.print(temperature);
  Serial.println(" degree celsius");

  Serial.print(F("Physical value from sensor = "));
  Serial.print(lux); // the analog reading
  Serial.println(F(" lux")); // the analog

    // Set "cursor" at top left corner of display (0,0) and select font 2
  // (cursor will move to next line automatically during printing with 'tft.println'
  //  or stay on the line is there is room for the text with tft.print)
  tft.setCursor(0, 50, 2);
  // Set the font colour to be white with a black background, set text size multiplier to 1
  tft.setTextColor(TFT_WHITE,TFT_BLACK);  tft.setTextSize(1);
  // We can now plot text on screen using the "print" class
  tft.print("Luminosité = ");
  tft.print(lux);
  tft.print(" lux");

    tft.setCursor(0, 70, 2);
  // Set the font colour to be white with a black background, set text size multiplier to 1
  tft.setTextColor(TFT_WHITE,TFT_BLACK);  tft.setTextSize(1);
  // We can now plot text on screen using the "print" class
  tft.print("temperature = ");
  tft.print(temperature);
  tft.print(" °C");
      printConnectedUsers();
    server.handleClient();



if(mode == 0){
  digitalWrite(13, HIGH); // allume la LED
}else if(mode ==1){
  digitalWrite(13, LOW); // éteint la LED
} else{
  if(lux > 1500){
    digitalWrite(13, LOW); // allume la LED
  }else{
    digitalWrite(13, HIGH); // éteint la LED
  }

  delay(1000);

}
}
int sensorRawToPhys(int raw){
  // Conversion rule
  float Vout = float(raw) * (VIN / float(1024));// Conversion analog to voltage
  float RLDR = (R * (VIN - Vout))/Vout; // Conversion voltage to resistance
  int phys=500/(RLDR/1000); // Conversion resitance to lumen
  return phys;
}