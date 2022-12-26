import 'package:flutter/material.dart';
import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:meteo_app/Models/Ville.dart';
import 'package:meteo_app/Utils/WeatherApi.dart';
import 'package:meteo_app/cubit/homepage_cubit.dart';
import 'Models/Weather.dart';
import 'View/WeatherApp.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return BlocProvider(
        create: (_) => HomepageCubit(v: Ville.getDefaultCity(), curent: Weather.getDefaultWeather()),
        child: BlocBuilder<HomepageCubit, HomepageState>(
          builder: (_, theme) {
            return MaterialApp(
              title: 'Weather App Martin',
              theme: ThemeData(),
              home: WeatherPage(title: 'Weather App'),
            );
          },
        ));
  }
}