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
      print("nextQuestion ! ");
      Question newQuestion = repo.getAnotherQuestion(q);
      q = newQuestion;
      givedAnswer = false;
      print("Next is : ${q.questionText} (${q.isCorrect})");
      print(state.toString()) ;
      emit(HomepageInitial(question: newQuestion, hasAnwsered: givedAnswer, wrong: wrong, correct: correct));
      print(state.toString()) ;
    }
  }

  void answerQuestion() {
    if (!givedAnswer) {
      print("answerQuestion ! ");
      if (q.isCorrect) {
        print("Correct");
        Color correct = Colors.green;
        Color wrong = Colors.red;
        givedAnswer = true;
        emit(HomepageInitial(question: q, hasAnwsered: givedAnswer, wrong: wrong, correct: correct));
      } else {
        print("Wrong");
        Color wrong = Colors.green;
        Color correct = Colors.red;
        givedAnswer = true;
        emit(HomepageInitial(question: q, hasAnwsered: givedAnswer, wrong: wrong, correct: correct));
      }
    }
  }

  Question get question => q;
  Color get getcorrect => correct;
  Color get getwrong => wrong;
  bool get hasAnswer => givedAnswer;


}