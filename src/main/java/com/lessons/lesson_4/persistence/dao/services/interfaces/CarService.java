package com.lessons.lesson_4.persistence.dao.services.interfaces;

import com.lessons.lesson_4.persistence.model.Car;

import java.util.List;


public interface CarService {
    List<Car> findAll() throws InterruptedException;

    Car addCar(Car car);

    void removeById(long id);

    List<Car> findCarByManufacture(String name);

    List<Car> findCarByManufacturerAndModelAndMaxSpeed(String manufacture, String model, String maxSpeed);
}
