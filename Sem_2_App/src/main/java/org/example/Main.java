package org.example;

import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        var secretary = new Secretary("Natalya", 3);

        var manager = new Manager("Pasha", 1500);

        var programmer = new Programmer("Gigachad", 3000);

        var junior = new Programmer("Chuikin", 2500);

        var executive = new Executive("Ivan", 300_000_000);

        System.out.println(executive.addProgrammerToManager(programmer, executive));

        System.out.print("_______________________________________________\n");
        System.out.printf("Org should pay: %d\n", Employee.Organization.SalarySum());
        System.out.print("_______________________________________________\n");

        manager.setSalary(junior, 1250);
        executive.setSalary(junior, 1250);

        executive.addProgrammerToManager(junior, manager);
        System.out.println("Team of Pasha:");
        for (var i : manager.programmerList) {
            System.out.printf("%s %s gets %d$\n", i.getName(), i.getClass().getSimpleName(), i.getSalary());
        }
        manager.setSalary(junior, 1000);

        manager.setSalary(secretary, Manager.generateNewSalaryIncrease(secretary));
        System.out.print("\n");

        secretary.GenerateTasks(manager);
        secretary.GenerateTasks(programmer);

        programmer.printTasks();

        executive.setSalary(programmer, programmer.getSalary() + Manager.generateNewSalaryIncrease(programmer));
        System.out.print("\n");

        programmer.DoAllTasks();
        programmer.printTasks();
        executive.setSalary(programmer, programmer.getSalary() + Manager.generateNewSalaryIncrease(programmer));

        System.out.print("\n_______________________________________________\n");
        System.out.println("List of employees:");
        for (var i : Employee.Organization.employees) {
            System.out.printf("%s %s gets %d$\n", i.getName(), i.getClass().getSimpleName(), i.getSalary());
        }

        System.out.print("\n__________Interface test________________\n");
        Predicate<Programmer> predicate = programmer1 -> programmer1.getSalary() > 1000;
        programmer.giveSocialCredits(predicate, 15);
        System.out.println(programmer.getSocialCredits());
    }
}
