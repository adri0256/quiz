package DAO;

import config.DatabaseConnection;
import model.User;
import model.UserLevel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO{
    private Connection con;

    private final String SELECT_ALL = "SELECT * FROM MY_USERS;";

    public UserDAOImpl() {
        this.con = DatabaseConnection.getConnection();
    }

    @Override
    public List<User> findAllUsers() {
        List<User> users = new ArrayList<>();

        try {
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(SELECT_ALL);

            while (rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setBirthdate(rs.getDate("birthdate"));
                user.setUserLevel(UserLevel.values()[rs.getInt("userlevel")]);

                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }
}
