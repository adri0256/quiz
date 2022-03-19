package config;


import oracle.jdbc.OracleConnection;
import oracle.jdbc.pool.OracleDataSource;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {

    private static Connection con = null;

    private final static String url = Configuration.getValue("db.url");
    private final static String usname = Configuration.getValue("db.usname");
    private final static String pass = Configuration.getValue("db.pass");

    static {
        try {
            OracleDataSource ods = new OracleDataSource();

            System.out.println(url);

            Properties props = new Properties();

            props.put(OracleConnection.CONNECTION_PROPERTY_USER_NAME, usname);
            props.put(OracleConnection.CONNECTION_PROPERTY_PASSWORD, pass);
            props.put(OracleConnection.CONNECTION_PROPERTY_DEFAULT_ROW_PREFETCH, "20");

            ods.setURL(url);
            ods.setConnectionProperties(props);
            con = ods.getConnection();

            // Get the JDBC driver name and version
            DatabaseMetaData dbmd = con.getMetaData();
            System.out.println("Driver Name: " + dbmd.getDriverName());
            System.out.println("Driver Version: " + dbmd.getDriverVersion());
            System.out.println();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        return con;
    }
}
