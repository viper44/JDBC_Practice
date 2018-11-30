package lesson2.daoExample1;

import java.util.List;

public interface GroupDao {
    Group create();
    Group read(int id);
    void update(Group group);
    void delete(Group group);
    List<Group> getAll();

}
