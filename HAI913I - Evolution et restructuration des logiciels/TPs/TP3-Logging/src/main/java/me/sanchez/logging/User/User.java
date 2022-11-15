package me.sanchez.logging.User;

public class User {
    private static Long countID = 0L;

    private Long id;
    private String nom;
    private Integer age;
    private String email;
    private String password;

    public User(String nom, Integer age, String email, String password) {
        this.id = countID + 1 ; countID += 1;
        this.nom = nom;
        this.age = age;
        this.email = email;
        this.password = password;
    }

    public Long getId() { return id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public Integer getAge() { return age;   }
    public void setAge(Integer age) { this.age = age;}
    public String getEmail() { return email;}
    public void setEmail(String email) { this.email = email;}
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password;}
}
