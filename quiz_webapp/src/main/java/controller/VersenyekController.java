package controller;

import DAO.VersenyekDAO;
import DAO.VersenyekDAOImpl;
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


@WebServlet("/Versenyek")
public class VersenyekController extends HttpServlet {
    VersenyekDAO VersenyekDAO = new VersenyekDAOImpl();

    public Versenyek currentVersenyek;

    public VersenyekController() { super(); }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Versenyek> allVersenyek = VersenyekDAO.findAllVersenyek();

        req.setAttribute("allVersenyek", allVersenyek);

        if (req.getParameterMap().containsKey("id")) {
            System.out.println("VersenyekEditStart");
            currentVersenyek = VersenyekDAO.findVersenyByID(Integer.parseInt(req.getParameter("id")));
            System.out.println(currentVersenyek);
            req.setAttribute("currentVersenyek", currentVersenyek);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        JSONObject json = new JSONObject();
        PrintWriter out = resp.getWriter();


        switch (req.getParameter("type")){
            case "AddVerseny" ->{
                System.out.println("Reg Verseny");
                Versenyek versenyek = new Versenyek();


                versenyek.setIdopont(Date.valueOf(req.getParameter("addIdopont")));
                versenyek.setTemakorID(Integer.parseInt(req.getParameter("addTemakorID")));

                System.out.println("sent user: " + versenyek);

                VersenyekDAO.addVersenyek(versenyek);

            }
            case "updateVerseny" ->{
                        Versenyek updateVersenyek = new Versenyek();
                        updateVersenyek.setId(Integer.parseInt(req.getParameter("updateID")));
                        updateVersenyek.setIdopont(Date.valueOf(req.getParameter("updateIdopont")));
                        updateVersenyek.setTemakorID(Integer.parseInt(req.getParameter("updateTemakorID")));
                        VersenyekDAO.ModifyVersenyek(updateVersenyek);

                        System.out.println("Update Verseny");
            }
            case "deleteVerseny" ->{
                String deleteID = req.getParameter("deleteID");
                        VersenyekDAO.deleteVersenyek(deleteID);
                        System.out.println("DELETE Verseny");
            }
        }


        json.put("success", "yes");
        out.write(json.toString());



    }




}
