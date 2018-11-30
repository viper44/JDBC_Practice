package lesson2.daoCars.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Client {
    int id;
    String name;
    int age;
    String phone;
}
