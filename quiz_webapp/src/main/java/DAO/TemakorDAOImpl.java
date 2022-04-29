package DAO;

import config.DatabaseConnection;
import model.Temakor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TemakorDAOImpl implements TemakorDAO{
    private Connection con;
    private final static String selectAllTemakor = "SELECT * FROM temakor ORDER BY id";
    private final static String SELECT_TEMAKOR_ID = "SELECT * FROM temakor WHERE id= ?";
    private final static String INSERT_INTO_TEMAKOR = "INSERT INTO temakor (name) VALUES (?)";
    private final static String DELETE_FROM_TEMAKOR ="DELETE FROM temakor WHERE id=?";
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

    @Override
    public Temakor findTemakorViaID(int id) {
        Temakor t = new Temakor();
        try {
            PreparedStatement stmt = con.prepareStatement(SELECT_TEMAKOR_ID);

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                AddTemakor(t, rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return t;
    }

    @Override
    public void addTemakor(Temakor temakor) {
        try{
            PreparedStatement stmt = con.prepareStatement(INSERT_INTO_TEMAKOR);
            stmt.setString(1, temakor.getName());
            System.out.println("ADD TEMAKOR");
            stmt.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTemakor(String id) {
        try{
            PreparedStatement statement = con.prepareStatement(DELETE_FROM_TEMAKOR);
            statement.setString(1, id);
            statement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    private void AddTemakor(Temakor t, ResultSet rs) throws SQLException {
    t.setId(rs.getInt("id"));
    t.setName(rs.getString("name"));
    }
}
