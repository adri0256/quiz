package DAO;

import config.DatabaseConnection;
import model.IQ;
import model.Versenyek;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class IQDAOImpl implements IQDAO {
    private Connection con;

    private final static String selectAllIQ = "SELECT * FROM IQ ORDER BY id";
    private final static String SELECT_IQ_ID = "SELECT * FROM IQ WHERE id= ?";
    private final static String INSERT_INTO_IQ = "INSERT INTO IQ (userID, score) VALUES (?,?)";
    private final static String UPDATE_IQ = "UPDATE IQ SET userID=?, score = ? WHERE id=?";
    private final static String DELETE_FROM_IQ = "DELETE FROM IQ WHERE id=?";

    public IQDAOImpl() { this.con = DatabaseConnection.getConnection(); }

    @Override
    public List<IQ> findAllIQ() {
        List<IQ> allIQ = new ArrayList<>();

        try {
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(selectAllIQ);

            while (rs.next()) {
                IQ IQ = new IQ();

                IQ.setId(rs.getInt("id"));
                IQ.setUserID(rs.getInt("userid"));
                IQ.setScore(rs.getInt("score"));

                allIQ.add(IQ);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allIQ;
    }

    @Override
    public IQ findIQByID(int id) {
        IQ i = new IQ();
        try {
            PreparedStatement stmt = con.prepareStatement(SELECT_IQ_ID);

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                AddIQ(i, rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return i;
    }

    @Override
    public void addIQ(IQ IQ) {
        try{
            PreparedStatement stmt = con.prepareStatement(INSERT_INTO_IQ);
            stmt.setInt(1, IQ.getUserID());
            stmt.setInt(2, IQ.getScore());
            System.out.println("ADD IQ");
            stmt.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void ModifyIQ(IQ updateIQ) {
        try{
            PreparedStatement statement = con.prepareStatement(UPDATE_IQ);
            statement.setInt(1, updateIQ.getUserID());
            statement.setInt(2, updateIQ.getScore());
            statement.setInt(3, updateIQ.getId());
            statement.executeUpdate();
            System.out.println("IQ UPDATE, ID: "+ updateIQ.getId());
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteIQ(String id) {
        try{
            PreparedStatement statement = con.prepareStatement(DELETE_FROM_IQ);
            statement.setString(1, id);
            statement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    private void AddIQ(IQ i, ResultSet rs) throws SQLException {
        i.setId(rs.getInt("id"));
        i.setUserID(rs.getInt("userID"));
        i.setScore(rs.getInt("score"));
    }

}