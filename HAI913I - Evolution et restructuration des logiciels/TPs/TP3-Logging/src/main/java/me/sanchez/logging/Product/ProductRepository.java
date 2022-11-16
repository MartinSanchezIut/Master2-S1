package me.sanchez.logging.Product;



import java.util.ArrayList;

public class ProductRepository {

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
    }

    public Product getProductById(int id) throws Exception{
        for (Product u : products) {
            if (u.getId() == id)
                return u;
        }
        throw new Exception("Product not found") ;
    }

    public ArrayList<Product> getProduct() {
        return products;
    }

    public void removeProduct(int id) {
        products.removeIf(u -> u.getId() == id);
    }

    public void editProduct(int id, Product u) throws Exception {
        removeProduct(id);
        addProduct(u);
    }
}
