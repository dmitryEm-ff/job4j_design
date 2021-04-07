package ru.job4j.kiss;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;

public class MaxMin {

    public static <T> T max(List<T> value, Comparator<T> comparator) {
        BiPredicate<T, T> maxPredic = (t, u) -> (comparator.compare(t, u) < 0);
        return manualComparator(value, maxPredic);
    }

    public static <T> T min(List<T> value, Comparator<T> comparator) {
        BiPredicate<T, T> minPredic = (t, u) -> (comparator.reversed().compare(t, u) < 0);
        return manualComparator(value, minPredic);
    }

    private static <T> T manualComparator(List<T> list, BiPredicate<T, T> predicate) {
        T valuePoint = list.get(0);
        for (T t : list) {
            if (predicate.test(valuePoint, t)) {
                valuePoint = t;
            }
        }
        return valuePoint;
    }

    public static void main(String[] args) {
        List<Integer> testList = Arrays.asList(5, 15, 100, -6, 11, 20);
        System.out.println(max(testList, Integer::compareTo));
        System.out.println(min(testList, Integer::compareTo));
    }
}