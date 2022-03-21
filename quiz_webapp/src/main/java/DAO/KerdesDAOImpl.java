package DAO;

import config.DatabaseConnection;
import model.ForumPost;
import model.Kerdes;
import model.Valasz;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class KerdesDAOImpl implements KerdesDAO{
    private Connection con;
    private final static String selectAllKerdesek = "SELECT * FROM kerdesek";
    private final static String selectAllValaszok = "SELECT * FROM valaszok";

    public KerdesDAOImpl() {
        this.con = DatabaseConnection.getConnection();
    }

    @Override
    public List<Kerdes> findAllKerdesek() {
        List<Kerdes> allKerdesek = new ArrayList<>();

        try {
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(selectAllKerdesek);

            while (rs.next()) {
                Kerdes k = new Kerdes();

                k.setId(rs.getInt("id"));
                k.setKerdesName(rs.getString("kerdesname"));
                allKerdesek.add(k);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allKerdesek;
    }

    @Override
    public List<Valasz> findAllValasz() {
        List<Valasz> allValasz = new ArrayList<>();

        try {
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(selectAllValaszok);

            while (rs.next()) {
                Valasz v = new Valasz();

                v.setId(rs.getInt("id"));
                v.setKerdesID(rs.getInt("kerdesid"));
                v.setValaszName(rs.getString("valaszname"));
                allValasz.add(v);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allValasz;
    }
}
