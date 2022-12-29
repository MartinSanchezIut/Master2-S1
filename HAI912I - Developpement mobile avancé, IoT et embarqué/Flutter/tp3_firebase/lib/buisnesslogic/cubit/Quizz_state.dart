part of 'Quizz_cubit.dart';

@immutable
abstract class QuizzState {}

class InitialState extends QuizzState {

  Question question;
  Color correct = Colors.blue;
  Color wrong = Colors.blue;
  bool hasAnwsered = false;

  InitialState({required this.question, this.correct=Colors.blue, this.wrong=Colors.blue, this.hasAnwsered=false});



  Question getQuestion() { return question;}
  bool getHasAnswered() { return hasAnwsered ;}
  Color getCorrect() { return correct;}
  Color getWrong() { return wrong;}


  @override
  String toString() {
    return 'InitialState{question: $question, correct: $correct, wrong: $wrong, hasAnwsered: $hasAnwsered}';
  }
}
