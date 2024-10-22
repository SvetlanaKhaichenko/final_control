package service;
import model.Animal;
import model.impl.*;
import java.sql.Date;
import java.util.Collections;
import java.util.List;


public class AnimalService {

    public  Animal getAnimalType(int id, String name, Date birthday, String commands, int id_type) {
        switch (id_type) {
            case Cat.TYPE_ID:
                return new Cat(id, name, birthday, commands);
            case Camal.TYPE_ID:
                return new Camal(id, name, birthday, commands);
            case Dog.TYPE_ID:
                return new Dog(id, name, birthday, commands);
            case Donkey.TYPE_ID:
                return new Donkey(id, name, birthday, commands);
            case Hamster.TYPE_ID:
                return new Hamster(id, name, birthday, commands);
            case Horse.TYPE_ID:
                return new Horse(id, name, birthday, commands);
            default:
                throw new RuntimeException("the animal type ID is incorrect");
        }

    }

    public  String getCommandAnimal(Animal animal){
        return animal.getCommands();
    }

    public  void addCommandsToAnAnimal(Animal animal, String command){
        String oldCommand = getCommandAnimal(animal);
        String newCommand = oldCommand+ ", " +command;
        animal.setCommands(newCommand);
    }

    public  int totalAnimals(){
      return  Animal.getCount();
    }

    public  List<Animal> sortAnimalsBirthday(List<Animal> animals){
         Collections.sort(animals);
         return animals;
    }



}