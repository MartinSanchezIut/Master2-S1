import 'package:firebase_core/firebase_core.dart';
import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:tp3_firebase/presentation/Views/HomePage.dart';
import 'package:tp3_firebase/presentation/Views/QuizzPage.dart';

import 'buisnesslogic/cubit/Quizz_cubit.dart';
import 'data/Models/Question.dart';
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
        create: (_) => QuizzCubit(q: Question(questionText: "Répondez par vrai ou par faux aux question qui vont vous être posés. Compris ?", theme: "Tutoriel", isCorrect: true)),
        child: BlocBuilder<QuizzCubit, QuizzState>(
          builder: (_, theme) {
            return MaterialApp(
              title: 'Quizz App Martin',
              theme: ThemeData(),
              home: HomePage(title: 'QuizzApp with Firebase'),
            );
          },
        ));
  }
}