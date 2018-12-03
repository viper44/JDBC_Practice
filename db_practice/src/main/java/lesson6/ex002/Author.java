package lesson6.ex002;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    String last_name;
    @NonNull
    Integer age;
    String phone;
//    public Author(int id, int age){
//        this.id = id;
//        this.age = age;
//    }
    public Author(int id, String name){
        this.id = id;
        this.name = name;
    }
    public Author(int id, String name, int age){
        this.name = name;
        this.id = id;
        this.age = age;
    }
    public Author(int id, int age){
        this.id = id;
        this.age = age;
    }
    public Author(){}
}
