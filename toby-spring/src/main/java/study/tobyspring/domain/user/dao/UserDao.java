package study.tobyspring.domain.user.dao;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.tobyspring.domain.user.User;

import java.sql.*;

public class UserDao {

    private static UserDao INSTANCE;
    private ConnectionMaker connectionMaker;

    public UserDao(ConnectionMaker connectionMaker) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
        this.connectionMaker = connectionMaker;
    }

    public UserDao() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
        this.connectionMaker = context.getBean("connectionMaker", ConnectionMaker.class);
    }

    public void add(User user) throws ClassNotFoundException, SQLException {
        Connection c = connectionMaker.makeConnection();

        PreparedStatement ps = c.prepareStatement(
                "insert into users(id, name, password) values(?,?,?)");
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();

        ps.close();
        c.close();
    }

    //public abstract Connection getConnection() throws SQLException, ClassNotFoundException;

    public User get(String id) throws  ClassNotFoundException, SQLException {
        Connection c = connectionMaker.makeConnection();

        PreparedStatement ps = c.prepareStatement("select * from users where id = ?");
        ps.setString(1, id);

        ResultSet rs = ps.executeQuery();
        rs.next();
        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        rs.close();
        ps.close();
        c.close();

        return user;
    }

    public static synchronized UserDao getInstance() {
        if (INSTANCE == null) INSTANCE = new UserDao(???);
        return INSTANCE;
    }
}
