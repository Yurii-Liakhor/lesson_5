package com.lessons.lesson_5.controllers;

import com.lessons.lesson_5.persistence.dao.services.interfaces.CarService;
import com.lessons.lesson_5.persistence.model.Car;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

//    @GetMapping(value = "/car")
//    public ModelAndView car(ModelAndView modelAndView) {
//        modelAndView.setViewName("car/cars");
//        return modelAndView;
//    }

    @GetMapping(value = "/all")
    public ModelAndView listAllCars(ModelAndView modelAndView) throws InterruptedException {
        modelAndView.addObject("cars", carService.findAll());
        modelAndView.setViewName("car/cars");
        return modelAndView;
    }

    @PostMapping(value = "/findByManufacturer")
    public ModelAndView findCarByManufacturer(@RequestParam String manufacturer, ModelAndView modelAndView) {
        modelAndView.addObject("cars", carService.findCarByManufacture(manufacturer));
        modelAndView.setViewName("car/search-results");
        return modelAndView;
    }

    @PostMapping(value = "/findByManufacturerAndModelAndMaxSpeed")
    public ModelAndView findCarByManufacturerAndModelAndMaxSpeed(@RequestParam String manufacturer,
                                                                 @RequestParam String model,
                                                                 @RequestParam String maxSpeed,
                                                                 ModelAndView modelAndView) {
        modelAndView.addObject("cars", carService.findCarByManufacturerAndModelAndMaxSpeed(manufacturer, model, maxSpeed));
        modelAndView.setViewName("car/search-results");
        return modelAndView;
    }

    @PostMapping("/removeById")
    public String removeCarById(HttpServletRequest request) {
        String id = request.getParameter("id");
        carService.removeById(Long.parseLong(id));
        LOG.debug("car with id " + id + " was removed");
        return  "redirect:/car/all";
    }

    @GetMapping("/removeByManufacturer")
    public String removeCarByManufacturer(@RequestParam String manufacturer) {
        carService.removeCarByManufacturer(manufacturer);
        LOG.debug("cars with manufacturer " + manufacturer + " was removed");
        return  "redirect:/car/all";
    }
}
