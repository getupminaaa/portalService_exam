package kr.ac.jejunu.userdao;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;

public class UserDaoTests {

    public static UserDao userDao;
    @BeforeAll
    public static void setUp(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DaoFactory.class);
        userDao = applicationContext.getBean("userDao", UserDao.class);
    }

    @Test
    public void testGet() throws SQLException, ClassNotFoundException {
        Integer id = 1;
        String name = "hulk";
        String password = "1234";
        DaoFactory daoFactory = new DaoFactory();
        userDao = daoFactory.userDao();
        User user = userDao.get(id);
        assertThat(user.getId(), is(id));
        assertThat(user.getName(), is(name));
        assertThat(user.getPassword(), is(password));
    }
    @Test
    public void testInsert() throws SQLException, ClassNotFoundException {
        User user = new User();
        String name = "mina";
        user.setName(name);
        String password = "3993";
        user.setPassword(password);

        DaoFactory daoFactory = new DaoFactory();
        userDao = daoFactory.userDao();

        userDao.insert(user);

        User insertedUser = userDao.get(user.getId());

        assertThat(user.getId(),greaterThan(0));
        assertThat(insertedUser.getName(),is(user.getName()));
        assertThat(insertedUser.getPassword(),is(user.getPassword()));

    }
}
