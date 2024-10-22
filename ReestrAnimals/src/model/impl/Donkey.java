package model.impl;


import java.util.Date;

public class Donkey extends PackAnimals{
    public static final int TYPE_ID = 6;
    public Donkey(int id, String name, Date birthday, String commands) {
        super(id, name, birthday, commands, TYPE_ID);
    }
}
