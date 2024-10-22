package model.impl;
import java.util.Date;

public class Horse extends PackAnimals{
    public static final int TYPE_ID = 4;

    public Horse(int id, String name, Date birthday, String commands) {
        super(id, name, birthday, commands, TYPE_ID);
    }
}
