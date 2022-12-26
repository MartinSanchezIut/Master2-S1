import 'dart:ui';

import 'package:bloc/bloc.dart';
import 'package:flutter/material.dart';
import 'package:tp3_firebase/Models/QuestionRepository.dart';

import '../Models/Question.dart';
part 'Quizz_state.dart';

class QuizzCubit extends Cubit<QuizzState> {

  Question q;
  bool hasAnswered = false;
  Color correct = Colors.blue;
  Color wrong = Colors.blue;

  QuizzCubit({required this.q}) : super(InitialState(question: q));

  // InitialState(this.question, this.correct=Colors.blue, this.wrong=Colors.blue, this.hasAnwsered=false);

  void nextQuestion() {
    if (hasAnswered) {
      q = QuestionRepository().getAnotherQuestion(q);
      hasAnswered = false;
      correct = Colors.blue;
      wrong = Colors.blue;

      emit(InitialState(question: q, hasAnwsered: hasAnswered, wrong: wrong, correct: correct));
    }
  }

  void answerQuestion() {
    if (!hasAnswered) {
      if (q.isCorrect) {
        correct = Colors.green;
        wrong = Colors.red;
        hasAnswered = true;
        emit(InitialState(question: q, hasAnwsered: hasAnswered, wrong: wrong, correct: correct));
      } else {
        wrong = Colors.green;
        correct = Colors.red;
        hasAnswered = true;
        emit(InitialState(question: q, hasAnwsered: hasAnswered, wrong: wrong, correct: correct));
      }
    }
  }


  Question getQuestion() { return q;}
  bool getHasAnswered() { return hasAnswered ;}
  Color getCorrect() { return correct;}
  Color getWrong() { return wrong;}
}