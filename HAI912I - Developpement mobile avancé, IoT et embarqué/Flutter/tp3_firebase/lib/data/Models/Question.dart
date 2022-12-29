class Question {
  String questionText;
  bool isCorrect;
  String img;
  String theme ;

  Question({required this.questionText, required this.theme,
          required this.isCorrect, this.img="noimage.jpg"});


  factory Question.fromJson(Map<dynamic, dynamic> json) => Question(
      questionText: json['questionText'] as String,
      isCorrect: json['isCorrect'] as bool,
      img: json['img'] as String,
      theme: json['theme'] as String);


  Map<String, dynamic> toJson() => <String, dynamic>{
    'questionText': questionText,
    'isCorrect': isCorrect,
    'img': img,
    'theme': theme,
  };


  @override
  String toString() {
    return 'Question{questionText: $questionText, isCorrect: $isCorrect, img: $img, theme: $theme}';
  }
}