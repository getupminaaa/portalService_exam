package kr.ac.jejunu.userdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface ConnectionMaker {
    Connection getConnection() throws ClassNotFoundException, SQLException;
}
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        return DriverManager.getConnection("jdbc:mysql://localhost/portalService?serverTimezone=UTC"
//                , "root", "Rkdalsdk798!");