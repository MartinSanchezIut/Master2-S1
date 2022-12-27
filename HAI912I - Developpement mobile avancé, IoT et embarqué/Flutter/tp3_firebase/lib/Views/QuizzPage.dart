import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:tp3_firebase/Views/AddQuestion.dart';
import 'package:tp3_firebase/Views/HomePage.dart';

import '../Models/Question.dart';
import '../cubit/Quizz_cubit.dart';

class QuizzPage extends StatefulWidget {
  QuizzPage({Key? key}) : super(key: key);
  final String title = "Quizz Firebase";

  @override
  State<QuizzPage> createState() => QuizzPageState();
}

class QuizzPageState extends State<QuizzPage> {

  @override
  Widget build(BuildContext context) {
    String title = widget.title;
    final QuizzCubit quizzCubit = context.read<QuizzCubit>();

    Question question = quizzCubit.getQuestion() ;

    return Scaffold(
      backgroundColor: const Color(0x92DADBE0),
      appBar: _getAppBar(title),
      body: Container(
        alignment: Alignment.topCenter,
        child: Column(
          children: <Widget>[
            const SizedBox(height: 50),
            Text("Theme : ${question.theme}", textAlign: TextAlign.left,style: const TextStyle(color: Colors.black87,fontSize: 20,fontWeight: FontWeight.bold)),
            const SizedBox(height: 10) ,
            _getImage(img: question.img),
            const SizedBox(height: 50),
            _getQuestion(question),
            const SizedBox(height: 50),
            _getButtons(quizzCubit),
          ],
        ),
      ),
    );
  }



  AppBar _getAppBar(String title) {
    return AppBar(
      title: Text(title),
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

  Container _getQuestion(Question question) {
    return Container(
      alignment: Alignment.center,
      width: 300.00,
      child: Text(question.questionText,
          textAlign: TextAlign.left,style: const TextStyle(color: Colors.black87,fontSize: 20,fontWeight: FontWeight.bold)),
    );
  }

  Container _getButtons(QuizzCubit homepageCubit) {
    return Container(
        alignment: Alignment.center,
        child: Row(
          children: <Widget>[
            Expanded(
                child: TextButton(
                  style: _getBtnStyle(color: homepageCubit.getCorrect()),
                  onPressed: () { homepageCubit.answerQuestion() ; },
                  child: const Text("Vrai",
                      textAlign: TextAlign.left,style: TextStyle(color: Colors.black87,fontSize: 20,fontWeight: FontWeight.bold)),
                )
            ),
            Expanded(
                child: TextButton(
                  style: _getBtnStyle(color: homepageCubit.getWrong()),
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
