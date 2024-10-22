package model.impl;


import java.util.Date;

public class Cat extends Pets{
    public static final int TYPE_ID = 1;
    public Cat(int id, String name, Date birthday, String commands) {
        super(id, name, birthday, commands, TYPE_ID);
    }
}
