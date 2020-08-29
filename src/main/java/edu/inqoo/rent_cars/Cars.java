package edu.inqoo.rent_cars;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    List<RentCars> listCars = new ArrayList<>();
    List<RentCars> listRentCars = new ArrayList<>();

    public Cars() {
        listCars.add(new RentCars("Audi", "A4", "SK 0748K",
                "Blue", TypeCar.KOMBI));
        listCars.add(new RentCars("BMW", "E90", "SK 05K0L",
                "Black", TypeCar.HATCHBACK));
        listCars.add(new RentCars("Ford", "Mondeo", "SK 0568K",
                "Red", TypeCar.KOMBI));
        listCars.add(new RentCars("Porsche", "Cayenne", "SK 0748K",
                "Gold", TypeCar.SUV));
        listCars.add(new RentCars("Fiat", "Stilo", "SK 75847",
                "Silver", TypeCar.HATCHBACK));
        listCars.add(new RentCars("Opel", "Astra", "SK KH869",
                "Orange", TypeCar.HATCHBACK));
        listCars.add(new RentCars("Reanult", "Twingo", "SK 087TY",
                "Gray", TypeCar.HATCHBACK));
        listCars.add(new RentCars("Hyundai", "X90", "SK 0908K",
                "", TypeCar.SUV));
        listCars.add(new RentCars("Honda", "Civic", "SK 07J8K",
                "Red", TypeCar.HATCHBACK));
        listCars.add(new RentCars("Toyota", "Corolla", "SK 07HJK",
                "White", TypeCar.KOMBI));
    }

    public void rentCar(String plate) {
        RentCars tempCars = null;
        for (RentCars car : listCars) {
            if (plate.equals(car.getPlate())) {
                car.setDate(LocalDate.now().plusDays(-7));
                tempCars = car;
            }
        }
        listCars.remove(tempCars);
        listRentCars.add(tempCars);
    }

    public void returnCar(String plate) {
        RentCars tempCars = null;
        for (RentCars car : listCars) {
            if (plate.equals(car.getPlate())) {
                car.setDate(null);
                tempCars = car;
            }
        }
        listRentCars.remove(tempCars);
        listCars.add(tempCars);
    }

    public List showRentCars() {

        System.out.println(toString());
        return this.listRentCars;
    }

    @Override
    public String toString() {
        return "Cars{" +
                "listCars=" + listCars +
                ", listRentCars=" + listRentCars +
                '}';
    }

    public List<RentCars> getListCars() {
        List<RentCars> newList = new ArrayList<>(listCars);
        newList.addAll(listRentCars);
        return newList;
    }

    public List<RentCars> getFreeCars() {
        return listCars;
    }

    public List<RentCars> getExpiredCars() {
        return listRentCars.stream()
                .filter(cars -> cars.getDate().isBefore(LocalDate.now()))
                .collect(Collectors.toList());
    }
}