package DAO;

import config.DatabaseConnection;
import model.RegUserVerseny;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class RegUserVersenyDAOImpl implements RegUserVersenyDAO {
    private Connection con;

    private final static String selectAllRegUserVerseny = "SELECT * FROM RegUser_Verseny ORDER BY regID";
    private final static String SELECT_REGUSERVERSENY_REGID = "SELECT * FROM REGUSER_VERSENY WHERE regid= ?";
    private final static String INSERT_INTO_REGUSERVERSENY = "INSERT INTO REGUSER_VERSENY (USERID, VERSENYID) VALUES (?,?)";
    private final static String UPDATE_REGUSERVERSENY= "UPDATE REGUSER_VERSENY SET userID=?, versenyID = ? WHERE regid=?";
    private final static String DELETE_FROM_REGUSERVERSENY = "DELETE FROM REGUSER_VERSENY WHERE regid=?";

    public RegUserVersenyDAOImpl() { this.con = DatabaseConnection.getConnection(); }

    @Override
    public List<RegUserVerseny> findAllRegUserVerseny() {
        List<RegUserVerseny> allRegUserVerseny = new ArrayList<>();

        try {
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(selectAllRegUserVerseny);

            while (rs.next()) {
                RegUserVerseny RegUserVerseny = new RegUserVerseny();

                RegUserVerseny.setRegID(rs.getInt("regID"));
                RegUserVerseny.setUserID(rs.getInt("userID"));
                RegUserVerseny.setVersenyID(rs.getInt("versenyID"));


                allRegUserVerseny.add(RegUserVerseny);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allRegUserVerseny;
    }

    @Override
    public RegUserVerseny findRegUserVersenyByRegID(int regid) {
        RegUserVerseny r = new RegUserVerseny();
        try {
            PreparedStatement stmt = con.prepareStatement(SELECT_REGUSERVERSENY_REGID);

            stmt.setInt(1, regid);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                AddRegUserVerseny(r, rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return r;
    }


    @Override
    public void addRegUserVerseny(RegUserVerseny RUV) {
        try{
            PreparedStatement stmt = con.prepareStatement(INSERT_INTO_REGUSERVERSENY);
            stmt.setInt(1, RUV.getUserID());
            stmt.setInt(2, RUV.getVersenyID());
            System.out.println("ADD RegUserVerseny");
            stmt.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void ModifyRegUserVerseny(RegUserVerseny updateRegUserVerseny) {
        try{
            PreparedStatement statement = con.prepareStatement(UPDATE_REGUSERVERSENY);
            statement.setInt(1, updateRegUserVerseny.getUserID());
            statement.setInt(2, updateRegUserVerseny.getVersenyID());
            statement.setInt(3, updateRegUserVerseny.getRegID());
            statement.executeUpdate();
            System.out.println("RegUserVerseny UPDATE, ID: "+ updateRegUserVerseny.getRegID());
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteRegUserVerseny(String id) {
        try{
            PreparedStatement statement = con.prepareStatement(DELETE_FROM_REGUSERVERSENY);
            statement.setString(1, id);
            statement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    private void AddRegUserVerseny(RegUserVerseny r, ResultSet rs) throws SQLException {
        r.setRegID(rs.getInt("regID"));
        r.setUserID(rs.getInt("userID"));
        r.setVersenyID(rs.getInt("versenyID"));
    }

}