package lesson2.daoExample1;

import java.util.List;

public interface StudentDao {
    Student create();
    Student read(int id);
    void update(Student student);
    void delete(Student student);
    List<Student> getAll();
}
