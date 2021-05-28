package ru.job4j.ood.lsp.parking;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class NewParkingTest {

    @Test
    public void whenParkingPassCar() {
        Parking parking = new NewParking(10, 5);
        parking.park(new PassengerCar());
        assertThat(parking.getFreeSpaceSmallCar(), is(9));
    }

    @Test
    public void whenParkingCargoCar() {
        Parking parking = new NewParking(10, 5);
        parking.park(new CargoCar(4));
        assertThat(parking.getFreeSpaceBigCar(), is(7));
    }

    @Test
    public void whenParkingCargoCarOutFreeSpaceInBigCar() {
        Parking parking = new NewParking(10, 1);
        parking.park(new CargoCar(4));
        parking.park(new CargoCar(4));
        assertThat(parking.getFreeSpaceBigCar(), is(2));
        assertThat(parking.getFreeSpaceSmallCar(), is(6));
    }

    @Test
    public void whenParkingCargoCarIsFail() {
        Parking parking = new NewParking(5, 0);
        parking.park(new PassengerCar());
        assertThat(parking.park(new CargoCar(5)), is(false));
    }

    @Test
    public void getFreeSpaceBigCar() {
        Parking parking = new NewParking(10, 5);
        parking.park(new CargoCar(4));
        parking.park(new CargoCar(4));
        assertThat(parking.getFreeSpaceBigCar(), is(6));
    }

    @Test
    public void getFreeSpaceSmallCar() {
        Parking parking = new NewParking(10, 5);
        parking.park(new PassengerCar());
        parking.park(new PassengerCar());
        assertThat(parking.getFreeSpaceSmallCar(), is(8));
    }
}