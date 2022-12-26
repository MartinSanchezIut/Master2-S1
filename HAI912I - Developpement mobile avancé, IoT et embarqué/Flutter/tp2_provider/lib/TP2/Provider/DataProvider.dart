import 'package:flutter/material.dart';

import '../../Question/Question.dart';
import '../../Question/QuestionRepository.dart';

class QuizzModel extends ChangeNotifier {
  static QuestionRepository repo = QuestionRepository();
  Question question = repo.getRandomQuestion();

  Color correct = Colors.blue;
  Color wrong = Colors.blue;
  bool hasAnwsered = false;


  void answerQuestion() {
    print("anwser") ;
    hasAnwsered = true;
    if (question.isCorrect) {
      correct = Colors.green; wrong = Colors.red;
    }else {
      wrong = Colors.green; correct = Colors.red;
    }
    notifyListeners();
  }

  void changeQuestion() {
    print("change") ;
    if (hasAnwsered) {
      question = repo.getRandomQuestion();
      hasAnwsered = false;
      wrong = Colors.blue;
      correct = Colors.blue;
      notifyListeners();
    }
  }
}