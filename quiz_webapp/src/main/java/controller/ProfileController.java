package controller;

import DAO.UserDAO;
import DAO.UserDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ProfileController")
public class ProfileController extends HttpServlet {
    private final UserDAO userDAO = new UserDAOImpl();

    public ProfileController() { super(); }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
