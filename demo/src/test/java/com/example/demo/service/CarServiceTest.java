package com.example.demo.service;

import com.example.demo.model.Car;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

/**
 * @author bruno.alves.rocha
 */

@SpringBootTest(webEnvironment = RANDOM_PORT)
public class CarServiceTest {


    @Autowired
    private CarService carService;

    @Test
    public void should_return_one_car(){
        final List<Car> cars = carService.allCars();

        assertThat(cars.size(), greaterThan(0));
        assertThat(cars.get(0).getId(), equalTo(1l));

    }

    @Test
    public void should_id_not_null(){
        final List<Car> cars = carService.allCars();
        assertThat(cars.get(1).getId(), notNullValue());

    }

}
