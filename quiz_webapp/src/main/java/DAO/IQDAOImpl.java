package DAO;

import config.DatabaseConnection;
import model.IQ;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class IQDAOImpl implements IQDAO {
    private Connection con;

    private final static String selectAllIQ = "SELECT * FROM IQ";

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
}