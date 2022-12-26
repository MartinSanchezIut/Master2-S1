import 'package:flutter/material.dart';
import 'package:tp3_firebase/Models/Database.dart';
import 'package:tp3_firebase/Models/Question.dart';

import 'QuizzPage.dart';

class AddQuestion extends StatefulWidget {
  AddQuestion({Key? key}) : super(key: key);
  final String title = "Submiting question";

  @override
  State<AddQuestion> createState() => AddQuestionState();
}


class AddQuestionState extends State<AddQuestion> {

  final TextEditingController questionText = TextEditingController();
  final TextEditingController questionTheme = TextEditingController();
  final TextEditingController questionImage = TextEditingController();

  Color btnCorrect = Colors.grey;
  Color btnWrong = Colors.grey;
  Color btnOk = Colors.blue;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: const Color(0x92DADBE0),
      appBar: _getAppBar(widget.title),
      body: Container(
        alignment: Alignment.topCenter,
        child: Column(
          children: <Widget>[
            const SizedBox(height: 50),
            const Text("Ajoutez votre question : ", textAlign: TextAlign.left,style: TextStyle(color: Colors.black87,fontSize: 20,fontWeight: FontWeight.bold)),
            const SizedBox(height: 50),
            _getForm(),
          ],
        ),
      ),
    );
  }


  AppBar _getAppBar(String title) {
    return AppBar(
      title: Text(title),
      centerTitle: true,
      leading: IconButton(
        icon: const Icon(Icons.keyboard_return_sharp),
        tooltip: 'Retour au quizz',
        onPressed: () {
          Navigator.push(context, MaterialPageRoute(builder: (context) {
            return  QuizzPage(title: 'Quizz App with Firebase');
          }));
        },
      ),
    );
  }

  Widget _getForm() {
    return Column(
      children: [
        Padding(
          padding: const EdgeInsets.symmetric(horizontal: 8, vertical: 16),
          child: TextFormField(
            controller: questionText,
            decoration: const InputDecoration(
              border: UnderlineInputBorder(),
              labelText: 'Entrez le texte de la question',
            ),
          ),
        ),
        const SizedBox(height: 10,),
        Row(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            TextButton(
              style: _getBtnStyle(color: btnCorrect),
              onPressed: () {
                setState(() {
                  btnCorrect = Colors.green;
                  btnWrong = Colors.grey ;
                });
              },
              child: const Text("Vrai",
                  textAlign: TextAlign.left,style: TextStyle(color: Colors.black87,fontSize: 20,fontWeight: FontWeight.bold)),
            ),
            TextButton(
              style: _getBtnStyle(color: btnWrong),
              onPressed: () {
                setState(() {
                  btnCorrect = Colors.grey;
                  btnWrong = Colors.red ;
                });
              },
              child: const Text("Faux",
                  textAlign: TextAlign.left,style: TextStyle(color: Colors.black87,fontSize: 20,fontWeight: FontWeight.bold)),
            ),
          ],
        ),

        const SizedBox(height: 10,),
        Padding(
          padding: const EdgeInsets.symmetric(horizontal: 8, vertical: 16),
          child: TextFormField(
            controller: questionTheme,
            decoration: const InputDecoration(
              border: UnderlineInputBorder(),
              labelText: 'Entrez le theme de la question',
            ),
          ),
        ),
        const SizedBox(height: 10,),
        Padding(
          padding: const EdgeInsets.symmetric(horizontal: 8, vertical: 16),
          child: TextFormField(
            controller: questionImage,
            decoration: const InputDecoration(
              border: UnderlineInputBorder(),
              labelText: 'Entrez l\'url de l\'image (optionnel)',
            ),
          ),
        ),

        const SizedBox(height: 10,),

        TextButton(
          style: _getBtnStyle(color: btnOk),
          onPressed: () {
            String text = questionText.text;
            String theme = questionTheme.text;
            String img = questionImage.text;
            bool answer = (btnCorrect == Colors.green) ;

            bool valid = true;
            if (text == "") { valid = false; }
            if (!text.contains("?")) { valid = false; }
            if (text.length < 3) { valid = false; }
            if (theme == "") { valid = false; }



            if (valid) {
              Question addQuestion = Question(questionText: text, theme: theme, isCorrect: answer) ;
              if (img.isNotEmpty) {addQuestion.img = img ;}
              // print(addQuestion.toString()) ;
              Database.addQuestion(addQuestion) ;

              setState(() {
                btnOk = Colors.greenAccent ;
              });

            }else {
              ScaffoldMessenger.of(context).showSnackBar(const SnackBar(content: Text('Le formulaire n\'est pas valide')));
              setState(() {
                btnOk = Colors.redAccent ;
              });
            }

            Navigator.push(context, MaterialPageRoute(builder: (context) {
              return  QuizzPage(title: 'Quizz App with Firebase');
            }));

          },
          child: const Text("Ajouter ! ",
              textAlign: TextAlign.left,style: TextStyle(color: Colors.black87,fontSize: 20,fontWeight: FontWeight.bold)),
        ),
      ],
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