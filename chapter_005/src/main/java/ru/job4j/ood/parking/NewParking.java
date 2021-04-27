package ru.job4j.ood.parking;

import java.util.*;
import java.util.stream.Stream;

/**
 * Parking realisation
 *
 * @author Dmitry Emelyanov
 * @version 1.0
 * @since 20.04.2021
 */
public class NewParking implements Parking {

    /**
     * Passenger cars List
     */
    private final List<Place> smallCarsArray;

    /**
     * Cargo cars List
     */
    private final List<Place> bigCarsArray;

    public NewParking(int smallCars, int bigCars) {
        this.smallCarsArray = createCarsList(smallCars);
        this.bigCarsArray = createCarsList(bigCars);
    }

    /**
     *Method for auto-parking
     *
     * @param car
     * @return boolean answer
     */
    @Override
    public boolean park(Car car) {
        Place place = freeSpaceFinder(car);
        if (place == null) {
            return false;
        }

        return true;
    }

    /**
     * Method looking for free space
     *
     * @param car
     * @return place
     */
    public Place freeSpaceFinder(Car car) {
        Place tmp = null;
        if (car.getSize() == 1) {
            tmp = spaceFinderLogic(smallCarsArray);
        } else {
            tmp = spaceFinderLogic(bigCarsArray);
            if (tmp == null) {
                int counter = 0;
                for (Place p : smallCarsArray) {
                    if (!p.isStatus()) {
                        counter++;
                    } else {
                        counter = 0;
                    }
                    if (counter == car.getSize()) {
                        tmp = p;
                    }
                }
            }
        }
        return tmp;
    }

    /**
     * Method implements freeSpaceFinder() method
     *
     * @param list
     * @return place
     */

    public Place spaceFinderLogic(List<Place> list) {
        Place tmp = null;
        tmp = list.stream()
                .filter(place -> !place.isStatus())
                .findFirst()
                .get();
        return tmp;
    }

    /**
     *Method for getting a list of passenger cars
     *
     * @return list
     */
    @Override
    public List<Place> getAllSmallCars() {
        return smallCarsArray;
    }

    /**
     * Method for getting a list of cargo cars
     *
     * @ list
     */
    @Override
    public List<Place> getAllBigCars() {
        return bigCarsArray;
    }

    /**
     * Method returns empty spaces for cargo cars
     *
     * @return int
     */
    @Override
    public int getFreeSpaceBigCar() {
        int rsl = (int) Stream.of(smallCarsArray, bigCarsArray)
                .flatMap(Collection::stream)
                .filter(y -> !y.isStatus())
                .count();
        return rsl;
    }

    /**
     * Method returns empty spaces for passenger cars
     *
     * @return int
     */
    @Override
    public int getFreeSpaceSmallCar() {
        int rsl = (int) smallCarsArray.stream()
                .filter(x -> !x.isStatus())
                .count();
        return rsl;
    }

    /**
     * Method used by the constructor.
     *
     * @param size
     * @return list of places
     */
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

//        parking.getAllSmallCars().set(0, new Place(1, true, passengerCar));
//        parking.getAllSmallCars().set(1, new Place(2, true, cargoCar));
//        parking.getAllSmallCars().set(2, new Place(3, true, passengerCar));
//        parking.getAllBigCars().set(0, new Place(1, true, cargoCar));

        parking.park(cargoCar);

        for (Place p : parking.getAllSmallCars()) {
            Optional<Car> test1 = Optional.ofNullable(p.getCar());
            System.out.println(test1.orElse(null));
        }

        System.out.println(System.lineSeparator());

        for (Place p : parking.getAllBigCars()) {
            Optional<Car> test2 = Optional.ofNullable(p.getCar());
            System.out.println(test2.orElse(null));
        }

        System.out.println(parking.getFreeSpaceSmallCar());
        System.out.println(parking.getFreeSpaceBigCar());

        System.out.println(System.lineSeparator());
//
//        parking.park(new PassengerCar());
//        parking.park(new CargoCar(3));
//
        for (Place p : parking.getAllSmallCars()) {
            Optional<Car> test1 = Optional.ofNullable(p.getCar());
            System.out.println(test1.orElse(null));
        }
//
//        System.out.println(System.lineSeparator());
//
//        for (Place p : parking.getAllBigCars()) {
//            Optional<Car> test2 = Optional.ofNullable(p.getCar());
//            System.out.println(test2.orElse(null));
//        }
//
//        System.out.println(parking.getFreeSpaceSmallCar());
//        System.out.println(parking.getFreeSpaceBigCar());
    }
}