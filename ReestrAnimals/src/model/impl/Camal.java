package model.impl;


import java.util.Date;

public class Camal extends PackAnimals{

    public static final int TYPE_ID = 5;


    public Camal(int id, String name, Date birthday, String commands) {
        super(id, name, birthday, commands, TYPE_ID);

    }
}
