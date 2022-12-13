package me.sanchez.logging.CLI;

import me.sanchez.logging.Product.Product;
import me.sanchez.logging.Product.ProductRepository;
import me.sanchez.logging.User.User;
import me.sanchez.logging.User.UserRepository;

import java.sql.SQLOutput;
import java.util.Scanner;

public class CLI {
    private UserRepository user = new UserRepository() ;
    private ProductRepository product = new ProductRepository();

    private Scanner sc ;
    private User usr = null;
    public CLI() throws Exception {
        sc = new Scanner(System.in) ;

        while (true) {
            printOptions();
            processOption();
        }
    }

    private void printOptions() {
        if (usr == null) {
            System.out.println("[1] Register");
            System.out.println("[2] Login");
        }else {
            System.out.println("[1] Show all products");
            System.out.println("[2] Product by id");
            System.out.println("[3] Add product");
            System.out.println("[4] Delete product by id");
            System.out.println("[5] Update product by id");
        }
    }

    private void processOption() throws Exception {
        int choice = -1;
        if (usr == null) {
            switch (sc.nextInt()) {
                case 1:
                    registerPage();
                    break;
                case 2:
                    loginPage();
                    break;
                default:
                    System.exit(0);
            }
        }else {
            switch (sc.nextInt()) {
                case 1:
                    for(Product p : product.getProduct()) { System.out.println(p); }
                    break;
                case 2:
                    System.out.println("Id du produit : ");
                    long id = sc.nextLong();
                    System.out.println(product.getProductById(id)) ;
                    break;
                case 3:
                    System.out.println("Nom du produit: ");
                    String nom = sc.next();
                    System.out.println("Prix du produit: ");
                    double prix = sc.nextDouble();
                    System.out.println("Date d'expiration: ");
                    String date = sc.next();
                    product.addProduct(new Product(nom, prix, date));
                    break;
                case 4:
                    System.out.println("Id du produit : ");
                    id = sc.nextLong();
                    product.removeProduct(id) ;
                    System.out.println("Done");
                    break;
                case 5:
                    System.out.println("Id du produit : ");
                    id = sc.nextLong();
                    System.out.println("Nouveau nom du produit: ");
                    nom = sc.next();
                    System.out.println("Nouveau prix du produit: ");
                    prix = sc.nextDouble();
                    System.out.println("Nouvelle date d'expiration: ");
                    date = sc.next();
                    product.editProduct(id ,new Product(nom, prix, date));
                    break;
                default:
                    System.exit(0);
            }
        }
    }

    private void loginPage() {
        String emailInput = "";
        String pwInput = "";
        do{
            System.out.println("[Login] Email :");
            emailInput = sc.next() ;

            System.out.println("[Login] Password :");
            pwInput = sc.next() ;

            usr = user.login(emailInput, pwInput) ;
        }while (usr == null) ;
        System.out.println("[Login] Successfully logged in.");

    }
    private void registerPage() throws Exception {
        String emailInput = "";
        String pwInput = "";
        String nomInput = "";
        int ageInput ;

        System.out.println("[Register] Email :");
        emailInput = sc.next() ;

        System.out.println("[Register] Nom :");
        nomInput = sc.next() ;

        System.out.println("[Register] Age :");
        ageInput = sc.nextInt() ;

        System.out.println("[Register] Password :");
        pwInput = sc.next() ;

        user.addUser(new User(nomInput,ageInput,emailInput,pwInput));

        loginPage();
    }


    public static void main(String[] args) throws Exception {
        CLI cli = new CLI();
    }
}
