package study.tobyspring.domain.user.dao;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import study.tobyspring.domain.user.User;

import java.sql.Connection;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

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

    @Test()
    public void addAndGet() throws SQLException, ClassNotFoundException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserDao dao = context.getBean("userDao", UserDao.class);

        User user = new User();
        user.setId("user");
        user.setName("동현");
        user.setPassword("married");
        dao.add(user);

        assertThat(user.getId()).isEqualTo("user");
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
//        UserDao dao = context.getBean("userDao", UserDao.class);
//
//        User user = new User();
//        user.setId("user");
//        user.setName("동현");
//        user.setPassword("married");
//
//        dao.add(user);
//
//        System.out.println(user.getId());
//
//        User user2 = dao.get(user.getId());
//        if (!user.getName().equals(user2.getName())) {
//            System.out.println("테스트 실패 (name)");
//        } else if (!user.getPassword().equals(user2.getPassword())) {
//            System.out.println("테스트 실패 (password)");
//        } else {
//            System.out.println("조회 테스트 성공");
//        }
    }
}