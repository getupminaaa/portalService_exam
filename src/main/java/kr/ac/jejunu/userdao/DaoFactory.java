package kr.ac.jejunu.userdao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

@Configuration
public class DaoFactory {

    @Bean
    public UserDao userDao() throws SQLException, ClassNotFoundException {
        return new UserDao(getConnectionMaker());
    }

    @Bean
    public JejuConnectionMaker getConnectionMaker() {
        return new JejuConnectionMaker();
    }

}
