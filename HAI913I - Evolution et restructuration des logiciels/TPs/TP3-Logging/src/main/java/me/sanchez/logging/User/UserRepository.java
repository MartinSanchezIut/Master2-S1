package me.sanchez.logging.User;

import me.sanchez.logging.Product.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Objects;

public class UserRepository {

    final Logger logger =  LoggerFactory.getLogger(UserRepository.class);
    final String logprefix = "[UserRepository] - " ;

    private ArrayList<User> users;

    public UserRepository() {
        users = new ArrayList<>();
        //     public User(String nom, Integer age, String email, String password) {
        users.add(new User("Piere", 30, "Piere@mail.fr", "123"));
        users.add(new User("Toto", 30, "tot", "123"));
        users.add(new User("Paul", 42, "Paul@mail.fr", "123"));
        users.add(new User("Hyves", 14, "Hyves@mail.fr", "123"));
        users.add(new User("Berangere", 4, "Berangere@mail.fr", "123"));
        users.add(new User("Huguette", 55, "Huguette@mail.fr", "123"));
        users.add(new User("Sylvie", 11, "Sylvie@mail.fr", "123"));
        users.add(new User("Hermione", 22, "Hermione@mail.fr", "123"));
        users.add(new User("Bernard", 28, "Bernard@mail.fr", "123"));
        users.add(new User("Bernadette", 18, "Bernadette@mail.fr", "123"));
    }

    public User login(String email, String psw) {
        for(User user :  getUsers()){
            if(email.equals(user.getEmail()) && psw.equals(user.getPassword())){
                logger.info(logprefix + user.getId() +" logged in");
                return user;
            }
        }
        return null;
    }


    public void addUser(User u) throws Exception {
        if (users.contains(u)) {
            throw new Exception("Already known user") ;
        }
        users.add(u) ;
        logger.info(logprefix  + "User ID = " + u.getId() + " added");
    }

    public User getUserById(Long id) {
        for (User u : users) {
            if (Objects.equals(u.getId(), id)) {
                logger.info(logprefix + "User ID = " + u.getId() + " found");
                return u;
            }
        }
        logger.info(logprefix  + "User ID = " + id + " not  found");

        return null;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void removeUser(Long id) {
        logger.info(logprefix  + "User ID = " + id + " deleted");
        users.removeIf(u -> Objects.equals(u.getId(), id));
    }

    public void editUser(Long id, User u) throws Exception {
        logger.info(logprefix  + "User ID = " + id + " edited");
        removeUser(id);
        addUser(u);
    }
}
