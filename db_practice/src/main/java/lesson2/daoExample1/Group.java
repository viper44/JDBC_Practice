package lesson2.daoExample1;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Group {
    Integer id;
    String department;
    int number;
}
