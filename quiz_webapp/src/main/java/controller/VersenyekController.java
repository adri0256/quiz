package controller;

import DAO.VersenyekDAO;
import DAO.VersenyekDAOImpl;
import model.Versenyek;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Versenyek")
public class VersenyekController extends HttpServlet {
    VersenyekDAO VersenyekDAO = new VersenyekDAOImpl();

    public VersenyekController() { super(); }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Versenyek> allVersenyek = VersenyekDAO.findAllVersenyek();

        req.setAttribute("allVersenyek", allVersenyek);
    }
}
