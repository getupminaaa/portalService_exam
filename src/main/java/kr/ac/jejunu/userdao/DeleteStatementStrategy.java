package kr.ac.jejunu.userdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteStatementStrategy implements StatementStrategy {
    private Integer id;
    public DeleteStatementStrategy(Integer id){
        this.id = id;
    }

    @Override
    public PreparedStatement makeStatement(Connection connection) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement("delete from portal where id =?");
        preparedStatement.setInt(1, id);
        return preparedStatement;
    }
}
