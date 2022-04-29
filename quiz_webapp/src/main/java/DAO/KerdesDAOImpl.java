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
    private final static String selectAllKerdesek = "SELECT * FROM kerdesek ORDER BY id";
    private final static String selectAllValaszok = "SELECT * FROM valaszok ORDER BY id";
    private final static String SELECT_KERDES_ID = "SELECT * FROM kerdesek WHERE id= ?";
    private final static String SELECT_VALASZ_ID = "SELECT * FROM valaszok WHERE id= ?";
    private final static String FIND_KERDES_VIA_STRING ="SELECT id from kerdesek WHERE kerdesname = ?";
    private final static String INSERT_INTO_KERDES = "INSERT INTO kerdesek (kerdesname, difficulty) VALUES (?,?)";
    private final static String INSERT_INTO_VALASZ = "INSERT INTO valaszok (kerdesID, valaszname) VALUES (?,?)";
    private final static String DELETE_FROM_KERDESEK = "DELETE FROM kerdesek WHERE id=?";
    private final static String DELETE_FROM_VALASZOK = "DELETE FROM valaszok WHERE id=?";
    private final static String UPDATE_KERDESEK = "UPDATE kerdesek SET kerdesname=?, difficulty = ? WHERE id=?";
    private final static String UPDATE_VALASZOK = "UPDATE valaszok SET valaszname=? WHERE id=?";

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

    @Override
    public void addKerdes(Kerdes kerdes) {
        try{
            PreparedStatement stmt = con.prepareStatement(INSERT_INTO_KERDES);
            stmt.setString(1, kerdes.getKerdesName());
            stmt.setInt(2, kerdes.getDifficulty().ordinal());
            System.out.println("ADD KERDES");
            stmt.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void addValasz(Valasz valasz) {
        try{
            PreparedStatement stmt = con.prepareStatement(INSERT_INTO_VALASZ);
            stmt.setInt(1, valasz.getKerdesID());
            stmt.setString(2, valasz.getValaszName());
            System.out.println("ADD VALASZ");
            stmt.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public int getKerdesID(String szoveg) {
        int kerdesID = -1;
        try {
            PreparedStatement statement = con.prepareStatement(FIND_KERDES_VIA_STRING);
            statement.setString(1, szoveg);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                kerdesID = resultSet.getInt("id");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return kerdesID;
    }

    @Override
    public void deleteKerdes(String id) {
    try{
        PreparedStatement statement = con.prepareStatement(DELETE_FROM_KERDESEK);
        statement.setString(1, id);
        statement.executeUpdate();
    }
    catch (SQLException e){
        e.printStackTrace();
    }
    }

    @Override
    public void deleteValasz(String id) {
        try{
            PreparedStatement statement = con.prepareStatement(DELETE_FROM_VALASZOK);
            statement.setString(1, id);
            statement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void ModifyKerdes(Kerdes kerdes) {
        try{
            PreparedStatement statement = con.prepareStatement(UPDATE_KERDESEK);
            statement.setString(1, kerdes.getKerdesName());
            statement.setInt(2, kerdes.getDifficulty().ordinal());
            statement.setInt(3, kerdes.getId());
            statement.executeUpdate();
            System.out.println("KERDES UPDATE, ID: "+ kerdes.getId());
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void ModifyValasz(Valasz valasz) {
        try{
            PreparedStatement statement = con.prepareStatement(UPDATE_VALASZOK);
            statement.setString(1, valasz.getValaszName());
            statement.setInt(2, valasz.getId());
            statement.executeUpdate();
            System.out.println("VALASZ UPDATE, ID: "+ valasz.getId());
        }
        catch (SQLException e){
            e.printStackTrace();
        }
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
