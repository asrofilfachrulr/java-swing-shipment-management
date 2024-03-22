package Helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
    private static String user = "admin";
    private static String pw = "admin";
    private static String dbName = "shipment_management";
    private static String host = "localhost";
    private static String port = "3306";

    public static Connection getDBConnection() throws SQLException, ClassNotFoundException {
        String connUrl = String.format("jdbc:mysql//%s:%s/%s", host, port, dbName);
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(connUrl, user, pw);
    }

}
