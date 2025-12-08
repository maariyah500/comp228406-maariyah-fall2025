package exercise1;

import java.sql.*;

public class DBConnection {
    private static final String URL = "jdbc:oracle:thin:@199.212.26.208:1521:ORACLE_F25_YU_117_REMOTE";
    private static final String USER = "ORACLE_F25_YU_117";
    private static final String PASS = "Arch402614!";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}

