package com.lessons.lesson_5.persistence.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String manufacturer;
    private String model;
    private String engineCapacity;
    private String price;
    private String maxSpeed;


    public Car() { }

    public Car(String manufacturer, String model, String engineCapacity, String price, String maxSpeed) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.engineCapacity = engineCapacity;
        this.price = price;
        this.maxSpeed = maxSpeed;
    }

    public static String makeRace(Car car1, Car car2) {
        return String.format("%s and %s now in race!", car1.getManufacturer(), car2.getManufacturer());
    }

    //TODO not implemented
    public static String getManufacturerAndModel() {
        throw new UnsupportedOperationException("No implementation!!!");
    }

    public static void waitInQueue() {
        try {
            Thread.sleep(30L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
