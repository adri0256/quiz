package controller;

import DAO.RegUserVersenyDAO;
import DAO.RegUserVersenyDAOImpl;
import model.RegUserVerseny;
import model.Versenyek;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

@WebServlet("/RegUserVerseny")
public class RegUserVersenyController extends HttpServlet {
    RegUserVersenyDAO RegUserVersenyDAO = new RegUserVersenyDAOImpl();

    public RegUserVerseny currentRegUserVerseny;
    public RegUserVersenyController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<RegUserVerseny> allRegUserVerseny = RegUserVersenyDAO.findAllRegUserVerseny();

        req.setAttribute("allRegUserVerseny", allRegUserVerseny);
        if (req.getParameterMap().containsKey("regid")) {
            System.out.println("RegUserVersenyEditStart");
            currentRegUserVerseny = RegUserVersenyDAO.findRegUserVersenyByRegID(Integer.parseInt(req.getParameter("regid")));
            System.out.println(currentRegUserVerseny);
            req.setAttribute("currentRegUserVerseny", currentRegUserVerseny);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        JSONObject json = new JSONObject();
        PrintWriter out = resp.getWriter();


        switch (req.getParameter("type")){
            case "AddRUV" ->{
                System.out.println("RegUserVerseny Reg");
                RegUserVerseny RUV = new RegUserVerseny();


                RUV.setUserID(Integer.parseInt(req.getParameter("addUserID")));
                RUV.setVersenyID(Integer.parseInt(req.getParameter("addVersenyID")));

                System.out.println("sent user: " + RUV);

                RegUserVersenyDAO.addRegUserVerseny(RUV);

            }
            case "updateRUV" ->{
                RegUserVerseny updateRegUserVerseny = new RegUserVerseny();
                updateRegUserVerseny.setRegID(Integer.parseInt(req.getParameter("updateRegID")));
                updateRegUserVerseny.setUserID(Integer.parseInt(req.getParameter("updateRegUserID")));
                updateRegUserVerseny.setVersenyID(Integer.parseInt(req.getParameter("updateRegVersenyID")));
                RegUserVersenyDAO.ModifyRegUserVerseny(updateRegUserVerseny);

                System.out.println("Update RegUserVerseny");
            }
            case "deleteRUV" ->{
                String deleteID = req.getParameter("deleteID");
                RegUserVersenyDAO.deleteRegUserVerseny(deleteID);
                System.out.println("DELETE RegUserVerseny");
            }
        }

        json.put("success", "yes");
        out.write(json.toString());

    }

}
