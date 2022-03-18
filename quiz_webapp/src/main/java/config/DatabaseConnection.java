package config;


import oracle.jdbc.pool.OracleDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnection {

    private static Connection con = null;

    private final static String url = Configuration.getValue("db.url");
    private final static String usname = Configuration.getValue("db.usname");
    private final static String pass = Configuration.getValue("db.pass");

    static {
        try {
            OracleDataSource ods = new OracleDataSource();
            Class.forName("oracle.jdbc.OracleDriver");

            ods.setURL(url);
            con = ods.getConnection(usname,pass);
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        return con;
    }
}
