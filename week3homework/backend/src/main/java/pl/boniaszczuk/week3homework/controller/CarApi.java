package pl.boniaszczuk.week3homework.controller;


import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.boniaszczuk.week3homework.model.Car;
import pl.boniaszczuk.week3homework.model.Color;
import pl.boniaszczuk.week3homework.service.CarService;
import pl.boniaszczuk.week3homework.service.CarServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("/cars")
@CrossOrigin
public class CarApi  {

    private CarServiceImpl carService;

    public CarApi(CarServiceImpl carService) {
        this.carService = carService;
    }

    //pobieranie wszystkich pozycji
    @GetMapping
    public ResponseEntity<CollectionModel<Car>> getCars(){
        carService.getAllCars().forEach(car -> car.add(linkTo(CarApi.class).slash(car.getId()).withSelfRel()));
        Link link = linkTo(CarApi.class).withSelfRel();
        CollectionModel<Car> carCollectionModel = new CollectionModel<>(carService.getAllCars(),link);
        return new ResponseEntity<>(carCollectionModel, HttpStatus.OK);
    }
//    @GetMapping
//    public List<Car> getCars(){
//        return carService.getAllCars();
//    }

    //pobieranie elementu po ID
    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Car>> getCarById(@PathVariable long id){
        Link link = linkTo(CarApi.class).slash(id).withSelfRel();
        Optional<Car> carById = carService.getCarById(id);
        if(carById.isPresent()){
            EntityModel<Car> carEntityModel = new EntityModel<>(carById.get(),link);
            return new ResponseEntity<>(carEntityModel, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    //pobieranie elementów w określonym kolorze
    @RequestMapping(value = "/color/{color}", method = RequestMethod.GET)
    public ResponseEntity<CollectionModel<Car>> getCarByColor(@PathVariable String color){
        List<Car> carList = carService.getCarsByColor(Color.valueOf(color.toUpperCase()));
        carList.forEach(car -> car.add(linkTo(CarApi.class).slash(car.getId()).withSelfRel()));
        carList.forEach(car -> car.add(linkTo(CarApi.class).withRel("allColors")));
        Link link = linkTo(CarApi.class).withSelfRel();
        CollectionModel<Car> carCollectionModel = new CollectionModel<>(carList,link);
        Optional<Car> first1 = carList.stream().filter(car -> car.getcolor().equals(Color.valueOf(color.toUpperCase())))
                .findFirst();
        if(first1.isPresent()){
            return new ResponseEntity<>(carCollectionModel, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    //Dodawanie pozycji
    @PostMapping
    public ResponseEntity addCar(@Validated @RequestBody Car car){
        if(carService.addCar(car)){
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

    }
    //modyfikowanie pozycji
    @PutMapping
    public ResponseEntity modCar(@RequestBody Car newCar){

        if(carService.modCar(newCar).isPresent()){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    //modyfikowanie jednego z pola(do poprawy)
    @PatchMapping("/{id}")
    public ResponseEntity patchModelCarById(@RequestParam Color color, @PathVariable long id){
        Optional<Car> modColor = carService.changeColorCarById(color, id);
        if(modColor.isPresent()){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    //usuwanie pozycji
    @DeleteMapping("/{id}")
    public ResponseEntity deleteCar(@PathVariable  long id){

        if(carService.removeCarById(id).isPresent()){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
