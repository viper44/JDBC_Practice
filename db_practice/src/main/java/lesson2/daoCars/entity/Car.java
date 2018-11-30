package lesson2.daoCars.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Car {
    long id;
    String mark;
    String model;
    int price;

    public Car(String mark, String model, int price){
        this.mark = mark;
        this.model = model;
        this.price = price;
    }
}
