package DAO;

import model.Scoreboard;

import java.util.List;

public interface ScoreboardDAO {
    List<Scoreboard> findAllScore();

    Scoreboard findScoreboardByID(int id);

    void addScoreboard(Scoreboard scoreboard);
    void ModifyScoreboard(Scoreboard updateScoreboard);
    void deleteScoreboard(String id);
}
