class User {

  static int countID = 0;
  // field
  int? id;
  String name;
  String surname;
  int age;
  String? email;
  String password;


  User(this.name, this.surname, this.age, this.password){
    id = countID;
    ++countID;
    email = "$name.$surname@etu.umtp.fr";
  }

  String getName() {
    return name;
  }
  String getSurname() {
    return surname;
  }
  String? getMail() {
    return email;
  }
  // function
  void Afficher() {
    print("ID = $id");
    print("NOM = $name");
    print("Prenom = $surname");
    print("AGE = $age");
    print("MAIL = $email" );
    print("PASSWORD = $password");
  }
}