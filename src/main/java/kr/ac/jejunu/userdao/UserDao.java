package kr.ac.jejunu.userdao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.*;

public class UserDao {
    private final JdbcTemplate jdbcTemplate;

    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public User get(Integer id) throws ClassNotFoundException, SQLException {
        String sql = "select * from portal where id = ?";
        Object[]params = new Object[]{id};
        return jdbcTemplate.query(sql, params, rs -> {
         User user = null;
         if(rs.next()){
             user = new User();
             user.setId(rs.getInt("id"));
             user.setName(rs.getString("name"));
             user.setPassword(rs.getString("password"));
         }
         return user;
        });
    }

    public void insert(User user) throws SQLException {
        String sql = "insert into portal(name,password) values (?,?)";
        Object[] params = new Object[]{user.getName(), user.getPassword()};
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement preparedStatement = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            for(int i=0; i< params.length; i++){
                preparedStatement.setObject(i+1,params[i]);
            }
            return preparedStatement;
        },keyHolder);
        user.setId(keyHolder.getKey().intValue());
    }

    public void update(User user) throws SQLException {
        String sql = "update portal set name = ? ,password=? where id =?";
        Object[] params = new Object[]{user.getName(), user.getPassword(), user.getId()};
        jdbcTemplate.update(sql, params);
    }

    public void delete(Integer id) throws SQLException {
        String sql = "delete from portal where id =?";
        Object[] params = new Object[]{id};
        jdbcTemplate.update(sql, params);
    }

}