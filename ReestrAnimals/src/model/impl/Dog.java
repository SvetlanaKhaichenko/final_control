package model.impl;


import java.util.Date;

public class Dog extends Pets{
    public static final int TYPE_ID = 2;
    public Dog(int id, String name, Date birthday, String commands) {
        super(id, name, birthday, commands, TYPE_ID);
    }
}
