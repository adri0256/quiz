package controller;

import DAO.RegUserVersenyDAO;
import DAO.RegUserVersenyDAOImpl;
import model.RegUserVerseny;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/RegUserVerseny")
public class RegUserVersenyController extends HttpServlet {
    RegUserVersenyDAO RegUserVersenyDAO = new RegUserVersenyDAOImpl();

    public RegUserVersenyController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<RegUserVerseny> allRegUserVerseny = RegUserVersenyDAO.findAllRegUserVerseny();

        req.setAttribute("allRegUserVerseny", allRegUserVerseny);

    }
}
