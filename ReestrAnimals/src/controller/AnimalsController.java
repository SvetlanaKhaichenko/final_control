package controller;
import model.Animal;
import service.AnimalService;
import java.sql.Date;
import java.util.List;

public class AnimalsController {

    private static AnimalService service = new AnimalService();



    public Animal getAnimalType(int id, String name, Date birthday, String commands, int id_type){
        return service.getAnimalType(id, name, birthday,commands,id_type);
    }

    public  String getCommandAnimal(Animal animal){
        return service.getCommandAnimal(animal);
    }

//    public  void addCommandsToAnAnimal(Animal animal, String command){
//        service.addCommandsToAnAnimal(animal, command);
//    }

    public  int totalAnimals(){
        return service.totalAnimals();
    }

    public List<Animal> sortAnimalsBirthday(List<Animal> animals){
        return service.sortAnimalsBirthday(animals);
    }

}
