package ru.job4j.ood.parking;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Parking realisation
 *
 * @author user
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

    }

    /**
     * Method looking for free space for car
     *
     * @param car
     * @return place
     */
    public Place freeSpaceFinder(Car car) {
        Place tmp = null;
        if (car.getSize() == 1) {
            tmp = smallCarsArray.stream()
                    .filter(place -> !place.isStatus())
                    .findFirst()
                    .get();
        } else {
            tmp = Stream.of(smallCarsArray, bigCarsArray)
                    .flatMap(Collection::stream)
                    .filter(place -> !place.isStatus())
                    .findFirst()
                    .get();
        }
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

        parking.getAllSmallCars().set(0, new Place(1, true, passengerCar));
        parking.getAllSmallCars().set(1, new Place(2, true, cargoCar));
        parking.getAllSmallCars().set(2, new Place(3, true, passengerCar));
        parking.getAllBigCars().set(0, new Place(1, true, cargoCar));

        for (Place p : parking.getAllSmallCars()) {
            Optional<Car> test1 = Optional.ofNullable(p.getCar());
            System.out.println(test1.orElse(null));
        }

        for (Place p : parking.getAllBigCars()) {
            Optional<Car> test2 = Optional.ofNullable(p.getCar());
            System.out.println(test2.orElse(null));
        }

        System.out.println(parking.getFreeSpaceSmallCar());
        System.out.println(parking.getFreeSpaceBigCar());
    }

    //        if (car.getSize() == 1) {
//            for (int i = 0; i < smallCarsArray.size(); i++) {
//                Place tmp1 = smallCarsArray.get(i);
//                if (tmp1.isStatus()) {
//                    tmp1.setStatus(false);
//                    smallCarsArray.set(i, tmp1);
//                    return true;
//                }
//            }
//            return false;
//        } else {
//            for (int i = 0; i < bigCarsArray.size(); i++) {
//                Place tmp2 = bigCarsArray.get(i);
//                if (tmp2.isStatus()) {
//                    tmp2.setStatus(false);
//                    bigCarsArray.set(i, tmp2);
//                    return true;
//                } else {
//                    for (int j = 0; j < smallCarsArray.size(); j++) {
//                        Place tmp3 = smallCarsArray.get(j);
//                        if (tmp3.isStatus()) {
//                            tmp3.setStatus(false);
//                            smallCarsArray.set(j, tmp3);
//                            return true;
//                        }
//                    }
//                }
//            }
//        }
//        return false;
}