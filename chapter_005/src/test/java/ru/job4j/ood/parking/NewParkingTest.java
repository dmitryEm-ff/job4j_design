package ru.job4j.ood.parking;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import static org.junit.Assert.*;

public class NewParkingTest {

    @Test
    public void whenParkingPassCar() {
        NewParking newParking = new NewParking(10, 5);
        newParking.park(new PassengerCar());
        assertThat(newParking.getFreeSpaceSmallCar(), is(9));
    }

    @Test
    public void whenParkingCargoCar() {
        NewParking newParking = new NewParking(10, 5);
        newParking.park(new CargoCar(4));
        assertThat(newParking.getFreeSpaceBigCar(), is(4));
    }

    @Test
    public void whenParkingCargoCarOutFreeSpaceInBigCar() {
        NewParking newParking = new NewParking(10, 1);
        newParking.park(new CargoCar(4));
        newParking.park(new CargoCar(4));
        assertThat(newParking.getFreeSpaceBigCar(), is(0));
        assertThat(newParking.getFreeSpaceSmallCar(), is(6));
    }

    @Test
    public void whenParkingCargoCarIsFail() {
        NewParking newParking = new NewParking(5, 0);
        newParking.park(new PassengerCar());
        assertThat(newParking.park(new CargoCar(5)), is(false));
    }

    @Test
    public void getAll() {
    }

    @Test
    public void getFreeSpaceBigCar() {
    }

    @Test
    public void getFreeSpaceSmallCar() {
    }
}