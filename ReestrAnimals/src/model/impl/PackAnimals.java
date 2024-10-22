package model.impl;

import model.Animal;

import java.util.Date;

public abstract class PackAnimals extends Animal {


    public PackAnimals(int id, String name, Date birthday, String commands, int TYPE_ID) {
        super(id, name, birthday, commands, TYPE_ID);
    }
}

