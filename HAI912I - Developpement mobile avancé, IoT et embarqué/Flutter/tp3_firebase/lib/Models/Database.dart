import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:firebase_core/firebase_core.dart';

import 'Question.dart';

class Database {

  static FirebaseFirestore getFirebase() {return FirebaseFirestore.instance;   }
  static CollectionReference getQuestionsCollection() {       return getFirebase().collection("questions") ; }

  static Future<void> addQuestion(Question q) {
    return getQuestionsCollection().add(q.toJson())
        .then((value) => print("Question added to firestore."))
        .catchError((error) => print("Cannot add question ${q.toString()} : $error"));
  }

  static Future<List<Question>> getQuestions(List<String> themes) async {
    List<Question> ret = [];

    QuerySnapshot query = await getQuestionsCollection().orderBy('theme').get();
    List<QueryDocumentSnapshot> docs = query.docs;
    for (var doc in docs) {
      if (doc.data() != null) {
        var data = doc.data() as Map<String, dynamic>;
        Question q = Question.fromJson(data);
        if (themes.isEmpty) {
          ret.add(q);
        }else {
          if (themes.contains(q.theme)) {
            ret.add(q) ;
          }
        }
      }
    }
    /*for(var q in ret) {
      print(q.toString()) ;
    }*/
    return ret;
  }

  static Future<List<String>> getThemes() async {
    Future<List<Question>> questions = getQuestions([]);
    List<String> ret = [];

    for (var q in (await questions))  {
      if (! ret.contains(q.theme)) {
        ret.add(q.theme) ;
      }
    }

    return ret;
  }



}