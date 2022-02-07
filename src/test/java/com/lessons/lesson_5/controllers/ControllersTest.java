package com.lessons.lesson_5.controllers;

import com.lessons.lesson_5.persistence.model.Car;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@FixMethodOrder
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/app-simple-ctx.xml"})
@WebAppConfiguration
public class ControllersTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testController() throws Exception {
        mockMvc.perform(get("/car/all")).andDo(print()).andExpect(view().name("car/cars"));
    }

    @Test
    public void testController2() throws Exception {
        mockMvc.perform(get("/car/all")).andExpect(status().isOk()).andExpect(view().name("car/cars"));
    }

    @Test
    public void testController3() throws Exception {
        System.out.println(mockMvc.perform(post("/car/findByManufacturer/")
                .param("manufacturer", "Tesla"))
                .andExpect(status().is2xxSuccessful()).andReturn().getModelAndView().getModel().get("cars"));
    }

    @Test
    public void testController4() throws Exception {
        mockMvc.perform(get("/car/all")).andExpect(status().is2xxSuccessful());
    }
}
