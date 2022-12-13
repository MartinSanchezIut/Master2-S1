import 'package:cached_network_image/cached_network_image.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

import 'cubit/homepage_cubit.dart';

class HomePage extends StatelessWidget {
  const HomePage({Key? key, String? title}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    final homepageCubit = context.read<HomepageCubit>();
    return Scaffold(
      backgroundColor: const Color(0x92DADBE0),
      appBar: _getAppBar(),
      body: Container(
        alignment: Alignment.topCenter,
        child: Column(
          children: <Widget>[
            const SizedBox(height: 50),
            _getImage(img: homepageCubit.question.img),
            const SizedBox(height: 50),
            _getQuestion(homepageCubit.question.questionText),
            const SizedBox(height: 50),
            _getButtons(homepageCubit),


            Container(
            alignment: Alignment.center,
            width: 300.00,
            child: Text(homepageCubit.question.questionText,
            textAlign: TextAlign.left,style: const TextStyle(color: Colors.black87,fontSize: 20,fontWeight: FontWeight.bold)),
            )


          ],
        ),
      ),
    );
  }



  AppBar _getAppBar() {
    return AppBar(
      title: const Text("Quizz"),
      centerTitle: true,
    );
  }
  Container _getImage({String img="image.jpg"}) {
    return Container(
      alignment: Alignment.center,
      child: Container(
        width: 300.00,
        height: 300.00,
        decoration: BoxDecoration(
          image: DecorationImage(
            image: AssetImage('images/$img'),
            fit: BoxFit.fitHeight,
          ),
        ),
      ),
    );
  }

  Container _getQuestion(text) {
    return Container(
      alignment: Alignment.center,
      width: 300.00,
      child: Text(text,
          textAlign: TextAlign.left,style: const TextStyle(color: Colors.black87,fontSize: 20,fontWeight: FontWeight.bold)),
    );
  }

  Container _getButtons(homepageCubit) {
    return Container(
        alignment: Alignment.center,
        child: Row(
          children: <Widget>[
            Expanded(
                child: TextButton(
                  style: _getBtnStyle(color: homepageCubit.getcorrect),
                  onPressed: () { homepageCubit.answerQuestion() ; },
                  child: const Text("Vrai",
                      textAlign: TextAlign.left,style: TextStyle(color: Colors.black87,fontSize: 20,fontWeight: FontWeight.bold)),
                )
            ),
            Expanded(
                child: TextButton(
                  style: _getBtnStyle(color: homepageCubit.getcorrect),
                  onPressed: () { homepageCubit.answerQuestion() ;},
                  child: const Text("Faux",
                      textAlign: TextAlign.left,style: TextStyle(color: Colors.black87,fontSize: 20,fontWeight: FontWeight.bold)),
                )
            ),
            Expanded(
                child: TextButton(
                  style: _getBtnStyle(),
                  onPressed: () { homepageCubit.nextQuestion(); },
                  child: const Text("-->",
                      textAlign: TextAlign.left,style: TextStyle(color: Colors.black87,fontSize: 20,fontWeight: FontWeight.bold)),
                )
            ),
          ],
        )

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
