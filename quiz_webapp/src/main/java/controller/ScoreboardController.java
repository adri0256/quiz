package controller;

import DAO.ScoreboardDAO;
import DAO.ScoreboardDAOImpl;
import model.Difficulty;
import model.Scoreboard;
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

@WebServlet("/ScoreboardController")
public class ScoreboardController extends HttpServlet {
    ScoreboardDAO scoreboardDAO = new ScoreboardDAOImpl();

    public Scoreboard currentScoreboard;

    public ScoreboardController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Scoreboard> scores = scoreboardDAO.findAllScore();

        req.setAttribute("scores", scores);


        if (req.getParameterMap().containsKey("id")) {
            System.out.println("ScoreboardEditStart");
            currentScoreboard = scoreboardDAO.findScoreboardByID(Integer.parseInt(req.getParameter("id")));
            System.out.println(currentScoreboard);
            req.setAttribute("currentScoreboard", currentScoreboard);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        JSONObject json = new JSONObject();
        PrintWriter out = resp.getWriter();


        switch (req.getParameter("type")){
            case "AddScore" ->{
                System.out.println("Reg Scoreboard");
                Scoreboard scoreboard = new Scoreboard();


                scoreboard.setUserID(Integer.parseInt(req.getParameter("addScoreUserID")));
                scoreboard.setScore(Integer.parseInt(req.getParameter("addScoreScore")));
                scoreboard.setDifficulty(Difficulty.fromInteger(Integer.parseInt(req.getParameter("addScoreDifficulty"))));

                System.out.println("sent user: " + scoreboard);

                scoreboardDAO.addScoreboard(scoreboard);

            }
            case "updateScore" ->{
                Scoreboard updateScoreboard = new Scoreboard();
                updateScoreboard.setId(Integer.parseInt(req.getParameter("updateScoreID")));
                updateScoreboard.setUserID(Integer.parseInt(req.getParameter("updateScoreUserID")));
                updateScoreboard.setScore(Integer.parseInt(req.getParameter("updateScoreScore")));
                updateScoreboard.setDifficulty(Difficulty.fromInteger(Integer.parseInt(req.getParameter("updateScoreDifficulty"))));
                scoreboardDAO.ModifyScoreboard(updateScoreboard);

                System.out.println("Update SCOREBOARD");
            }
            case "deleteScore" ->{
                String deleteID = req.getParameter("deleteScoreID");
                scoreboardDAO.deleteScoreboard(deleteID);
                System.out.println("DELETE SCOREBOARD");
            }
        }


        json.put("success", "yes");
        out.write(json.toString());



    }


}
