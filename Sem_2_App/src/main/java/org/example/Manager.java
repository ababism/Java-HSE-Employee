package org.example;

import java.util.ArrayList;
import java.util.List;

class Manager extends Employee {
    protected List<Programmer> programmerList;

    public Manager(String name, Integer salary) {
        super(name, salary);
        programmerList = new ArrayList<Programmer>();
    }

    static int generateNewSalaryIncrease(Employee employee) {
        if (employee instanceof Secretary s) {
            return s.brain.nextInt() % 500 + 250;
        } else if (employee instanceof Programmer) {
//            do not work
            return ((Programmer) employee).taskList.stream().anyMatch(i -> !i.status) ? -15 : 15;
        } else {
            return 0;
        }
    }
}
