package ru.job4j.ood.parking;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class NewParking implements Parking {

    private final List<Place> smallCarsArray;
    private final List<Place> bigCarsArray;

    public NewParking(int smallCars, int bigCars) {
        this.smallCarsArray = createCarsList(smallCars);
        this.bigCarsArray = createCarsList(bigCars);
    }

    @Override
    public boolean park(Car car) {
        return false;
    }

    @Override
    public List<Place> getAllSmallCars() {
        return smallCarsArray;
    }

    @Override
    public List<Place> getAllBigCars() {
        return bigCarsArray;
    }

    @Override
    public int getFreeSpaceBigCar() {
        return 0;
    }

    @Override
    public int getFreeSpaceSmallCar() {
        return 0;
    }

    public List<Place> createCarsList(int size) {
        List<Place> rsl = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            rsl.add(new Place(i + 1, false));
        }
        return rsl;
    }

    public static void main(String[] args) {
        Parking parking = new NewParking(10, 5);
        System.out.println(parking.getAllSmallCars().size());
        System.out.println(parking.getAllBigCars().size());

        Car passengerCar = new PassengerCar();
        Car cargoCar = new CargoCar(3);

        parking.getAllSmallCars().set(0, new Place(1, true, passengerCar));
        parking.getAllBigCars().set(0, new Place(1, true, cargoCar));
        parking.getAllSmallCars().set(1, new Place(2, true, cargoCar));


        for (Place p : parking.getAllSmallCars()) {
            Optional<Car> test1 = Optional.ofNullable(p.getCar());
            System.out.println(test1.orElse(null));
        }

        for (Place p : parking.getAllBigCars()) {
            Optional<Car> test2 = Optional.ofNullable(p.getCar());
            System.out.println(test2.orElse(null));
        }
    }
}