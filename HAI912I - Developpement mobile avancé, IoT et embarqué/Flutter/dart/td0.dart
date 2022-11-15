class User {
	static int count_id = 0;

	int? id;
	String? name;
	int? age;
	String? email;
	String? psw;
	
	User(this.name, this.age, this.email, this.psw) {
		this.id = count_id +1;
		count_id++;
	}
	
	String toString() {
		return "$name ( $age ) : $email \n($id, $psw)" ;
	}
}

class Product {
	static int count_id = 0;

	int? id;
	String? name;
	int? price;
	String? date;
	
	Product(this.name, this.price, this.date){
		this.id = count_id +1;
		count_id++;
	}
	
	String toString() {
		return "$name ( $price ) : $date \n ($id)" ;
	}
}


main() {
	User u = new User("Paul", 22, "Paul@pipi.fr", "azerty");
	User u1 = new User("Paul", 22, "Paul@pipi.fr", "azerty");
	User u2 = new User("Paul", 22, "Paul@pipi.fr", "azerty");
	User u3 = new User("Paul", 22, "Paul@pipi.fr", "azerty");
	User u4 = new User("Paul", 22, "Paul@pipi.fr", "azerty");
	User u5 = new User("Paul", 22, "Paul@pipi.fr", "azerty");
	print(u5.toString()) ;
}