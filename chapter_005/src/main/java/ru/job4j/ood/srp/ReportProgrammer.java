package ru.job4j.ood.srp;

import java.util.function.Predicate;

public class ReportProgrammer implements Report {

    private Store store;

    public ReportProgrammer(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("<html>").append(System.lineSeparator());
        text.append("   <body>").append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append("       <employee>").append(System.lineSeparator())
                    .append("           <name> " + employee.getName() + " </name>").append(System.lineSeparator())
                    .append("           <hired> " +  employee.getHired() + " </hired>").append(System.lineSeparator())
                    .append("           <fired> " +  employee.getFired() + " </fired>").append(System.lineSeparator())
                    .append("           <salary> " +  employee.getSalary() + " </salary>").append(System.lineSeparator())
                    .append("       </employee>").append(System.lineSeparator());
        }
        text.append("   </body>").append(System.lineSeparator())
        .append("</html>").append(System.lineSeparator());
        return text.toString();
    }
}
