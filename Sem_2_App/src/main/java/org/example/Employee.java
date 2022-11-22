package org.example;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

abstract class Employee {
    final private String name;
    //    static private final Organization organization;
    private Integer salary;


    public Employee(String name, Integer salary) {
        this.name = name;
        this.salary = salary;
        Organization.AddEmployee(this);
    }


    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    // No Encapsulation
    //    public void setSalary(Integer salary) {
    //        this.salary = salary >= 0 ? salary : 0;
    //    }
    // Lets make it
    public void setSalary(Employee employee, int new_salary) {
        if (this instanceof Executive) {
            employee.salary = new_salary;
            System.out.printf("Salary of %s %s changed to %d by %s\n",
                    employee.getName(), employee.getClass().getSimpleName(), new_salary, name);
        } else if (this instanceof Manager) {
            if (employee instanceof Programmer && ((Manager) this).programmerList.contains((Programmer) employee)) {
                employee.salary = new_salary;
                System.out.printf("Salary of %s %s changed to %d by %s\n",
                        employee.getName(), employee.getClass().getSimpleName(), new_salary, name);
            } else if (employee instanceof Secretary) {
                employee.salary = new_salary;
                System.out.printf("Salary of %s %s changed to %d by %s\n",
                        employee.getName(), employee.getClass().getSimpleName(), new_salary, name);
            } else {
                System.out.println(this.getClass().getSimpleName() + " " + name + " cannot change salary");
            }
        } else {
            System.out.println(this.getClass().getSimpleName() + " " + name + " cannot change salary");
        }
    }

    public static class Organization {
        static protected List<Employee> employees = new ArrayList<Employee>();

        private static void AddEmployee(Employee employee) {
            employees.add(employee);
        }

        public static @NotNull Integer SalarySum() {
            return employees.stream().mapToInt(i -> i.salary).sum();
        }
    }
}
