package model.impl;

import model.Animal;

import java.util.Date;

public abstract class PackAnimals extends Animal {

    public PackAnimals(String name, Date birthday, String commands) {
        super(name, birthday, commands);
    }
}
