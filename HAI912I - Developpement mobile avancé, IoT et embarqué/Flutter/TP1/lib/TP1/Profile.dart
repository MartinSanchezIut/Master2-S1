import 'package:flutter/material.dart';
import 'User/User.dart';
import 'Quizzapp.dart';

class ProfileHomePage extends StatelessWidget {
  const ProfileHomePage({Key? key}) : super(key: key);
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: _getAppbar(),
      body: Container(
          alignment: Alignment.center,
          child: Column(
            children: [
              const SizedBox(height: 50),
              _getCard(User("Martin", "Sanchez", 22, "123123")),
              const SizedBox(height: 50),

              ElevatedButton(
                style: ElevatedButton.styleFrom(
                  primary: Colors.blue,
                  onPrimary: Colors.white,
                  shadowColor: Colors.blueAccent,
                  elevation: 3,
                  shape: RoundedRectangleBorder(
                      borderRadius: BorderRadius.circular(32.0)),
                  minimumSize: const Size(150, 75), //////// HERE
                ),
                onPressed: () {
                  Navigator.push(context, MaterialPageRoute(builder: (context) {
                     return const QuizzPage(title: 'Quizz');
                  }));
                },
                child: const Text("Quizz", style: TextStyle(fontWeight: FontWeight.bold, fontSize: 24),),


              )

            ],
          ),
      ),
    );
  }

  AppBar _getAppbar() {
    return AppBar(
      title: const Text("Profil"),
      centerTitle: true,
    );
  }


  CircleAvatar _getAvatar() {
    return const CircleAvatar(
      backgroundColor: Colors.blue,
      radius: 80,
      backgroundImage: AssetImage('images/image.jpg'),
    );
  }

  SizedBox _getCard(User usr) {
    return SizedBox(
        width: 500,
        height: 300,
        child: Card(
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              crossAxisAlignment: CrossAxisAlignment.center,
              children: [
                const CircleAvatar(
                  backgroundColor: Colors.blue,
                  radius: 80,
                  backgroundImage: AssetImage('images/image.jpg'),
                ),
                ListTile(
                  title: Text("Bonjour ${usr.getName()} ${usr.getSurname()}"),
                  leading: const Icon(
                      Icons.face
                  ),
                ),
                ListTile(
                    title: Text(usr.getMail().toString()),
                    leading: const Icon(
                        Icons.mail
                    )
                )
              ],
            )
        )
    );
  }
}
