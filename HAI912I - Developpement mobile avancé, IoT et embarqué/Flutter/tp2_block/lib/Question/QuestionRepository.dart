import 'Question.dart';

class QuestionRepository {
  List<Question> questions = [];


  QuestionRepository(){
    questions.add(Question(questionText: "1+1 = 2 ?", isCorrect: true, img:"calc.jpg"));
    questions.add(Question(questionText: "Cette question est elle vrai ?", isCorrect: true));
    questions.add(Question(questionText: "La capitale de la france c'est paris ?", isCorrect: true));
    questions.add(Question(questionText: "Capgemini m'as recrute?", isCorrect: false));
    questions.add(Question(questionText: "Il faut chaud en ce moment ?", isCorrect: false));
    questions.add(Question(questionText: "L'espagne est meilleure au foot que la france ?", isCorrect: false, img: "esp.jpg"));
    questions.add(Question(questionText: "La france a gagne la coupe du monde de foot en 2018 ?", isCorrect: true));
    questions.add(Question(questionText: "On est vraiment pas surmene par le travail en master 2 ?", isCorrect: false));
    questions.add(Question(questionText: "Ce personnage est il connu ?", isCorrect: true, img: "image.jpg"));
  }

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
    Question next =  (questions.toList()..shuffle()).first;
    while (equals(next, q1)) {
      next =  (questions.toList()..shuffle()).first;
    }
    return next;
  }
}