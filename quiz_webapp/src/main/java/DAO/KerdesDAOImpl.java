package DAO;

import config.DatabaseConnection;
import model.Difficulty;
import model.Kerdes;
import model.Valasz;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KerdesDAOImpl implements KerdesDAO{
    private Connection con;
    private final static String selectAllKerdesek = "SELECT * FROM kerdesek";
    private final static String selectAllValaszok = "SELECT * FROM valaszok";
    private final static String SELECT_KERDES_ID = "SELECT * FROM kerdesek WHERE id= ?";
    private final static String SELECT_VALASZ_ID = "SELECT * FROM valaszok WHERE id= ?";

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
                k.setDifficulty(Difficulty.values()[rs.getInt("difficulty")]);
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

    @Override
    public Kerdes findKerdesViaID(int id) {
        Kerdes k = new Kerdes();
        try {
            PreparedStatement stmt = con.prepareStatement(SELECT_KERDES_ID);

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                AddKerdes(k, rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return k;
    }

    @Override
    public Valasz findValaszViaID(int id) {
        Valasz v = new Valasz();
        try {
            PreparedStatement stmt = con.prepareStatement(SELECT_VALASZ_ID);

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                AddValasz(v, rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return v;
    }

    private void AddValasz(Valasz v, ResultSet rs) throws SQLException {
        v.setId(rs.getInt("id"));
        v.setKerdesID(rs.getInt("kerdesID"));
        v.setValaszName(rs.getString("valaszname"));

    }

    private void AddKerdes(Kerdes k, ResultSet rs) throws SQLException {
        k.setId(rs.getInt("id"));
        k.setDifficulty(Difficulty.fromInteger(rs.getInt("difficulty")));
        k.setKerdesName(rs.getString("kerdesname"));
    }
}
