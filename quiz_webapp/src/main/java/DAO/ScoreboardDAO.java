package DAO;

import model.Scoreboard;

import java.util.List;

public interface ScoreboardDAO {
    List<Scoreboard> findAllScore();
}
