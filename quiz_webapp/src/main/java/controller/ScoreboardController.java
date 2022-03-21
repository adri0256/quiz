package controller;

import DAO.ScoreboardDAO;
import DAO.ScoreboardDAOImpl;
import model.Scoreboard;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ScoreboardController")
public class ScoreboardController extends HttpServlet {
    private ScoreboardDAO scoreboardDAO = new ScoreboardDAOImpl();

    public ScoreboardController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Scoreboard> scores = scoreboardDAO.findAllScore();

        req.setAttribute("scores", scores);
    }
}
