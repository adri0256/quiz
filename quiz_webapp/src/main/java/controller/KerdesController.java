package controller;



import DAO.KerdesDAO;
import DAO.KerdesDAOImpl;
import DAO.TemakorDAO;
import DAO.TemakorDAOImpl;
import model.*;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@WebServlet("/KerdesController")
public class KerdesController extends HttpServlet{
    KerdesDAO kerdesDAO = new KerdesDAOImpl();
    TemakorDAO temakorDAO = new TemakorDAOImpl();

    public Kerdes cKerdes;
    public Valasz cValasz;
    public Temakor cTemakor;

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

        if(req.getParameterMap().containsKey("id")){
            if (req.getParameterMap().containsKey("type")){
                switch (req.getParameter("type")){
                    case "kerdes" -> {
                        System.out.println("Kerdes");
                        cKerdes = kerdesDAO.findKerdesViaID(Integer.parseInt(req.getParameter("id")));
                        System.out.println(cKerdes);
                        req.setAttribute("currentKerdes", cKerdes);
                        req.setAttribute("whichone", "k");
                    }
                    case "valasz" -> {
                        System.out.println("Valasz");
                        cValasz = kerdesDAO.findValaszViaID(Integer.parseInt(req.getParameter("id")));
                        System.out.println(cValasz);
                        req.setAttribute("currentValasz", cValasz);
                        req.setAttribute("whichone", "v");
                    }
                    case "temakor" -> {
                        System.out.println("Temakor");
                        cTemakor = temakorDAO.findTemakorViaID(Integer.parseInt(req.getParameter("id")));
                        System.out.println(cTemakor);
                        req.setAttribute("currentTemakor", cTemakor);
                        req.setAttribute("whichone", "t");

                    }
                }
            }

        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
/*
        resp.setContentType("application/json");
        JSONObject json = new JSONObject();
        PrintWriter out = resp.getWriter();

        String kerdestext = req.getParameter("kerdesT");

        Difficulty difficulty =Difficulty.fromInteger(
                Integer.parseInt(req.getParameter("difficultyT")));

        String valasztext = req.getParameter("valaszT");
        String kerdesIDtext = req.getParameter("kerdesIDT");
        String temakortext = req.getParameter("temakorT");

        HttpSession session = req.getSession();
        if (!kerdestext.equals("")){
            Kerdes kerdes = new Kerdes();
            kerdes.setId(cKerdes.getId());
            kerdes.setKerdesName(kerdestext);

        }
        else if (!valasztext.equals("")){
            Temakor temakor = new Temakor();
        }
        else{
            Valasz valasz = new Valasz();
        }

        json.put("success", "yes");

        out.write(json.toString());
        */
        System.out.println("Post");
    }
}
