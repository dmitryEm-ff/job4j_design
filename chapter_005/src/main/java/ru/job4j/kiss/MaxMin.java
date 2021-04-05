package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;

public class MaxMin {

    public <T> T max(List<T> value, Comparator<T> comparator) {
        T maximum = value.get(0);
        for (T t : value) {
            if (comparator.compare(maximum, t) < 0) {
                maximum = t;
            }
        }
        return maximum;
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        T minimum = value.get(0);
        for (T t : value) {
            if (comparator.reversed().compare(minimum, t) < 0) {
                minimum = t;
            }
        }
        return minimum;
    }
}