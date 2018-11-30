package lesson2.daoExample1;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student {
    Integer id;
    String name;
    Integer groupId;
    Date    enrolmentDate;
    String surname;
}
