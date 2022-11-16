package me.sanchez.logging.User;

import java.util.ArrayList;

public class UserRepository {

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
    }

    public User getUserById(int id) {
        for (User u : users) {
            if (u.getId() == id)
                return u;
        }
        return null;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void removeUser(int id) {
        users.removeIf(u -> u.getId() == id);
    }

    public void editUser(int id, User u) throws Exception {
        removeUser(id);
        addUser(u);
    }
}
