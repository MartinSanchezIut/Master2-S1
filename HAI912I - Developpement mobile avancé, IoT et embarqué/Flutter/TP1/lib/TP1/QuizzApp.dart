import 'package:flutter/material.dart';
import 'Question/Question.dart';
import 'Question/QuestionRepository.dart';


class QuizzPage extends StatefulWidget {
  const QuizzPage({Key? key, required this.title}) : super(key: key);


  final String title;

  @override
  State<QuizzPage> createState() => QuizzPageState();
}

class QuizzPageState extends State<QuizzPage> {

  Question question = QuestionRepository().getRandomQuestion();

  // QuestionRepository questions = new QuestionRepository();
  Color correct = Colors.blue;
  Color wrong = Colors.blue;
  bool hasAnwsered = false;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: const Color(0x92DADBE0),
      appBar: _getAppBar(),
      body: Container(
        alignment: Alignment.topCenter,
        child: Column(
          children: <Widget>[
            const SizedBox(height: 50),
            _getImage(img: question.img),
            const SizedBox(height: 50),
            _getQuestion(),
            const SizedBox(height: 50),
            _getButtons(),

          ],
        ),
      ),
    );
  }

  Container _getButtons() {
    return Container(
      alignment: Alignment.center,
      child: Row(
        children: <Widget>[
          Expanded(
            child: TextButton(
              style: _getBtnStyle(color: correct),
              onPressed: () {
                if (question.isCorrect) {
                  setState(() { correct = Colors.green; wrong = Colors.red; hasAnwsered = true;});
                }else {
                  setState(() { wrong = Colors.green; correct = Colors.red; hasAnwsered = true;});
                }
              },
              child: const Text("Vrai",
                  textAlign: TextAlign.left,style: TextStyle(color: Colors.black87,fontSize: 20,fontWeight: FontWeight.bold)),
            )
          ),
          Expanded(
              child: TextButton(
                style: _getBtnStyle(color: wrong),
                onPressed: () {
                  if (question.isCorrect) {
                    setState(() { correct = Colors.green; wrong = Colors.red; hasAnwsered = true;});
                  }else {
                    setState(() { wrong = Colors.green; correct = Colors.red; hasAnwsered = true;});
                  }
                },
                child: const Text("Faux",
                    textAlign: TextAlign.left,style: TextStyle(color: Colors.black87,fontSize: 20,fontWeight: FontWeight.bold)),
              )
          ),
          Expanded(
              child: TextButton(
                style: _getBtnStyle(),
                onPressed: () {
                  setState(() {
                    if (hasAnwsered) {
                      question = QuestionRepository().getAnotherQuestion(question);
                      correct = Colors.blue;
                      wrong = Colors.blue;
                      hasAnwsered = false;
                    }
                  });
                },
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

  Container _getQuestion() {
    return Container(
      alignment: Alignment.center,
      width: 300.00,
      child: Text(question.questionText,
              textAlign: TextAlign.left,style: const TextStyle(color: Colors.black87,fontSize: 20,fontWeight: FontWeight.bold)),
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


  AppBar _getAppBar() {
    return AppBar(
      title: const Text("Quizz"),
      centerTitle: true,
    );
  }

}