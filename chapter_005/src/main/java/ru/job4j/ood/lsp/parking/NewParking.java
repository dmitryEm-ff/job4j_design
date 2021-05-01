package ru.job4j.ood.lsp.parking;

import java.util.*;

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
        Optional<Place> firstCheck = freeSpaceFinder(car);
        if (firstCheck.isPresent()) {
            firstCheck.get().setStatus(true);
            firstCheck.get().setCar(car);
            return true;
        } else if (car.getSize() > 1) {
            Optional<Place> secondCheck = findSpaceForBigCarsInSmallArray(car);
            if (secondCheck.isPresent()) {
                for (int i = 0; i < car.getSize(); i++) {
                    Place tmp = smallCarsArray.get(smallCarsArray.indexOf(secondCheck.get()) + i);
                    tmp.setStatus(true);
                    tmp.setCar(car);
                }
                return true;
            }
        }
        return false;
    }

    /**
     * Method looking for free space
     *
     * @param car
     * @return place
     */
    public Optional<Place> freeSpaceFinder(Car car) {
        Optional<Place> tmp = Optional.empty();
        if (car.getSize() == 1) {
            tmp = Optional.of(smallCarsArray.stream()
                    .filter(place -> !place.isStatus())
                    .findFirst()).get();
        } else {
            tmp = Optional.of(bigCarsArray.stream()
                    .filter(place -> !place.isStatus())
                    .findFirst()).get();
        }
        return tmp;
    }

    /**
     * Method looks for free space in the smallCarsArray
     *
     * @param car
     * @return place
     */
    public Optional<Place> findSpaceForBigCarsInSmallArray(Car car) {
        Optional<Place> tmp = Optional.empty();
        int counter = 0;
        for (Place p : smallCarsArray) {
            if (!p.isStatus()) {
                counter++;
            } else {
                counter = 0;
            }
            if (counter == car.getSize()) {
                tmp = Optional.ofNullable(smallCarsArray.get(smallCarsArray.indexOf(p) - (car.getSize() - 1)));
                return tmp;
            }
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
        int rsl = (int) bigCarsArray.stream()
                .filter(y -> !y.isStatus())
                .count();
        rsl += getFreeSpaceSmallCar() / 3;
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
}