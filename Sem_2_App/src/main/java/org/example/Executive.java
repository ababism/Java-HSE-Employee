package org.example;

import org.jetbrains.annotations.NotNull;

class Executive extends Manager {

    public Executive(String name, Integer salary) {
        super(name, salary);
    }

    String addProgrammerToManager(Programmer programmer, @NotNull Manager manager) {
        manager.programmerList.add(programmer);
        return String.format("%s added to %s team", programmer.getName(), manager.getName());
    }
}
