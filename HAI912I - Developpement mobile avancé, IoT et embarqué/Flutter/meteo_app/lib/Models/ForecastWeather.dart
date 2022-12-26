import 'package:meteo_app/Models/Ville.dart';
import 'package:meteo_app/Utils/WeatherApi.dart';

class ForecastWeather {
  String icon;
  String desc;

  double min;
  double max;

  double wind;

  String date;


  ForecastWeather({required this.icon, required this.desc,required this.min,
    required this.max,required this.wind,required this.date});

  String getIcon() {return icon;}
  String getDesc() {return desc;}
  double getMin() {return min;}
  double getMax() {return max;}
  double getWind() {return wind;}
  String getDate() {return date;}


  factory ForecastWeather.fromJson(Map<String, dynamic> json) {
    // print(json);
    return ForecastWeather(icon: json['weather'][0]['main'],
        desc: json['weather'][0]['description'],
        min: json['main']['temp_min'],
        max: json['main']['temp_max'],
        wind: json['wind']['speed'],
        date: json['dt_txt']);
  }

  @override
  String toString() {
    return 'ForecastWeather{icon: $icon, desc: $desc, min: $min, max: $max, wind: $wind, date: $date}';
  }
}