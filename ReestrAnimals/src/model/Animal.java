package model;
import java.util.Date;

public class Animal implements Comparable<Animal>{

    private static int count = 0;
    public int id;
    public String name;
    public Date birthday;
    public String commands;
    public int TYPE_ID;



    public Animal(int id, String name, Date birthday, String commands,int TYPE_ID) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.commands = commands;
        this.TYPE_ID = TYPE_ID;
        count ++;
    }

    public static int getCount() {
        return count;
    }

    public String getType(){
        return getClass().getSimpleName();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": "+
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", commands='" + commands + '\'' +
                "}\n";
    }

    public String getCommands() {
        return commands;
    }

    public void setCommands(String commands) {
        this.commands = commands;
    }

    public Date getBirthday() {
        return birthday;
    }

    @Override
    public int compareTo(Animal o) {
        return getBirthday().compareTo(o.getBirthday());
    }
}
