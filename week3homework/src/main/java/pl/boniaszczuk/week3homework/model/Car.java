package pl.boniaszczuk.week3homework.model;


import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Car extends RepresentationModel {

    @Min(0)
    @Max(100)
    private long id;
    @NotNull
    private String brand;
    @NotNull
    private String model;
    private Color color;

    public Car(long id, String brand, String model, Color color) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.color = color;
    }

    public Car() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Color getcolor() {
        return color;
    }

    public void setcolor(Color color) {
        this.color = color;
    }


}
