class Question {
  String questionText;
  bool isCorrect;
  String img;
  String theme ;

  Question({required this.questionText, required this.theme,
          required this.isCorrect, this.img="noimage.jpg"});

  @override
  String toString() {
    return 'Question{questionText: $questionText, isCorrect: $isCorrect, img: $img, theme: $theme}';
  }
}