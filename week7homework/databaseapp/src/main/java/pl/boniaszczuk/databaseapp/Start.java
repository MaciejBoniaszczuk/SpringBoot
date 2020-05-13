package pl.boniaszczuk.databaseapp;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.boniaszczuk.databaseapp.dao.CarDaoImpl;

@Component
public class Start {

    private CarDaoImpl carDao;

    public Start(CarDaoImpl carDao) {
        this.carDao = carDao;
    }

}
