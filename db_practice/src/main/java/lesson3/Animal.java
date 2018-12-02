package lesson3;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Animal {
    @Id
    int id;
    String name;
    int age;
    boolean tail;
    public Animal(String name, int age, boolean tail){
        this.name = name;
        this.age = age;
        this.tail = tail;
    }
    public Animal(){}

}
