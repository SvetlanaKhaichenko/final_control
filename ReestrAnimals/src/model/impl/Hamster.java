package model.impl;


import java.util.Date;

public class Hamster extends Pets{
    public static final int TYPE_ID = 3;
    public Hamster(int id, String name, Date birthday, String commands) {
        super(id, name, birthday, commands, TYPE_ID);
    }
}
