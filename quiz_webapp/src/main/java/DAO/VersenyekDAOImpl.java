package DAO;

import config.DatabaseConnection;
import model.Versenyek;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VersenyekDAOImpl implements VersenyekDAO {
    private Connection con;

    private final String selectAllVersenyek = "SELECT * FROM Versenyek ORDER BY id";
    private final static String SELECT_VERSENYEK_ID = "SELECT * FROM VERSENYEK WHERE id= ?";
    private final static String INSERT_INTO_VERSENYEK = "INSERT INTO VERSENYEK (Idopont, temakorID) VALUES (?,?)";
    private final static String UPDATE_VERSENYEK = "UPDATE VERSENYEK SET Idopont=?, temakorID = ? WHERE id=?";
    private final static String DELETE_FROM_VERSENYEK = "DELETE FROM VERSENYEK WHERE id=?";


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

    @Override
    public Versenyek findVersenyByID(int id) {
        Versenyek v = new Versenyek();
        try {
            PreparedStatement stmt = con.prepareStatement(SELECT_VERSENYEK_ID);

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                AddVersenyek(v, rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return v;
    }


    @Override
    public void addVersenyek(Versenyek verseny) {
        try{
            PreparedStatement stmt = con.prepareStatement(INSERT_INTO_VERSENYEK);
            stmt.setDate(1, verseny.getIdopont());
            stmt.setInt(2, verseny.getTemakorID());
            System.out.println("ADD VERSENY");
            stmt.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void ModifyVersenyek(Versenyek updateVersenyek) {
        try{
            PreparedStatement statement = con.prepareStatement(UPDATE_VERSENYEK);
            statement.setDate(1, updateVersenyek.getIdopont());
            statement.setInt(2, updateVersenyek.getTemakorID());
            statement.setInt(3, updateVersenyek.getId());
            statement.executeUpdate();
            System.out.println("VERSENY UPDATE, ID: "+ updateVersenyek.getId());
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteVersenyek(String id) {
        try{
            PreparedStatement statement = con.prepareStatement(DELETE_FROM_VERSENYEK);
            statement.setString(1, id);
            statement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }


    private void AddVersenyek(Versenyek v, ResultSet rs) throws SQLException {
        v.setId(rs.getInt("id"));
        v.setIdopont(rs.getDate("Idopont"));
        v.setTemakorID(rs.getInt("TemakorID"));
    }

}
