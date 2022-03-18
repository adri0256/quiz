package DAO;

import config.DatabaseConnection;
import model.User;
import model.UserLevel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO{
    private Connection con;

    private final String SELECT_ALL = "SELECT * FROM my_users";

    public UserDAOImpl() {
        this.con = DatabaseConnection.getConnection();
    }

    @Override
    public List<User> findAllUsers() {
        List<User> users = new ArrayList<>();

        try {
            PreparedStatement stmt = con.prepareStatement(SELECT_ALL);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setBirthdate(rs.getDate("birthdate"));
                user.setUserLevel(UserLevel.values()[rs.getInt("userlevel")]);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }
}
