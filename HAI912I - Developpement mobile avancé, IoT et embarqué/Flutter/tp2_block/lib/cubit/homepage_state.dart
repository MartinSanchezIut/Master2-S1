part of 'homepage_cubit.dart';

@immutable
abstract class HomepageState {}

class HomepageInitial extends HomepageState {
  Question question;
  Color correct = Colors.blue;
  Color wrong = Colors.blue;
  bool hasAnwsered = false;

  HomepageInitial({required this.question, this.correct=Colors.blue, this.wrong=Colors.blue, this.hasAnwsered=false});



  @override
  String toString() {
    return 'HomepageInitial{question: ${question.toString()}, correct: $correct, wrong: $wrong, hasAnwsered: $hasAnwsered}';
  }
}
