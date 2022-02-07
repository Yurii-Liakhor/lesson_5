package com.lessons.lesson_5.controllers;

import com.lessons.lesson_5.persistence.model.Car;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Iterator;
import java.util.List;

@FixMethodOrder
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/app-simple-ctx.xml"})
public class UnitTester {
    @Autowired
    List<Car> carList;
    @Autowired
    @Qualifier(value = "car1")
    Car car;

    @Test
    public void carTest() {
        Assert.assertEquals("Tesla", car.getManufacturer());
    }

    @Test
    public void raceTest() {
        System.out.println("******************");
        System.out.println("info about race");
        Iterator<Car> it = carList.iterator();
        while (it.hasNext()) {
            Car tempCar = it.next();
            if (it.hasNext()) {
                System.out.println(Car.makeRace(tempCar, it.next()));
            }
        }
    }

    @Test(expected = UnsupportedOperationException.class)
    public void carTest2() {
        Car.getManufacturerAndModel();
    }

    @Test(timeout = 15L)
    public void carTest3() {
        Car.waitInQueue();
    }

    @Test(timeout = 60L)
    public void carTest4() {
        Car.waitInQueue();
    }
}
