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
        resp.setContentType("application/json");
        JSONObject json = new JSONObject();
        PrintWriter out = resp.getWriter();

        switch (req.getParameter("type")){
            case "AddALL" ->{
                String kerdesname = req.getParameter("kerdes");
                int selectedTemakor = Integer.parseInt(req.getParameter("stem"));
                String valaszname = req.getParameter("valasz");
                Difficulty difficulty = Difficulty.fromInteger(Integer.parseInt(req.getParameter("difficulty")));
                String temakorname = req.getParameter("temakor");

                int kerdesId = 0;
                int temakorId = 0;

                Kerdes kerdes = new Kerdes();
                Valasz valasz = new Valasz();
                Temakor temakor = new Temakor();

                if(!kerdesname.equals("")){
                    kerdes.setKerdesName(kerdesname);
                    kerdes.setDifficulty(difficulty);
                    kerdesDAO.addKerdes(kerdes);

                    valasz.setValaszName(valaszname);

                    kerdesId = kerdesDAO.getKerdesID(kerdesname);

                    valasz.setKerdesID(kerdesId);

                    kerdesDAO.addValasz(valasz);
                }

                if(!temakorname.equals("")){
                    temakor.setName(temakorname);
                    temakorDAO.addTemakor(temakor);

                    temakorId = temakorDAO.findTemakorViaName(temakorname).getId();
                    temakorDAO.addTemakorKerdes(kerdesId, temakorId);
                } else {
                    temakorDAO.addTemakorKerdes(kerdesId, selectedTemakor);
                }

                System.out.println(kerdes);
                System.out.println(valasz);


            }
            case "delete" ->{
                String deleteID = req.getParameter("deleteid");
                String melyik = req.getParameter("melyik");
                switch (melyik){
                    case "k" ->{
                        kerdesDAO.deleteKerdes(deleteID);
                        System.out.println("DELETE kerdes");
                    }
                    case "v" ->{
                        kerdesDAO.deleteValasz(deleteID);
                        System.out.println("DELETE valasz");
                    }
                    case "t" ->{
                        System.out.println("DELETE temakor");
                        temakorDAO.deleteTemakor(deleteID);
                    }
                }
            }
            case "update" ->{
                String melyik = req.getParameter("updatemelyik");
                switch (melyik){
                    case "k" ->{
                        Kerdes updateKerdes = new Kerdes();
                        updateKerdes.setId(Integer.parseInt(req.getParameter("kerdesID")));
                        updateKerdes.setKerdesName(req.getParameter("kerdesName"));
                        updateKerdes.setDifficulty(Difficulty.fromInteger(Integer.parseInt(req.getParameter("difficulty"))));
                        kerdesDAO.ModifyKerdes(updateKerdes);

                        System.out.println("Update kerdes");
                    }
                    case "v" ->{
                        Valasz updateValasz = new Valasz();
                        updateValasz.setId(Integer.parseInt(req.getParameter("valaszID")));
                        updateValasz.setValaszName(req.getParameter("valaszName"));
                        kerdesDAO.ModifyValasz(updateValasz);

                        System.out.println("Update valasz");
                    }
                    case "t" ->{
                        Temakor updateTemakor = new Temakor();
                        updateTemakor.setId(Integer.parseInt(req.getParameter("temakorID")));
                        updateTemakor.setName(req.getParameter("temakorName"));
                        temakorDAO.ModifyTemakor(updateTemakor);

                        System.out.println("Update temakor");
                    }
                }
            }
        }
        System.out.println("Post");

        json.put("success", "yes");
        out.write(json.toString());
    }
}
