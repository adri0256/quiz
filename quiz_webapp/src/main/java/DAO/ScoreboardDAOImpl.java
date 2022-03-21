package DAO;

import config.DatabaseConnection;
import model.Difficulty;
import model.Scoreboard;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ScoreboardDAOImpl implements ScoreboardDAO{
    private Connection con;

    private final static String selectAllScore = "SELECT * FROM scoreboard";

    public ScoreboardDAOImpl() {
        this.con = DatabaseConnection.getConnection();
    }

    @Override
    public List<Scoreboard> findAllScore() {
        List<Scoreboard> allScore = new ArrayList<>();

        try {
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(selectAllScore);

            while (rs.next()) {
                Scoreboard sc = new Scoreboard();

                sc.setId(rs.getInt("id"));
                sc.setUserId(rs.getInt("id"));
                sc.setScore(rs.getInt("id"));
                sc.setDifficulty(Difficulty.values()[rs.getInt("id")]);

                allScore.add(sc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allScore;
    }
}
