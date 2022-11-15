package me.sanchez.logging.Product;

public class Product {
    private static Long countID = 0L;

    private Long id;
    private String nom;
    private Double prix;
    private String expDate ;

    public Product(String nom, Double prix, String expDate) {
        this.id = countID + 1;  countID++;
        this.nom = nom;
        this.prix = prix;
        this.expDate = expDate;
    }

    public Long getId() { return id;}
    public String getNom() { return nom;}
    public void setNom(String nom) { this.nom = nom; }
    public Double getPrix() { return prix; }
    public void setPrix(Double prix) { this.prix = prix;}
    public String getExpDate() { return expDate;}
    public void setExpDate(String expDate) { this.expDate = expDate;    }
}
