package kr.ac.jejunu.userdao;public class ConnectionMaker{	public ConnectionMaker()	{	}public java.sql.Connection getConnection() throws java.lang.ClassNotFoundException, java.sql.SQLException{
        java.lang.Class.forName("com.mysql.cj.jdbc.Driver");
        return java.sql.DriverManager.getConnection("jdbc:mysql://localhost/portalService?serverTimezone=UTC"
                , "root", "Rkdalsdk798!");
    }}