package model.impl;

import model.Animal;


import java.util.Date;

public abstract class Pets extends Animal {


    public Pets(int id, String name, Date birthday, String commands, int TYPE_ID) {
        super(id, name, birthday, commands, TYPE_ID);
    }
}

