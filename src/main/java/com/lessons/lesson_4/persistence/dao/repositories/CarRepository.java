package com.lessons.lesson_4.persistence.dao.repositories;

import com.lessons.lesson_4.persistence.model.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface CarRepository extends CrudRepository<Car, Long> {
    List<Car> findCarByManufacturer(String name);
    List<Car> findCarByManufacturerAndModelAndMaxSpeed(String manufacture, String model, String maxSpeed);
    List<Car> removeCarByManufacturer(String manufacture);
}
