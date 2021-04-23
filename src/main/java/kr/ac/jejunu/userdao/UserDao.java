package kr.ac.jejunu.userdao;

import java.sql.*;

public class UserDao {
    private final JdbcContext jdbcContext;

    public UserDao(JdbcContext jdbcContext) {
        this.jdbcContext = jdbcContext;
    }

    public User get(Integer id) throws ClassNotFoundException, SQLException {
        String sql = "select * from portal where id = ?";
        Object[]params = new Object[]{id};
        return jdbcContext.get(sql, params);
    }

    public void insert(User user) throws SQLException {
        String sql = "insert into portal(name,password) values (?,?)";
        Object[] params = new Object[]{user.getName(), user.getPassword()};
        jdbcContext.insert(user, sql, params);
    }

    public void update(User user) throws SQLException {
        String sql = "update portal set name = ? ,password=? where id =?";
        Object[] params = new Object[]{user.getName(), user.getPassword(), user.getId()};
        jdbcContext.update(sql, params);
    }

    public void delete(Integer id) throws SQLException {
        String sql = "delete from portal where id =?";
        Object[] params = new Object[]{id};
        jdbcContext.update(sql, params);
    }

}