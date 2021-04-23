package kr.ac.jejunu.userdao;

import org.hamcrest.core.IsNull;
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

        userDao.insert(user);

        User insertedUser = userDao.get(user.getId());

        assertThat(user.getId(),greaterThan(0));
        assertThat(insertedUser.getName(),is(user.getName()));
        assertThat(insertedUser.getPassword(),is(user.getPassword()));

    }
    @Test
    public void testUpdate() throws SQLException, ClassNotFoundException {
        User user = new User();
        String name = "mina";
        user.setName(name);
        String password = "3993";
        user.setPassword(password);

        userDao.insert(user);

        String updateName = "pppp";
        String updatePassword = "0000";

        user.setName(updateName);
        user.setPassword(updatePassword);

        userDao.update(user);
        User updatedUser = userDao.get(user.getId());

        assertThat(updatedUser.getName(),is(updateName));
        assertThat(updatedUser.getPassword(),is(updatePassword));

    }
    @Test
    public void testDelete() throws SQLException, ClassNotFoundException {
        User user = new User();
        String name = "mina";
        user.setName(name);
        String password = "3993";
        user.setPassword(password);

        userDao.insert(user);

        userDao.delete(user);
        User deletedUser = userDao.get(user.getId());
        assertThat(deletedUser.getId(), IsNull.nullValue());

    }
}
