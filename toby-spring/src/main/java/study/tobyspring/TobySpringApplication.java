package study.tobyspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import study.tobyspring.domain.user.User;
import study.tobyspring.domain.user.dao.UserDao;

import java.sql.SQLException;

@SpringBootApplication
public class TobySpringApplication {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		UserDao dao = new UserDao();

		User user = new User();
		user.setId("donglee99");
		user.setName("이동현");
		user.setPassword("married");

		dao.add(user);
		System.out.println(user.getId() + "등록 성공");
		User user2 = dao.get(user.getId());
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());

		System.out.println(user2.getId() + "조회 성공");
		//SpringApplication.run(TobySpringApplication.class, args);
	}

}
