package ru.job4j.ood.lsp.parking;

/**
 * Class of cargo cars
 *
 * @author Dmitry Emelyanov
 * @version 1.0
 * @since 20.04.2021
 */
public class CargoCar implements Car {

    /**
     * Car size
     */
    private final int size;

    public CargoCar(int size) {
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "CargoCar{"
                + "size=" + size
                + '}';
    }
}