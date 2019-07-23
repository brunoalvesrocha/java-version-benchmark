package com.example.demo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

/**
 * @author bruno.alves.rocha
 */
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class CarRepositoryTest {

    @Autowired
    private CarRepository repository;


    @Test
    public void should_one_car(){



    }
}
