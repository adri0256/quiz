package controller;

import DAO.IQDAO;
import DAO.IQDAOImpl;
import model.IQ;
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


@WebServlet("/IQ")
public class IQController extends HttpServlet {
    IQDAO IQDAO = new IQDAOImpl();

    public IQ currentIQ;

    public IQController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<IQ> allIQ = IQDAO.findAllIQ();

        req.setAttribute("allIQ", allIQ);

        if (req.getParameterMap().containsKey("id")) {
            System.out.println("IQEDitStart");
            currentIQ = IQDAO.findIQByID(Integer.parseInt(req.getParameter("id")));
            System.out.println(currentIQ);
            req.setAttribute("currentIQ", currentIQ);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        JSONObject json = new JSONObject();
        PrintWriter out = resp.getWriter();


        switch (req.getParameter("type")){
            case "AddIQ" ->{
                System.out.println("Reg IQ");
                IQ IQ = new IQ();


                IQ.setUserID(Integer.parseInt(req.getParameter("addIQUserID")));
                IQ.setScore(Integer.parseInt(req.getParameter("addIQScore")));

                System.out.println("sent user: " + IQ);

                IQDAO.addIQ(IQ);

            }
            case "updateIQ" ->{
                IQ updateIQ = new IQ();
                updateIQ.setId(Integer.parseInt(req.getParameter("updateIQID")));
                updateIQ.setUserID(Integer.parseInt(req.getParameter("updateIQUserID")));
                updateIQ.setScore(Integer.parseInt(req.getParameter("updateIQscore")));
                IQDAO.ModifyIQ(updateIQ);

                System.out.println("Update IQ");
            }
            case "deleteIQ" ->{
                String deleteIQID = req.getParameter("deleteIQID");
                IQDAO.deleteIQ(deleteIQID);
                System.out.println("DELETE IQ");
            }
        }


        json.put("success", "yes");
        out.write(json.toString());



    }



}
