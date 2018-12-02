package lesson3;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class ClientDetails {
    @Column
    String name;
   @Id
   @GeneratedValue
    int id;
   @Column
    int age;
   @Column
    String phone;

   public ClientDetails(String name, int age, String phone){
       this.age = age;
       this.name = name;
       this.phone =phone;
   }
   public ClientDetails(){}
}
