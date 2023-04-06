package org.example;

import java.sql.*;

public class JdbcConn {

        private static Connection connection;

        public static Connection getConnection() {
            if (connection == null) {
                String url = "jdbc:mysql://localhost:3306/onlineshoping";
                String user = "hbstudent";
                String password = "hbstudent";

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    connection = DriverManager.getConnection(url, user, password);
                } catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                }
            }
            return connection;
        }
}
