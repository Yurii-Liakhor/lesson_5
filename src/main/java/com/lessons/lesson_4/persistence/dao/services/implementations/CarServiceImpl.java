package com.lessons.lesson_4.persistence.dao.services.implementations;

import com.google.common.collect.Lists;
import com.lessons.lesson_4.persistence.dao.repositories.CarRepository;
import com.lessons.lesson_4.persistence.dao.services.interfaces.CarService;
import com.lessons.lesson_4.persistence.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private CarRepository carRepository;

    @Override
    public List<Car> findAll() throws InterruptedException {
        return Lists.newArrayList(carRepository.findAll());
    }

    @Override
    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public void removeById(long id) {
        carRepository.deleteById(id);
    }

    @Override
    public List<Car> findCarByManufacture(String name) {
        return carRepository.findCarByManufacturer(name);
    }

    @Override
    public List<Car> findCarByManufacturerAndModelAndMaxSpeed(String manufacture, String model, String maxSpeed) {
        return carRepository.findCarByManufacturerAndModelAndMaxSpeed(manufacture, model, maxSpeed);
    }

    @Override
    public List<Car> removeCarByManufacturer(String manufacture) {
        return carRepository.removeCarByManufacturer(manufacture);
    }

    @Autowired
    public void setCarRepository(CarRepository carRepository) {
        this.carRepository = carRepository;
    }
}
