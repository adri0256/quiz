package DAO;

import config.DatabaseConnection;
import model.Difficulty;
import model.Scoreboard;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ScoreboardDAOImpl implements ScoreboardDAO{
    private Connection con;

    private final static String selectAllScore = "SELECT * FROM scoreboard ORDER BY user_ID";
    private final static String SELECT_SCOREBOARD_ID = "SELECT * FROM scoreboard WHERE id= ?";
    private final static String INSERT_INTO_SCOREBOARD = "INSERT INTO scoreboard (user_ID, score, difficulty) VALUES (?,?,?)";
    private final static String UPDATE_SCOREBOARD = "UPDATE scoreboard SET user_ID=?, score = ?, difficulty = ? WHERE id=?";
    private final static String DELETE_FROM_SCOREBOARD = "DELETE FROM scoreboard WHERE id=?";

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
                sc.setUserID(rs.getInt("user_ID"));
                sc.setScore(rs.getInt("score"));
                sc.setDifficulty(Difficulty.values()[rs.getInt("difficulty")]);

                allScore.add(sc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allScore;
    }

    @Override
    public Scoreboard findScoreboardByID(int id) {
        Scoreboard s = new Scoreboard();
        try {
            PreparedStatement stmt = con.prepareStatement(SELECT_SCOREBOARD_ID);

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                AddScoreboard(s, rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return s;
    }

    @Override
    public void addScoreboard(Scoreboard scoreboard) {
        try{
            PreparedStatement stmt = con.prepareStatement(INSERT_INTO_SCOREBOARD);
            stmt.setInt(1, scoreboard.getUserID());
            stmt.setInt(2, scoreboard.getScore());
            stmt.setInt(3, scoreboard.getDifficulty().ordinal());
            System.out.println("ADD SCOREBOARD");
            stmt.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void ModifyScoreboard(Scoreboard updateScoreboard) {
        try{
            PreparedStatement statement = con.prepareStatement(UPDATE_SCOREBOARD);
            statement.setInt(1, updateScoreboard.getUserID());
            statement.setInt(2, updateScoreboard.getScore());
            statement.setInt(3, updateScoreboard.getDifficulty().ordinal());
            statement.setInt(4, updateScoreboard.getId());
            statement.executeUpdate();
            System.out.println("SCOREBOARD UPDATE, ID: "+ updateScoreboard.getId());
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteScoreboard(String id) {
        try{
            PreparedStatement statement = con.prepareStatement(DELETE_FROM_SCOREBOARD);
            statement.setString(1, id);
            statement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    private void AddScoreboard(Scoreboard s, ResultSet rs) throws SQLException {
        s.setId(rs.getInt("ID"));
        s.setUserID(rs.getInt("user_ID"));
        s.setScore(rs.getInt("score"));
        s.setDifficulty(Difficulty.fromInteger(rs.getInt("difficulty")));
    }

}
