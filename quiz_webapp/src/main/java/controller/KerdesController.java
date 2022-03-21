package controller;



import DAO.KerdesDAO;
import DAO.KerdesDAOImpl;
import DAO.TemakorDAO;
import DAO.TemakorDAOImpl;
import model.Kerdes;
import model.Temakor;
import model.Valasz;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/KerdesController")
public class KerdesController extends HttpServlet{
    KerdesDAO kerdesDAO = new KerdesDAOImpl();
    TemakorDAO temakorDAO = new TemakorDAOImpl();

    public KerdesController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Kerdes> kerdesList = kerdesDAO.findAllKerdesek();
        List<Valasz> valaszList = kerdesDAO.findAllValasz();
        List<Temakor> temakorList = temakorDAO.findAllTemakor();

        req.setAttribute("kerdes", kerdesList);
        req.setAttribute("valasz", valaszList);
        req.setAttribute("temakor", temakorList);
    }
}
