import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:font_awesome_flutter/font_awesome_flutter.dart';
import 'package:intl/intl.dart';
import 'package:meteo_app/Models/ForecastList.dart';
import 'package:meteo_app/Models/Ville.dart';
import 'package:meteo_app/Utils/Utils.dart';
import 'package:meteo_app/Utils/WeatherApi.dart';
import  'package:intl/intl.dart';
import 'package:meteo_app/cubit/homepage_cubit.dart';

import '../Models/Weather.dart';

class WeatherPage extends StatefulWidget {
  WeatherPage({Key? key, required this.title}) : super(key: key);
  final String title;

  @override
  State<WeatherPage> createState() => WeatherPageState();
}

class WeatherPageState extends State<WeatherPage> {
  final TextEditingController searchController = TextEditingController();

  @override
  Widget build(BuildContext context) {
    final HomepageCubit homepageCubit = context.read<HomepageCubit>();
    return Scaffold(
      backgroundColor: const Color(0x92DADBE0),
      appBar: _getAppBar(title: widget.title),
      body: Container(
        alignment: Alignment.topCenter,
        child: Column(
          children: <Widget>[
            const SizedBox(height: 20),
            _getTextField(homepageCubit),
            const SizedBox(height: 30),
            _CityInformation(homepageCubit.getVille()),
            const SizedBox(height: 10),
            const Text("Météo d'aujourd'hui",
              style: TextStyle(fontWeight: FontWeight.bold, fontSize: 16.0),
            ),
            _getCurentWeather(homepageCubit.getCurrentWeather()),
            const SizedBox(height: 30),
            const Text("Prévisions pour les prochains jours",
              style: TextStyle(fontWeight: FontWeight.bold, fontSize: 16.0),
            ),
            _getForecast(homepageCubit.getForecast()),
          ],
        ),
      ),
    );
  }

  Widget _getForecast(ForecastList fl) {
    return Container(
        margin: const EdgeInsets.symmetric(vertical: 0.0),
        height: 200.0,
        child: ListView.builder(
            padding:
            const EdgeInsets.only(left: 8, top: 0, bottom: 0, right: 8),
            scrollDirection: Axis.horizontal,
            itemCount: fl.list.length,
            itemBuilder: (BuildContext context, int index) {
              return Container(
                  width: 125.0,
                  padding: const EdgeInsets.only(
                      left: 10, top: 15, bottom: 15, right: 10),
                  margin: const EdgeInsets.all(5),
                  decoration: BoxDecoration(
                      color: Colors.grey[350],
                      borderRadius: const BorderRadius.all(Radius.circular(18)),
                      boxShadow: [
                        BoxShadow(
                          color: Colors.grey.withOpacity(0.1),
                          spreadRadius: 2,
                          blurRadius: 2,
                          offset:
                          const Offset(0, 1), // changes position of shadow
                        )
                      ]),
                  child: Column(children: [
                    Text(fl.list[index].date, textAlign: TextAlign.center, style: const TextStyle(fontWeight: FontWeight.bold, fontSize: 14.0),),
                    const SizedBox(height: 15),
                    Utils.getWeatherIcon(description: fl.list[index].icon, size: 28),
                    const SizedBox(height: 2),
                    Text( fl.list[index].icon, textAlign: TextAlign.center,),
                    const SizedBox(height: 10),
                    Text("${fl.list[index].min}°", style: const TextStyle(fontWeight: FontWeight.bold, fontSize: 16.0),),
                    const SizedBox(height: 10),
                    const Icon(FontAwesomeIcons.wind, color: Colors.blue, size: 24.0),
                    Text("${fl.list[index].wind} km/h", textAlign: TextAlign.center,),
                  ]));
            }));
  }


  Widget _CityInformation(Ville v) {
    String cdate1 = DateFormat("EEEEE dd MMMM yyyy").format(DateTime.now());
    return Card(
      elevation: 8,
      shape:  OutlineInputBorder(
          borderRadius: BorderRadius.circular(15),
          borderSide: BorderSide(color: Colors.white, width: 0.1)
      ),
      shadowColor: Colors.blueGrey,
      color: Colors.grey[350],
      child: Center(
        child: Column(
          children: [
            const SizedBox(height: 5),
            Text("${v.nom}, ${v.country}"),
            Text(cdate1),
            const SizedBox(height: 5),
          ],
        ),
      ),
    );
  }


  Widget _getCurentWeather(Weather weather)  {
    return Card(
      shape:  OutlineInputBorder(
          borderRadius: BorderRadius.circular(15),
          borderSide: BorderSide(color: Colors.white, width: 0.1)
      ),
      color: Colors.grey[350],
      elevation: 8,
      shadowColor: Colors.blueGrey,
      child: Center(
        child: Column(
          children: [
            const SizedBox(height: 5),
            Column(
              children: [
                Utils.getWeatherIcon(description: weather.icon, size: 32.0),
                const SizedBox(height: 2),
                Text(weather.icon, textAlign: TextAlign.center,),
              ],
            ),
            const SizedBox(height: 30),
            Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Text("${weather.temp} ° (Ressenti: ${weather.feellike})"),
                const SizedBox(width: 30),
                Text(weather.desc),
              ],
            ),
            const SizedBox(height: 30),
            Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Column(
                  children: [
                    const Icon(FontAwesomeIcons.wind, color: Colors.blue, size: 32.0),
                    Text("${weather.wind} km/h", textAlign: TextAlign.center,),
                  ],
                ),
                const SizedBox(width: 30),
                Column(
                  children: [
                    const Icon(FontAwesomeIcons.water, color: Colors.blue, size: 32.0),
                    Text("${weather.humidity} %", textAlign: TextAlign.center,),
                  ],
                ),
                const SizedBox(width: 30),
                Column(
                  children: [
                    const Icon(FontAwesomeIcons.fan, color: Colors.blue, size: 32.0),
                    Text("${weather.humidity} hPa", textAlign: TextAlign.center,),
                  ],
                ),
              ],
            ),
            const SizedBox(height: 5),

          ],
        ),
      ),
    );

  }


  TextFormField _getTextField(HomepageCubit homepageCubit) {
    return TextFormField(
      controller: searchController,
      cursorColor: Colors.blue,
      decoration: InputDecoration(
        labelText: "Entrez la ville",
        suffixIcon: IconButton(
          icon: const Icon(Icons.search),
          color: Colors.blue,
          onPressed: () {   // TODO: LOGIQUE METIER
            // Futures : https://medium.com/flutter-community/a-guide-to-using-futures-in-flutter-for-beginners-ebeddfbfb967
            homepageCubit.changeVille(villeName: searchController.text) ;


//            WeatherApi.getCurentWeather(ville: homepageCubit.getVille()) ;
          },
        ),
        labelStyle: const TextStyle(color: Colors.black),
        focusedBorder: const OutlineInputBorder(
          borderSide: BorderSide(color: Colors.blue, width: 1.0),
        ),
      ),
    );
  }


  AppBar _getAppBar({required String title}) {
    return AppBar(
      title: Text(title),
      centerTitle: true,
    );
  }
}
