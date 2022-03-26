package controller;

import DAO.IQDAO;
import DAO.IQDAOImpl;
import model.IQ;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/IQ")
public class IQController extends HttpServlet {
    IQDAO IQDAO = new IQDAOImpl();

    public IQController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<IQ> allIQ = IQDAO.findAllIQ();

        req.setAttribute("allIQ", allIQ);

    }
}
