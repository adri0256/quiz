package DAO;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    List<User> findAllUsers();
}
