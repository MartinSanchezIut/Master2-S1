// importation du paquetage pour utiliser Material Design
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'TP2/Provider/DataProvider.dart';
import 'TP2/Provider/ProviderPage.dart';

void main() {
  runApp(const MyApp()); // point d'entrÃ©e
}

// Le widget racine de notre application
class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);
  @override
  Widget build(BuildContext context) {
    return ChangeNotifierProvider(
        create: (context) => QuizzModel(),
        child: MaterialApp(
          title: 'First Flutter App Martin',
          theme: ThemeData(),
          home: const ProviderPage() ,
        )
    );
  }
}