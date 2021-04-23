package kr.ac.jejunu.userdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StatementStrategyForGet implements StatementStrategy {
    @Override
    public PreparedStatement makeStatement(Object object, Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("select * from portal where id = ?");
        Integer id = (Integer)object;
        preparedStatement.setInt(1, id);
        return preparedStatement;
    }
}
