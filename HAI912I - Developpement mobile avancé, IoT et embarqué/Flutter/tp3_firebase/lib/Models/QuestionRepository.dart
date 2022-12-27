import 'package:tp3_firebase/Models/Database.dart';

import 'Question.dart';

class QuestionRepository {
  List<Question> questions = [];

  QuestionRepository(this.questions);


  bool equals(Question q1, Question q2) {
    if (q1.questionText == q2.questionText) {
      return true;
    }
    return false;
  }

  List<Question> getQuestions() {
    return questions;
  }

  Question getRandomQuestion() {
    return (questions.toList()..shuffle()).first;
  }
  Question getAnotherQuestion(Question q1) {
    if (questions.length < 2 ) {
      return questions[0] ;
    }
    Question next =  (questions.toList()..shuffle()).first;
    while (equals(next, q1)) {
      next =  (questions.toList()..shuffle()).first;
    }
    return next;
  }



  static List<Question> basicListOfQuestions(){
    List<Question> ret = [] ;
    ret.add(Question(questionText: "1+1 = 2 ?", theme: "Math", isCorrect: true, img:"calc.jpg"));
    ret.add(Question(questionText: "1*1 = 2 ?", theme: "Math", isCorrect: false, img:"calc.jpg"));
    ret.add(Question(questionText: "1-1 = 2 ?", theme: "Math", isCorrect: false, img:"calc.jpg"));
    ret.add(Question(questionText: "1/1 = 1 ?", theme: "Math", isCorrect: true, img:"calc.jpg"));

    ret.add(Question(questionText: "Cette question est elle vrai ?",theme: "Aucun", isCorrect: true));
    ret.add(Question(questionText: "Le cheval blanc d'Henry 4 était-il brun ?",theme: "Aucun", isCorrect: false));
    ret.add(Question(questionText: "Cette question est elle vrai ?",theme: "Aucun", isCorrect: true));

    ret.add(Question(questionText: "La capitale de l'espagne est Madrid ?",theme: "Espagne", isCorrect: true, img: "esp.jpg"));
    ret.add(Question(questionText: "La capitale de l'espagne est Barcelone ?",theme: "Espagne", isCorrect: false, img: "esp.jpg"));
    ret.add(Question(questionText: "La paela est un plat typique espagnol ?",theme: "Espagne", isCorrect: true, img: "esp.jpg"));


    ret.add(Question(questionText: "Il faut chaud en ce moment ?",theme: "Meteo", isCorrect: true));
    ret.add(Question(questionText: "Il faut chaud en ce moment ?",theme: "Meteo", isCorrect: false));
    ret.add(Question(questionText: "Il fait bon en Antarctique ?",theme: "Meteo", isCorrect: true));


    ret.add(Question(questionText: "La france a gagne la coupe du monde de foot en 2018 ?",theme: "Foot", isCorrect: true, img: "foot.jpg"));
    ret.add(Question(questionText: "Ce personnage est il connu ?",theme: "Kaamelott", isCorrect: true, img: "image.jpg"));
    return ret ;
  }
}