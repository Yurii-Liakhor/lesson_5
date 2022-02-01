package com.lessons.lesson_4.persistence.model;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
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
}
