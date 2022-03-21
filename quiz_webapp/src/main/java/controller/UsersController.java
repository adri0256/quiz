package controller;

import DAO.UserDAO;
import DAO.UserDAOImpl;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/UsersController")
public class UsersController extends HttpServlet {
    private UserDAO userDAO = new UserDAOImpl();

    public UsersController() { super(); }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> allUsers = userDAO.findAllUsers();

        req.setAttribute("users", allUsers);
    }
}
