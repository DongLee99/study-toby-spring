package study.tobyspring.domain.user.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 애플리케이션 컨텍스트 또는 빈 팩토리가 사용할 설정 정보라는 표시
public class DaoFactory {

    @Bean // 오브젝트 생성을 담당하는 IoC용 메소드라는 표시
    public UserDao userDao() {
        ConnectionMaker connectionMaker = new DConnectionMaker();
        UserDao userDao = new UserDao(connectionMaker);
        return userDao;
    }

    @Bean
    public AccountDao accountDao() {
        return new AccountDao(connectionMaker());
    }

    @Bean
    public ConnectionMaker connectionMaker() {
        return new DConnectionMaker();
    }
}
