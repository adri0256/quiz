package DAO;

import model.User;

import java.util.List;

public interface UserDAO {
    List<User> findAllUsers();

    User findUser(String email);

    User login(User user);

    int register(User user);
}
