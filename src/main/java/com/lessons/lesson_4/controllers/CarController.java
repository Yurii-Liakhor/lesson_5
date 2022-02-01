package com.lessons.lesson_4.controllers;

import com.lessons.lesson_4.persistence.dao.services.interfaces.CarService;
import com.lessons.lesson_4.persistence.model.Car;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/car")
public class CarController {
    private static final Log LOG = LogFactory.getLog(CarController.class);

    @Autowired
    private CarService carService;

    @PostMapping("/add")
    public String addCar(HttpServletRequest request) {
        Car car = new Car();
        car.setManufacturer(request.getParameter("manufacturer"));
        car.setModel(request.getParameter("model"));
        car.setEngineCapacity(request.getParameter("engineCapacity"));
        car.setMaxSpeed(request.getParameter("maxSpeed"));
        car.setPrice(request.getParameter("price"));
        LOG.debug("new car with id " + carService.addCar(car) + " was added");
        return  "redirect:/car/all";
    }

    @GetMapping(value = "/all")
    public ModelAndView listAllCars(ModelAndView modelAndView) throws InterruptedException {
        modelAndView.addObject("employees", carService.findAll());
        modelAndView.setViewName("car/cars");
        return modelAndView;
    }
}
