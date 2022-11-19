package me.sanchez.logging.Product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class Product {
    final Logger logger =  LoggerFactory.getLogger(Product.class);

    private Long id;
    private String nom;
    private Double prix;
    private String expDate ;
    private static Long countID = 0L;


    public Product(String nom, Double prix, String expDate) {
        this.id = countID;++countID;
        this.nom = nom;
        this.prix = prix;
        this.expDate = expDate;

        logger.info("Product ID = " + id +'\n' +
                "Product Nom = " + nom +'\n' +
                "Product Prix = " + prix +'\n' +
                "Product Date Expiration = " + expDate);
    }
    public Long getId() { return id;}
    public String getNom() { return nom;}
    public void setNom(String nom) { this.nom = nom; }
    public Double getPrix() { return prix; }
    public void setPrix(Double prix) { this.prix = prix;}
    public String getExpDate() { return expDate;}
    public void setExpDate(String expDate) { this.expDate = expDate;    }
    public void setId(Long id){this.id = id;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(nom, product.nom) && Objects.equals(prix, product.prix) && Objects.equals(expDate, product.expDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, prix, expDate);
    }
}
