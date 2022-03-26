package DAO;

import config.DatabaseConnection;
import model.Versenyek;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VersenyekDAOImpl implements VersenyekDAO {
    private Connection con;

    private final String selectAllVersenyek = "SELECT * FROM Versenyek";

    public VersenyekDAOImpl() {
        this.con = DatabaseConnection.getConnection();
    }

    @Override
    public List<Versenyek> findAllVersenyek() {
        List<Versenyek> allVersenyek = new ArrayList<>();

        try {
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(selectAllVersenyek);

            while (rs.next()){
                Versenyek Versenyek = new Versenyek();

                Versenyek.setId(rs.getInt("id"));
                Versenyek.setIdopont(rs.getDate("idopont"));
                Versenyek.setTemakorID(rs.getInt("temakorID"));

                allVersenyek.add(Versenyek);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allVersenyek;
    }

}
