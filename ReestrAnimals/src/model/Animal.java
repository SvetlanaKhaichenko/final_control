package model;

import java.time.LocalDate;

public abstract class Animals {

    private static int count = 0;
    protected String name;
    protected LocalDate birthday;
    protected String commands;

    public Animals(String name, LocalDate birthday, String commands) {
        this.name = name;
        this.birthday = birthday;
        this.commands = commands;
        count ++;
    }

    public static int getCount() {
        return count;
    }

    public static String getType(){
        return getClass().getSimpleName();
    }
}
