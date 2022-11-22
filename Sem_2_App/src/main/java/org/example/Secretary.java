package org.example;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

class Secretary extends Employee {
    final public Random brain;

    public Secretary(String name, Integer salary) {
        super(name, salary);
        brain = new Random(LocalDateTime.now().getMinute());
    }

    private final List<String> taskPull = Arrays.asList("Chill",
            "Touch grass",
            "Work for until lunch",
            "Reorder JSONs",
            "Have a meetup");

    public void GenerateTasks(Employee employee) {
        if (employee instanceof Programmer) {
            int amount = Math.abs(brain.nextInt() % 3) + 1;
            for (int it = 0; it < amount; ++it) {
                ((Programmer) employee).taskList.add(new Task(taskPull.get(Math.abs(brain.nextInt() % 4))));
            }
            System.out.printf("%d Tasks for %s %s created by %s\n", amount,
                    employee.getName(), employee.getClass().getSimpleName(), this.getName());
        } else {
            System.out.println(employee.getClass().getSimpleName() + " " + employee.getName() + " is cannot have tasks");
        }
    }
}
