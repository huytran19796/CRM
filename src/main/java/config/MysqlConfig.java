package config;

import java.sql.Connection;
import java.sql.DriverManager;

public class MysqlConfig {
    private static String DRIVER_NAME="com.mysql.cj.jdbc.Driver";
    private static String URL="jdbc:mysql://localhost:3307/crm_app";
    private static String USER_NAME="root";
    private static String PASSWORD="admin";
    public static Connection getConnection(){
        Connection connection=null;
        try {
            Class.forName(DRIVER_NAME);
            // open connection
            connection= DriverManager.getConnection(URL,USER_NAME,PASSWORD);
        }catch (Exception e){
            System.out.println("Error connection with database");
        }
        return connection;
    }
}