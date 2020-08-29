package edu.inqoo.rent_cars;

import java.time.LocalDate;

public class RentCars {
    private String brand;
    private String model;
    private String plate;
    private String color;
    private TypeCar type;
    private LocalDate date;

       public RentCars(String brand, String model, String plate, String color, TypeCar type){
           this.brand = brand;
           this.model = model;
           this.plate = plate;
           this.color = color;
           this.type = type;
       }

    public String getPlate() {
        return plate;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }
}


