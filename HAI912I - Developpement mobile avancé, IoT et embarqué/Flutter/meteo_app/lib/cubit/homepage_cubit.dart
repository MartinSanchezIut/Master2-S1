import 'dart:ui';

import 'package:bloc/bloc.dart';
import 'package:flutter/material.dart';
import 'package:meta/meta.dart';
import 'package:meteo_app/Models/ForecastList.dart';

import '../Models/Ville.dart';
import '../Models/Weather.dart';
import '../Utils/WeatherApi.dart';

part 'homepage_state.dart';

class HomepageCubit extends Cubit<HomepageState> {
  Ville v;
  Weather curent;
  ForecastList forecast = ForecastList();

  HomepageCubit({required this.v, required this.curent}) : super(HomepageInitial(ville: v, curent: curent)) {
//    curent = WeatherApi.getCurentWeather(ville: v);
      changeVille(villeName: "Montpellier") ;
  }

  void changeVille({required String villeName}) async {
    Future<Ville> future_v = WeatherApi.getCity(cityName: villeName) ;
    v =  (await future_v) ;

    Future<Weather> future_w = WeatherApi.getCurentWeather(ville: v) ;
    curent =  (await future_w) ;

    Future<ForecastList> future_fw = WeatherApi.getForecastWeather(ville: v) ;
    forecast =  (await future_fw);

    emit(HomepageInitial(ville: v, curent: curent)) ;
  }

  Ville getVille() { return v ; }
  Weather getCurrentWeather() { return curent;   }
  ForecastList getForecast() { return forecast;   }
}