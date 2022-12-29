import 'package:flutter/material.dart';
import 'package:tp3_firebase/data/Models/Database.dart';
import 'package:tp3_firebase/presentation/Views/AddQuestion.dart';
import 'package:tp3_firebase/buisnesslogic/cubit/Quizz_cubit.dart';

import 'QuizzPage.dart';

class HomePage extends StatefulWidget {
  HomePage({Key? key, required this.title}) : super(key: key);
  final String title;

  @override
  State<HomePage> createState() => HomePageState();
}

class HomePageState extends State<HomePage> {

  List<String> selectedThemes = [] ;

  @override
  Widget build(BuildContext context) {
    String title = widget.title;

    return Scaffold(
      backgroundColor: const Color(0x92DADBE0),
      appBar: _getAppBar(title),
      body: Container(
        alignment: Alignment.topCenter,
        child: Column(
          children: <Widget>[
            const SizedBox(height: 50),
            const Text("Selectionnez les thèmes :", textAlign: TextAlign.center,style: TextStyle(color: Colors.black87,fontSize: 20,fontWeight: FontWeight.bold)),
            const SizedBox(height: 20),
            _getListOfThemes(),
            const SizedBox(height: 50),

            _getButton("Jouer !", () {
              QuizzCubit.themes = selectedThemes;
              Navigator.push(context, MaterialPageRoute(builder: (context) {
                return  QuizzPage();
              }));
            }),

            const SizedBox(height: 170),
            const Text("Ou, ajoutez des nouvelles questions :", textAlign: TextAlign.center,style: TextStyle(color: Colors.black87,fontSize: 20,fontWeight: FontWeight.bold)),
            const SizedBox(height: 50),
            _getButton("Ajouter une question", () {
              Navigator.push(context, MaterialPageRoute(builder: (context) {
                return  AddQuestion();
              }));
            }),

          ],
        ),
      ),
    );
  }

  Widget _getButton(String text, action) {
    return TextButton(
      style: _getBtnStyle(),
      onPressed: action,
      child: Text(text,
          textAlign: TextAlign.left,style: const TextStyle(color: Colors.black87,fontSize: 20,fontWeight: FontWeight.bold)),
    );
  }

  Widget _getListOfThemes() {
    return FutureBuilder(
        future: Database.getThemes(),
        builder: (context, snapshot) {
          if (snapshot.hasData &&
              snapshot.connectionState == ConnectionState.done) {

            return buildListOfTheme(snapshot.data!) ;
          }
          else {
            return const CircularProgressIndicator();
          }
        });
  }

  Widget buildListOfTheme(List<String> themes) {
    return Container(
        margin: const EdgeInsets.symmetric(vertical: 0.0),
        height: 50.0,
        child: ListView.builder(
            padding:
            const EdgeInsets.only(left: 8, top: 0, bottom: 0, right: 8),
            scrollDirection: Axis.horizontal,
            itemCount: themes.length,
            itemBuilder: (BuildContext context, int index) {
              return SizedBox(
                  width: 100.0,
                  child: TextButton(
                    style: _getBtnStyle(color: _getColor(themes[index])),
                    onPressed: () {
                      if (!selectedThemes.contains(themes[index])) {
                        setState(() {
                          selectedThemes.add(themes[index]) ;
                        });
                      }else {
                        setState(() {
                          selectedThemes.remove(themes[index]) ;
                        });
                      }
                    },
                    child: Text(themes[index],
                        textAlign: TextAlign.left,style: const TextStyle(color: Colors.black87,fontSize: 16)),
                  )
              );
            }));
  }

  Color _getColor(String theme){
    if (selectedThemes.contains(theme)) {
      return Colors.lightGreenAccent;
    }
    else { return Colors.blue; }
  }


  AppBar _getAppBar(String title) {
    return AppBar(
      title: Text(title),
      centerTitle: true,
    );
  }

  ButtonStyle _getBtnStyle({Color color=Colors.blue}) {
    return ElevatedButton.styleFrom(
      primary: color,
      onPrimary: Colors.white,
      shadowColor: Colors.blueAccent,
      elevation: 3,
      shape: RoundedRectangleBorder(
          borderRadius: BorderRadius.circular(32.0)),
      minimumSize: const Size(150, 75), //////// HERE
    );
  }
}
