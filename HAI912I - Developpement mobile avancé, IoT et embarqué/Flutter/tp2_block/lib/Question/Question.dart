class Question {
  String questionText;
  bool isCorrect;
  String img;
  Question({required this.questionText, required this.isCorrect, this.img="noimage.jpg"});

  @override
  String toString() {
    return 'Question{questionText: $questionText, isCorrect: $isCorrect, img: $img}';
  }
}