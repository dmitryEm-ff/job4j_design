package ru.job4j.ood.srp;

import java.util.function.Predicate;

public class ReportProgrammer implements Report {

    private Store store;

    public ReportProgrammer(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        return null;
    }
}
