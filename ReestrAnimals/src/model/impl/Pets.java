package model.impl;

import model.Animal;


import java.util.Date;

public abstract class Pets extends Animal {

    public Pets(String name, Date birthday, String commands) {
        super(name, birthday, commands);
    }
}
