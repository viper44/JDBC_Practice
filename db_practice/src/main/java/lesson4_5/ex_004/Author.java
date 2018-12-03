package lesson4_5.ex_004;

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
    String LastName;
    @Column(name = "age")
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
}
