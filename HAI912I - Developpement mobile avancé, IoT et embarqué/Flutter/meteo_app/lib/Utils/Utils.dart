import 'dart:ui';

import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:font_awesome_flutter/font_awesome_flutter.dart';

class Utils {

  static String getApiKey() { return "d6a83ed0cf76bba7334951013fd116e9" ;   }

  static Widget getWeatherIcon({required String description, required double size}) {
      switch(description) {
        case "Clear":
          { return Icon(FontAwesomeIcons.sun, color: Colors.blue, size: size) ; }
          break;
        case "Clouds":
          { return Icon(FontAwesomeIcons.cloud, color: Colors.blue, size: size) ; }
          break;
        case "Rain":
          { return Icon(FontAwesomeIcons.cloudRain, color: Colors.blue, size: size) ; }
          break;
        case "Snow":
          { return Icon(FontAwesomeIcons.snowman, color: Colors.blue, size: size) ; }
          break;
        default:
           { return Icon(FontAwesomeIcons.sun, color: Colors.blue, size: size) ; }
          break;
      }

  }

}