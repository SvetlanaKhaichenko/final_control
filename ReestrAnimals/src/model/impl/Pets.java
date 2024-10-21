package model.impl;

import model.Animal;

import java.time.LocalDate;

public abstract class Pets extends Animal {

    public Pets(String name, LocalDate birthday, String commands) {
        super(name, birthday, commands);
    }
}
