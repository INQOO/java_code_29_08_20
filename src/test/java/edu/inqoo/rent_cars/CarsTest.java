package edu.inqoo.rent_cars;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class CarsTest {
    @Test
    public void shouldCheckListRentCarSize(){
        //given
        Cars cars = new Cars();
        //when
        cars.rentCar("SK 0748K");
        int result = cars.listRentCars.size();
        //then
        Assertions.assertEquals(1, result);
        Assertions.assertNotEquals(2, result);
    }

    @Test
    public void shouldCheckFreeListCarSize(){
        //given
        Cars cars = new Cars();
        //when
        cars.rentCar("SK 0748K");
        cars.returnCar("SK 0748K");
        int result = cars.listCars.size();
        //then
        Assertions.assertEquals(10, result);
        Assertions.assertNotEquals(9, result);
    }

    @Test
    public void shouldCheckAllCarsList(){
        //given
        Cars cars = new Cars();
        //when
        cars.rentCar("SK 0748K");
        int result = cars.getListCars().size();
        //then
        Assertions.assertEquals(10, result);
        Assertions.assertEquals(9, cars.listCars.size());
    }
    @Test
    public void shouldCheckExpiredListCars(){
        //given
        Cars cars = new Cars();
        //when
        cars.rentCar("SK 0748K");
        int result = cars.getExpiredCars().size();
        //then
        Assertions.assertEquals(1, result);
        Assertions.assertEquals(9, cars.listCars.size());
    }
}