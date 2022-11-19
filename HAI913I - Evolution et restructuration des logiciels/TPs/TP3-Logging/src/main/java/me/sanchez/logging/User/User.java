package me.sanchez.logging.User;

import me.sanchez.logging.Product.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class User {
    private static Long countID = 0L;
    final Logger logger =  LoggerFactory.getLogger(User.class);
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
        logger.info("User ID = " + id +'\n' +
                "User Nom = " + nom +'\n' +
                "User age = " + age +'\n' +
                "User email = " + email+'\n' +
                        "User password = " + password+'\n'
                );
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(nom, user.nom) && Objects.equals(age, user.age) && Objects.equals(email, user.email) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, age, email, password);
    }
}
