import 'package:meteo_app/Models/Ville.dart';
import 'package:meteo_app/Utils/WeatherApi.dart';

class Weather {
  String icon;
  String desc;

  double temp;
  double feellike;

  double humidity;
  double wind;
  double pressure;

  static Weather getDefaultWeather() {
    return Weather(icon: "Clouds", desc: "overcast clouds", temp: 13.64,
        feellike: 13.25, humidity: 84, wind: 3.6, pressure: 84) ;
  }

  Weather({required this.icon, required this.desc, required this.temp, required this.feellike, required this.humidity,
    required this.wind, required this.pressure});

  String getIcon() {return icon;}
  String getDesc() {return desc;}
  double getTemp() {return temp;}
  double getFeel() {return feellike;}
  double getHumidity() {return humidity;}
  double getWind() {return wind;}
  double getPressure() {return pressure;}


  factory Weather.fromJson(Map<String, dynamic> json) {
    // print(json);
    return Weather(icon: json['weather'][0]['main'],
        desc: json['weather'][0]['description'],
        temp: json['main']['temp'], feellike: json['main']['feels_like'],
        humidity: json['main']['humidity'], wind: json['wind']['speed'],
        pressure: json['main']['pressure']) ;
  }

  @override
  String toString() {
    return 'Weather{icon: $icon, desc: $desc, temp: $temp, feellike: $feellike, humidity: $humidity, wind: $wind, pressure: $pressure}';
  }
}