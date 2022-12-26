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

  static Future<List<Question>> getQuestions() async {
    List<Question> ret = [];

    QuerySnapshot query = await getQuestionsCollection().orderBy('theme').get();
    List<QueryDocumentSnapshot> docs = query.docs;
    for (var doc in docs) {
      if (doc.data() != null) {
        var data = doc.data() as Map<String, dynamic>;
        ret.add(Question.fromJson(data)) ;
      }
    }
    return ret;
  }



}