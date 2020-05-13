package pl.boniaszczuk.databaseapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import pl.boniaszczuk.databaseapp.dao.CarDaoImpl;

@SpringBootApplication
public class DatabaseappApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatabaseappApplication.class, args);
    }



}
