package study.tobyspring.domain.user.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class DaoFactory {

    public UserDao userDao() {
        ConnectionMaker connectionMaker = new DConnectionMaker();
        UserDao userDao = new UserDao(connectionMaker);
        return userDao;
    }

    public AccountDao accountDao() {
        return new AccountDao(connectionMaker());
    }

    public ConnectionMaker connectionMaker() {
        return new DConnectionMaker();
    }
}
