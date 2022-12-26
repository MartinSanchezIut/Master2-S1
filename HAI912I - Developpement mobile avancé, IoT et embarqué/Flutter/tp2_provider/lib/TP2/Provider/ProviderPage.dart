import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

import 'DataProvider.dart';

class ProviderPage extends StatelessWidget {
  const ProviderPage({Key? key}) : super(key: key);

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
            _getImage(img: Provider.of<QuizzModel>(context, listen: true).question.img),
            const SizedBox(height: 50),
            _getQuestion(context),
            const SizedBox(height: 50),
            _getButtons(context),

          ],
        ),
      ),
    );
  }

  Container _getButtons(context) {
    return Container(
        alignment: Alignment.center,
        child: Row(
          children: <Widget>[
            Expanded(
                child: TextButton(
                  style: _getBtnStyle(color:  Provider.of<QuizzModel>(context, listen: true).correct ),
                  onPressed: () {
                    Provider.of<QuizzModel>(context, listen: false).answerQuestion() ;
                  },
                  child: const Text("Vrai",
                      textAlign: TextAlign.left,style: TextStyle(color: Colors.black87,fontSize: 20,fontWeight: FontWeight.bold)),
                )
            ),
            Expanded(
                child: TextButton(
                  style: _getBtnStyle(color:   Provider.of<QuizzModel>(context, listen: true).wrong),
                  onPressed: () {
                    Provider.of<QuizzModel>(context, listen: false).answerQuestion();
                  },
                  child: const Text("Faux",
                      textAlign: TextAlign.left,style: TextStyle(color: Colors.black87,fontSize: 20,fontWeight: FontWeight.bold)),
                )
            ),
            Expanded(
                child: TextButton(
                  style: _getBtnStyle(),
                  onPressed: () {
                    Provider.of<QuizzModel>(context, listen: false).changeQuestion() ;
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

  Container _getQuestion(context) {
    return Container(
      alignment: Alignment.center,
      width: 300.00,
      child: Text(Provider.of<QuizzModel>(context, listen: true).question.questionText,
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
      title: const Text("Quizz Provider"),
      centerTitle: true,
    );
  }
}