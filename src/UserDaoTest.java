import DAO.ConnectionMaker;
import DAO.DConnectionMaker;
import DAO.DaoFactory;
import Domain.User;
import DAO.UserDao;
import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDaoTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
//        UserDao dao = new DaoFactory().userDao();
        UserDao dao = context.getBean("userDao", UserDao.class);

        User user = new User();
        user.setId("view!");
        user.setName("123jblee");
        user.setPassword("married");

//        dao.add(user);

        System.out.println(user.getId() + " 등록 성공");

        User user2 = dao.get(user.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getPassword());

        System.out.println(user2.getId() + " 조회 성공");
    }
}