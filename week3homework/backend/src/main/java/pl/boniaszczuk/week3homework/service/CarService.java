package pl.boniaszczuk.week3homework.service;

import pl.boniaszczuk.week3homework.model.Car;
import pl.boniaszczuk.week3homework.model.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface CarService {

    List<Car> getAllCars();
    Optional<Car> getCarById(long id);
    List<Car> getCarsByColor(Color color);
    boolean addCar(Car car);
    Optional<Car> modCar(Car car);
    Optional<Car> changeColorCarById(Color color, long id);
    Optional<Car> removeCarById(long id);


}
