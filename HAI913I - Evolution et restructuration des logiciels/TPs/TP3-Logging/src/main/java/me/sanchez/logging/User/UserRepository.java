package me.sanchez.logging.User;

import me.sanchez.logging.Product.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class UserRepository {

    final Logger logger =  LoggerFactory.getLogger(UserRepository.class);

    private ArrayList<User> users;

    public UserRepository() {
        users = new ArrayList<>();
        //     public User(String nom, Integer age, String email, String password) {
        users.add(new User("Piere", 30, "Piere@mail.fr", "123"));
        users.add(new User("Paul", 42, "Paul@mail.fr", "123"));
        users.add(new User("Hyves", 14, "Hyves@mail.fr", "123"));
        users.add(new User("Berangere", 4, "Berangere@mail.fr", "123"));
        users.add(new User("Huguette", 55, "Huguette@mail.fr", "123"));
        users.add(new User("Sylvie", 11, "Sylvie@mail.fr", "123"));
        users.add(new User("Hermione", 22, "Hermione@mail.fr", "123"));
        users.add(new User("Bernard", 28, "Bernard@mail.fr", "123"));
        users.add(new User("Bernadette", 18, "Bernadette@mail.fr", "123"));
    }

    public void addUser(User u) throws Exception {
        if (users.contains(u)) {
            throw new Exception("Already known user") ;
        }
        users.add(u) ;
        logger.info("User with id = " + u.getId() + " add to UserRepository");
    }

    public User getUserById(Long id) {
        for (User u : users) {
            if (u.getId() == id)
                return u;
        }
        return null;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void removeUser(Long id) {
        users.removeIf(u -> u.getId() == id);
    }

    public void editUser(Long id, User u) throws Exception {
        removeUser(id);
        addUser(u);
    }
}
