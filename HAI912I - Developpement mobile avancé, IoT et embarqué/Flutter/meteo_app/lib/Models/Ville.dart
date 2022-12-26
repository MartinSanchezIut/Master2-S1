class Ville {
  String nom;
  String country;
  double lon;
  double lat;

  static Ville getDefaultCity() {
    // Montpellier ( lat:43.6112422, long:3.8767337 ) : FR
    return Ville(nom: "Montpellier", country: "FR", lat: 43.6112422, lon: 3.8767337) ;
  }

  Ville({required this.nom, required this.country,required this.lat,required this.lon});

  String getNom() {    return nom;  }
  double getLon() {    return lon;  }
  double getLat() {    return lat;  }
  String getCountry() {    return country;  }

  String toString() {
    return "$nom ( lat:$lat, long:$lon ) : $country" ;
  }

  factory Ville.fromJson(List<dynamic> json) {
    // print(json[0]);
    return Ville(nom: json[0]['name'],
                lon: json[0]['lon'],
                lat: json[0]['lat'],
                country: json[0]['country']);
  }
}
