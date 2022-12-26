import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';

import 'Question/Question.dart';
import 'Question/QuestionRepository.dart';
import 'cubit/homepage_cubit.dart';
import 'QuizzPage.dart';

void main() => runApp(const MyApp());

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    QuestionRepository repo = QuestionRepository() ;
    return BlocProvider(
      create: (_) => HomepageCubit(q: repo.getRandomQuestion()),
      child: BlocBuilder<HomepageCubit, HomepageState>(
        builder: (_, theme) {
          return MaterialApp(
            title: 'First Flutter App Martin',
            theme: ThemeData(),
            home: HomePage(title: "QuizzApp"),
          );
        },
      ));
  }
}
