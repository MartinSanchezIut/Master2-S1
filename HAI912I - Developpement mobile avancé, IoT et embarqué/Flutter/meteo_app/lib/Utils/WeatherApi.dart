import 'dart:convert';

import 'package:meteo_app/Models/ForecastList.dart';
import 'package:meteo_app/Models/Ville.dart';
import 'package:http/http.dart' as http;
import 'package:meteo_app/Utils/Utils.dart';

import '../Models/Weather.dart';


class WeatherApi {
  static Future<Ville> getCity({required String cityName}) async {
    var finalUrl = "http://api.openweathermap.org/geo/1.0/direct?q=$cityName&appid=${Utils.getApiKey()}";
    final response = await http.get(Uri.parse(finalUrl));
    print("Resolve city coordinate from name : ${Uri.encodeFull(finalUrl)}");

    if (response.statusCode == 200) {
      //print("data: ${response.body}}") ;
      return Ville.fromJson(json.decode(response.body));
    } else {
      throw Exception("Cannot get $cityName coordinates");
    }
  }


  static Future<Weather> getCurentWeather({required Ville ville}) async {
    var finalUrl = "https://api.openweathermap.org/data/2.5/weather?lat=${ville.getLat()}&lon=${ville.getLon()}&units=metric&appid=${Utils.getApiKey()}";
    final response = await http.get(Uri.parse(finalUrl));
    print("Resolve curent weather for ${ville.getNom()} : ${Uri.encodeFull(finalUrl)}");

    if (response.statusCode == 200) {
     // print("data: ${response.body}}") ;
      return Weather.fromJson(json.decode(response.body));
    } else {
      throw Exception("Cannot get ${ville.nom} weather");
    }
  }

  static Future<ForecastList> getForecastWeather({required Ville ville}) async {
    var finalUrl = "https://api.openweathermap.org/data/2.5/forecast?q=${ville.getNom()}&cnt=100&units=metric&appid=${Utils.getApiKey()}";
    final response = await http.get(Uri.parse(finalUrl));
    print("Resolve forecast weather for ${ville.getNom()} : ${Uri.encodeFull(finalUrl)}");

    if (response.statusCode == 200) {
      // print("data: ${response.body}}") ;
      return ForecastList.fromJson(json.decode(response.body));
    } else {
      throw Exception("Cannot get ${ville.nom} forecast weather");
    }
  }
}