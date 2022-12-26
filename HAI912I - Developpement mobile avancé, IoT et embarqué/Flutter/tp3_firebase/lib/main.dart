import 'package:firebase_core/firebase_core.dart';
import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:tp3_firebase/Models/Database.dart';
import 'package:tp3_firebase/Models/Question.dart';
import 'package:tp3_firebase/Models/QuestionRepository.dart';
import 'package:tp3_firebase/Views/QuizzPage.dart';

import 'cubit/Quizz_cubit.dart';
import 'firebase_options.dart';

void main() async {
  WidgetsFlutterBinding.ensureInitialized();
  await Firebase.initializeApp(
    options: DefaultFirebaseOptions.currentPlatform,
  );
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return BlocProvider(
        create: (_) => QuizzCubit(q: Question(questionText: "Etes vous pret a commencer le quizz ?", theme: "Tp Flutter", isCorrect: true)),
        child: BlocBuilder<QuizzCubit, QuizzState>(
          builder: (_, theme) {
            return MaterialApp(
              title: 'Quizz App Martin',
              theme: ThemeData(),
              home: QuizzPage(title: 'Quizz App with Firebase'),
            );
          },
        ));
  }
}