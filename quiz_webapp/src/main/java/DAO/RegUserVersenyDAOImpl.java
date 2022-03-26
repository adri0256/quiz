package DAO;

import config.DatabaseConnection;
import model.RegUserVerseny;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class RegUserVersenyDAOImpl implements RegUserVersenyDAO {
    private Connection con;

    private final static String selectAllRegUserVerseny = "SELECT * FROM RegUser_Verseny";

    public RegUserVersenyDAOImpl() { this.con = DatabaseConnection.getConnection(); }

    @Override
    public List<RegUserVerseny> findAllRegUserVerseny() {
        List<RegUserVerseny> allRegUserVerseny = new ArrayList<>();

        try {
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(selectAllRegUserVerseny);

            while (rs.next()) {
                RegUserVerseny RegUserVerseny = new RegUserVerseny();

                RegUserVerseny.setUserID(rs.getInt("userID"));
                RegUserVerseny.setVersenyID(rs.getInt("versenyID"));


                allRegUserVerseny.add(RegUserVerseny);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allRegUserVerseny;
    }
}