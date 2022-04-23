package DAO;

import model.User;

import java.util.List;

public interface UserDAO {
    List<User> findAllUsers();

    User findUserByEmail(String email);

    User findUserById(int id);

    User login(User user);

    int register(User user);

    int delete(int id);

    int modify(User user);
}
