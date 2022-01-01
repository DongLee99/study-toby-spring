package study.tobyspring.domain.user.dao;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    @Test
    void UserDaoTest() {
        ConnectionMaker connectionMaker = new DConnectionMaker();
        UserDao userDao = new UserDao(connectionMaker) {
            @Override
            public Connection getConnection() throws SQLException, ClassNotFoundException {
                return null;
            }
        };
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
        UserDao dao = context.getBean("userDao", UserDao.class);
    }
}