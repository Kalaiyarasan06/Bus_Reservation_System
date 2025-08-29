package BusResrv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static String url="jdbc:mysql://localhost:3306/busresrv";
    private static String username="root";
    private static String password="XXXXXXXXXX";

    public static Connection  getConnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }

}
