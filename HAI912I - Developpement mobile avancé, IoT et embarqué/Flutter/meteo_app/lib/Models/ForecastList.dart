import 'package:intl/intl.dart';

import 'ForecastWeather.dart';

class ForecastList {

  List<ForecastWeather> list = [] ;
  ForecastList();

  List<ForecastWeather> getForecastList() {    return list;   }

  factory ForecastList.fromJson(Map<String, dynamic> json) {
    // print(json);
    ForecastList list = ForecastList() ;
    int count = json['cnt'] ;
    String today = DateFormat("yyyy-MM-dd").format(DateTime.now());

    for (int i=0; i<count; i++) {
        ForecastWeather parsedForecast = ForecastWeather.fromJson(json['list'][i]) ;
        if (parsedForecast.date.split(" ")[0] != today) {
            String hour = parsedForecast.date.split(" ")[1];
            if (hour == "12:00:00") {
              parsedForecast.date = parsedForecast.date.split(" ")[0];
              list.getForecastList().add(parsedForecast);
            }
        }
    }
   // print(list.list);
    return list;
  }
}