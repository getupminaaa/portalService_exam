package kr.ac.jejunu.userdao;

import java.sql.Connection;
import java.sql.SQLException;

public class DaoFactory {

    public UserDao getUserDao() throws SQLException, ClassNotFoundException {
        return new UserDao(getConnectionMaker());
    }

    private JejuConnectionMaker getConnectionMaker() {
        return new JejuConnectionMaker();
    }

}
