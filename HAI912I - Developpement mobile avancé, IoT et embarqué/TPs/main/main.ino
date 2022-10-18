#include <Arduino.h>
#include <WiFi.h>
#include <WebServer.h>
//#include <ArduinoJson.h>
#include <FreeRTOS.h>

#include "esp_wifi.h"
#include "html.h"
/*
 *      Parametres réseaux  
 */

const char* ssid     = "ESP_32_MM";                     // SSID Name
const char* password = "";// "123123MartinMatthieu";           // SSID Password - Set to NULL to have an open AP

const int   channel        = 10;                        // WiFi Channel number between 1 and 13
const bool  hide_SSID      = false;                     // To disable SSID broadcast -> SSID will not appear in a basic WiFi scan
const int   max_connection = 2;                         // Maximum simultaneous connected clients on the AP

IPAddress local_ip(192,168,10,1);
IPAddress gateway(192,168,0,1);
IPAddress subnet(255,255,255,0);

void initWifi() {
    Serial.print("\n SSID: ");
    Serial.print(ssid) ;
    Serial.print("\n PSW: ");
    Serial.println(password) ;  
    
    WiFi.mode(WIFI_AP);
    WiFi.softAP(ssid, password);
    
    Serial.println("Point d'accès ouvert !") ;
    Serial.println(WiFi.softAPIP());
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
  server.send(200, "application/json", {"Temperature = X"});
}
void readLum() {
  Serial.println("/readLumiere = X");
  server.send(200, "application/json", {"Lumiere = X"});
}
void statusLedOn() {
  Serial.println("/led = ON");
  server.send(200, "application/json", {"Led = On"});
}
void statusLedOff() {
  Serial.println("/led = OFF");
  server.send(200, "application/json", {"Led = Off"});
}
void statusLedAuto() {
  Serial.println("/led = AUTO");
  server.send(200, "application/json", {"Led = Auto"});
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


/*
 *      CODE 
 */

void setup(){
    Serial.begin(115200);
    initWifi();
    setup_routing();     

}

 
void loop() {
    delay(1000);
    printConnectedUsers();
    server.handleClient();
}
