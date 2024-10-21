package model;

import java.time.LocalDate;
import java.util.Date;

public abstract class Animal {

    private static int count = 0;
    protected String name;
    protected Date birthday;
    protected String commands;

    public Animal(String name, Date birthday, String commands) {
        this.name = name;
        this.birthday = birthday;
        this.commands = commands;
        count ++;
    }

    public int getCount() {
        return count;
    }

    public String getType(){
        return getClass().getSimpleName();
    }
}
