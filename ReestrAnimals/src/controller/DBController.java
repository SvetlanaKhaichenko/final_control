package controller;

import model.Animal;
import service.DBService;

import java.sql.SQLException;
import java.util.List;

public class DBController {

    private DBService service = new DBService();

    public void getConnectionDB() throws SQLException {
        service.getConnectionDB();
    }

    public void closeConnectionDB() throws SQLException{
        service.closeConnectionDB();
    }
    public  void showTypesAnimals() throws SQLException{
        service.showTypesAnimals();
    }
    public  void addAnimalInDB(Animal animal) throws SQLException{
        service.addAnimalInDB(animal);
    }

    public List<Animal> getAllAnimals() throws SQLException{
        return service.getAllAnimals();
    }
    public void changeCommandsAnAnimals(String commands, Animal animal) throws SQLException{
        service.changeCommandsAnAnimals(commands, animal);
    }

}
