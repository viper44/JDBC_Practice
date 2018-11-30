package lesson2.daoExample1;

import java.sql.Connection;

public interface DaoFactory {
    Connection getConnection();
    GroupDao getGroupDao();
    StudentDao getStudentDao();
}
