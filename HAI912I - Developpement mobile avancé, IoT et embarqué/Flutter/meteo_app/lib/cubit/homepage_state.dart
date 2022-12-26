part of 'homepage_cubit.dart';

@immutable
abstract class HomepageState {}

class HomepageInitial extends HomepageState {
  Ville ville;
  Weather curent;


  HomepageInitial({required this.ville, required this.curent});
}
