package DAO;

import config.DatabaseConnection;
import model.User;
import model.UserLevel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO{
    private Connection con;

    private static final String SELECT_ALL = "SELECT * FROM MY_USERS";
    private static final String SELECT_BY_EMAIL = "SELECT * FROM MY_USERS WHERE email = ?";
    private static final String SELECT_BY_EMAIL_AND_PWD = "SELECT * FROM MY_USERS WHERE email = ? AND password = ?";
    private static final String INSERT_INTO_USER = "INSERT INTO MY_USERS(username, email, password, salt, birthdate, userlevel) VALUES(?, ?, ?, ?, ?, 1)";
    private static final String UPDATE_USER = "UPDATE MY_USERS SET username = ?, email = ?, password = ?, salt = ?";
    private static final String DELETE_FROM_USER = "DELETE FROM MY_USERS WHERE ID = ?";

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
                user.setSalt(rs.getString("salt"));
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

    @Override
    public User findUser(String email) {
        User user = new User();

        try {
            PreparedStatement stmt = con.prepareStatement(SELECT_BY_EMAIL);
            stmt.setString(1, email);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()){
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setSalt(rs.getString("salt"));
                user.setEmail(rs.getString("email"));
                user.setBirthdate(rs.getDate("birthdate"));
                user.setUserLevel(UserLevel.values()[rs.getInt("userlevel")]);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    private Boolean checkUserExists(String email) {
        try {
            PreparedStatement stmt = con.prepareStatement(SELECT_BY_EMAIL);
            stmt.setString(1, email);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()){
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public User login(User user) {
        try {
            PreparedStatement stmt = con.prepareStatement(SELECT_BY_EMAIL_AND_PWD);

            stmt.setString(1, user.getEmail());
            stmt.setString(2, user.getPassword());

            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {
                User ret = new User();

                ret.setId(rs.getInt("id"));
                ret.setUsername(rs.getString("username"));
                ret.setPassword(rs.getString("password"));
                ret.setSalt(rs.getString("salt"));
                ret.setEmail(rs.getString("email"));
                ret.setBirthdate(rs.getDate("birthdate"));
                ret.setUserLevel(UserLevel.fromInteger(rs.getInt("userlevel")));

                return ret;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public int register(User user) {
        int ret = 0;

        if(checkUserExists(user.getEmail()))
            return ret;

        try {
            PreparedStatement stmt = con.prepareStatement(INSERT_INTO_USER);

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getSalt());
            stmt.setDate(5, user.getBirthdate());

            ret = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ret;
    }

    @Override
    public int modify(User user) {
        int row = 0;

        try {
            PreparedStatement stmt = con.prepareStatement(UPDATE_USER);

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getSalt());

            row = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return row;
    }

    @Override
    public int delete(int id) {
        int row = 0;

        try {
            PreparedStatement stmt = con.prepareStatement(DELETE_FROM_USER);

            stmt.setInt(1, id);

            row = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return row;
    }
}
