package me.sanchez.logging;

import me.sanchez.logging.Product.Product;
import me.sanchez.logging.Product.ProductRepository;

public class Main {

    public static void main(String[] args) throws Exception {

        ProductRepository produts = new ProductRepository();
        Product p =new Product("Ordi",1000.0,"09-09-2000");
        produts.addProduct(p);
        for(Product m : produts.getProduct()){
            System.out.println(m.getNom());
        }
        produts.removeProduct(0L);

        System.out.println("\n\n\n");
        for(Product m : produts.getProduct()){
            System.out.println(m.getNom());
        }
        produts.getProductById(2000L);

    }
}
