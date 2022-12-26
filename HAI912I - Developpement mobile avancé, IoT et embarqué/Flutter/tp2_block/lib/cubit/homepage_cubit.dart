import 'dart:ui';

import 'package:bloc/bloc.dart';
import 'package:flutter/material.dart';
import 'package:meta/meta.dart';

import '../Question/Question.dart';
import '../Question/QuestionRepository.dart';

part 'homepage_state.dart';

class HomepageCubit extends Cubit<HomepageState> {
  static QuestionRepository repo = QuestionRepository();

  Question q;
  bool givedAnswer = false;
  Color correct = Colors.blue;
  Color wrong = Colors.blue;
  HomepageCubit({required this.q}) : super(HomepageInitial(question: q));

// HomepageInitial(this.question, this.correct=Colors.blue, this.wrong=Colors.blue, this.hasAnwsered=false);

  void nextQuestion() {
    if (givedAnswer) {
      Question newQuestion = repo.getAnotherQuestion(q);
      q = newQuestion;
      givedAnswer = false;
      correct = Colors.blue;
      wrong = Colors.blue;
      print("Next is : ${q.questionText} (${q.isCorrect})");
      emit(HomepageInitial(question: newQuestion, hasAnwsered: givedAnswer, wrong: wrong, correct: correct));
    }
  }

  void answerQuestion() {
    if (!givedAnswer) {
      print("answerQuestion ! ");
      if (q.isCorrect) {
        correct = Colors.green;
        wrong = Colors.red;
        givedAnswer = true;
        emit(HomepageInitial(question: q, hasAnwsered: givedAnswer, wrong: wrong, correct: correct));
      } else {
        wrong = Colors.green;
        correct = Colors.red;
        givedAnswer = true;
        emit(HomepageInitial(question: q, hasAnwsered: givedAnswer, wrong: wrong, correct: correct));
      }
    }
  }

  Question get question => q;
  Color getcorrect() {
    return correct;
  }
  Color getwrong() {
    return wrong;
  }
    bool get hasAnswer => givedAnswer;



}