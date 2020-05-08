package pl.boniaszczuk.week3homework.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import pl.boniaszczuk.week3homework.controller.CarApi;
import pl.boniaszczuk.week3homework.model.Car;
import pl.boniaszczuk.week3homework.model.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Service
public class CarServiceImpl implements CarService {

    private List<Car> carList;

    public CarServiceImpl() {
        this.carList = new ArrayList<>();
        carList.add(new Car(1L,"Audi","A7", Color.BIAŁY));
        carList.add(new Car(2L,"Mercedes","C-Klasa",Color.CZARNY));
        carList.add(new Car(3L,"Mercedes","S-Klasa",Color.NIEBIESKI));
        carList.add(new Car(4L,"Audi","A5",Color.CZERWONY));
        carList.add(new Car(5L,"Toyota","Yaris",Color.ZIELONY));
        carList.add(new Car(6L,"Ford","Fiesta",Color.NIEBIESKI));
    }

    @Override
    public List<Car> getAllCars() {
        return carList;
    }

    @Override
    public Optional<Car> getCarById(long id) {
        Optional<Car> first = carList.stream().filter(car -> car.getId() == id).findFirst();
        return first;
    }

    @Override
    public List<Car> getCarsByColor(Color color) {
        return carList.stream().filter(e -> e.getcolor().equals(color)).collect(Collectors.toList());

    }

    @Override
    public boolean addCar(Car car) {
        return carList.add(car);
    }

    @Override
    public Optional<Car> modCar(Car newCar) {
        Optional<Car> first = carList.stream().filter(car -> car.getId() == newCar.getId()).findFirst();
        if(first.isPresent()){
            carList.remove(first.get());
            carList.add(newCar);
            return first;
        }
        return first;
    }

    @Override
    public Optional<Car> changeColorCarById(Color newColor, long id) {
        Optional<Car> modColor = carList.stream().filter(carId -> carId.getId() == id).findFirst();
        if (modColor.isPresent()) {
            modColor.get().setcolor(newColor);
        }
        return modColor;
    }

    @Override
    public Optional<Car> removeCarById(long id) {
        Optional<Car> first = carList.stream().filter(car -> car.getId() == id).findFirst();
        if(first.isPresent()){
            carList.remove(first.get());
            return  first;
        }
        return first;
    }
}
