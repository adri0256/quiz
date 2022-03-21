package DAO;

import config.DatabaseConnection;
import model.Temakor;
import model.Valasz;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TemakorDAOImpl implements TemakorDAO{
    private Connection con;
    private final static String selectAllTemakor = "SELECT * FROM temakor";

    public TemakorDAOImpl() {
        this.con = DatabaseConnection.getConnection();
    }

    @Override
    public List<Temakor> findAllTemakor() {
        List<Temakor> allTemakor = new ArrayList<>();

        try {
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(selectAllTemakor);

            while (rs.next()) {
                Temakor t = new Temakor();

                t.setId(rs.getInt("id"));
                t.setName(rs.getString("name"));
                allTemakor.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allTemakor;
    }
}
