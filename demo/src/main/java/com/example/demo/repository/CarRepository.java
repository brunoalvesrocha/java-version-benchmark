package com.example.demo.repository;

import com.example.demo.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author bruno.alves.rocha
 */

public interface CarRepository extends JpaRepository<Car, Long> {

}
