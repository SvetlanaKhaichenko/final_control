package model.impl;

import model.Animal;

import java.time.LocalDate;

public abstract class PackAnimals extends Animal {

    public PackAnimals(String name, LocalDate birthday, String commands) {
        super(name, birthday, commands);
    }
}
