import 'package:flutter/material.dart';
import 'TP1/QuizzApp.dart';
import 'TP1/Profile.dart';

class HomePage extends StatelessWidget {
  const HomePage({Key? key}) : super(key: key);
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: _getAppbar(),
      body: Container(
        alignment: Alignment.center,
        child: Column(
          children: [
            const SizedBox(height: 50),
            _getButton("Profile", () {
              Navigator.push(context, MaterialPageRoute(builder: (context) {
                return const ProfileHomePage();
              }));
            }),
            const SizedBox(height: 50),
            _getButton("Quizz", () {
              Navigator.push(context, MaterialPageRoute(builder: (context) {
                return const QuizzPage(title: "Quizz");
              }));
            }),



          ],
        ),
      ),
    );
  }

  ElevatedButton _getButton(String text, onPress) {
    return ElevatedButton(
      style: ElevatedButton.styleFrom(
        primary: Colors.blue,
        onPrimary: Colors.white,
        shadowColor: Colors.blueAccent,
        elevation: 3,
        shape: RoundedRectangleBorder(
            borderRadius: BorderRadius.circular(32.0)),
        minimumSize: const Size(150, 75), //////// HERE
      ),
      onPressed: onPress,
      child: Text(text, style: TextStyle(fontWeight: FontWeight.bold, fontSize: 24),),
    );
  }

  AppBar _getAppbar() {
    return AppBar(
      title: const Text("Acceuil"),
      centerTitle: true,
    );
  }
}
