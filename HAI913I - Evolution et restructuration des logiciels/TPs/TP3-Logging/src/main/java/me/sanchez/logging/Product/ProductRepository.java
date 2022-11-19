package me.sanchez.logging.Product;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class ProductRepository {
    final Logger logger =  LoggerFactory.getLogger(ProductRepository.class);
    private ArrayList<Product> products;

    public ProductRepository() {
        products = new ArrayList<>();
        //         public Product(String nom, Double prix, String expDate) {
        products.add(new Product("Andives", 1.0, "01-01-2023"));
        products.add(new Product("Tomates", 1.0, "01-01-2023"));
        products.add(new Product("Pommes", 1.0, "01-01-2023"));
        products.add(new Product("Patates", 1.0, "01-01-2023"));
        products.add(new Product("Riz", 1.0, "01-01-2023"));
        products.add(new Product("Pates", 1.0, "01-01-2023"));
        products.add(new Product("Poivrons", 1.0, "01-01-2023"));
    }

    public void addProduct(Product u) throws Exception {
        if (products.contains(u)) {
            throw new Exception("Already known product") ;
        }
        products.add(u) ;
        logger.info("Product ID = " + u.getId() + " add to ProductRepository");
    }

    public Product getProductById(Long id) throws Exception{
            for (Product u : products) {
                if (u.getId() == id){
                    logger.info("Product ID = " + id + " is found");
                    return u;
                }
            }
            logger.info("Product ID = " + id + " is not found");
            throw new Exception("Product not found") ;

    }

    public ArrayList<Product> getProduct() {
        return products;
    }

    public void removeProduct(Long id) throws Exception {
        products.remove(getProductById(id));
        logger.info("Product with id = " + id + " is remove");
    }

    public void editProduct(Long id, Product u) throws Exception {
        removeProduct(id);
        addProduct(u);
        logger.info("Product with id = " + id + " is edit");
    }
}
