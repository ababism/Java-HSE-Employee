package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class Programmer extends Employee implements SocialCreditable {
    protected List<Task> taskList;
    private int socialCredits = 0;

    public Programmer(String name, Integer salary) {
        super(name, salary);
        taskList = new ArrayList<Task>();
    }

    public void DoAllTasks() {
        taskList.forEach(task -> task.status = true);
        System.out.printf("%s Programmer has done all tasks\n", getName());
    }

    public void printTasks() {
        System.out.printf("Tasks of %s programmer:\n", getName());
        for (var task : taskList) {
            System.out.printf("%s status of %s\n", task.status ? "done:" : "not finished:", task.text);
        }
    }

    @Override
    public int getSocialCredits() {
        return socialCredits;
    }

    @Override
    public void giveSocialCredits(Predicate<Programmer> predicate, int amount) {
        if (predicate.test(this)) {
            socialCredits += amount;
        }
    }


}
