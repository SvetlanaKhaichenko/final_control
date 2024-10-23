package view;

import controller.AnimalsController;
import controller.DBController;
import model.Animal;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;


public class RunReestrView {

    private AnimalsController controller = new AnimalsController();
    private DBController controllerDB = new DBController();

    Scanner scan = new Scanner(System.in);

    public void start () {

        try {
            getConnectionDB();
            List<Animal> allAnimals = getAllAnimals();
            while (true){
                System.out.println("1 -- Show the entire animal registry");
                System.out.println("2 -- Show the entire animal registry sorted by date of birth");
                System.out.println("3 -- Create a new animal and add it to the registry");
                System.out.println("4 -- Show all types of animals");
                System.out.println("5 -- Select an animal and add a new command to it");
                System.out.println("6 -- Choose an animal and show the commands that it knows how to do");
                System.out.println("7 -- Show how many animals there are in the database");
                System.out.println("8 -- Exit");
                switch (scan.nextInt()){
                    case 1 -> System.out.println(allAnimals);
                    case 2 -> sortAnimalsBirthday();
                    case 3 -> { showTypesAnimals();
                        addAnimalInDB();}
                    case 4 -> showTypesAnimals();
                    case 5 -> changeCommandsAnAnimals();
                    case 6 -> getCommandAnimal();
                    case 7 -> System.out.println(totalAnimalsDB());
                    case 8 -> {
                        closeConnectionDB();
                        System.exit(0);
                    }
                    default -> {
                        closeConnectionDB();
                        System.out.println("The operation is not supported");
                    }
                }
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private void getConnectionDB() throws SQLException {
        controllerDB.getConnectionDB();
    }
    private void closeConnectionDB() throws SQLException{
        controllerDB.closeConnectionDB();
    }
    private void showTypesAnimals() throws SQLException{
        controllerDB.showTypesAnimals();
    }

    private List<Animal> getAllAnimals() throws SQLException{
        return controllerDB.getAllAnimals();
    }
    private Animal getAnimal() throws SQLException{
        System.out.println("Enter the ID: ");
        int id = scan.nextInt();
        if (id <0|| id>totalAnimalsDB()){
            throw new RuntimeException("the ID is missing from the database");
        }
        Animal an = controllerDB.getAnimal(id);
        System.out.println(an);
        return an;
    }
    private void addAnimalInDB() throws SQLException {
        controllerDB.addAnimalInDB(getAnimalType());
    }
    private void changeCommandsAnAnimals() throws SQLException {
        System.out.println(getAllAnimals());
        System.out.println();
        Animal animal = getAnimal();
        System.out.println();
        System.out.println("Enter one command to add: ");
        String command = scan.next();
        String newCommands = controller.getCommandAnimal(animal)+", " + command;
        controllerDB.changeCommandsAnAnimals(newCommands, animal);
        System.out.println("New commands: " + newCommands);
    }



    private Animal getAnimalType() throws SQLException {

        int id = totalAnimalsDB()+1;
        System.out.println("Enter the animal type ID according to the table: ");
        int idType = 0;

        idType = scan.nextInt();
        System.out.println("Enter a name: ");

        String name = scan.next();
        System.out.println("Enter the date of birth in the format yyyy-mm-dd: ");
        String date = scan.next();

        Date birth = null;
        if  (isDateValid(date)){
        birth = Date.valueOf(date);}
        else {throw new RuntimeException("Incorrect date");}
        scan.nextLine();
        System.out.println("Enter the commands separated by a space: ");
        String commands = scan.nextLine();
        if (!isValidString(commands)){
            throw new RuntimeException("The field cannot be empty");
        }

        String repcommands = commands.replace(" ", ", ");
        Animal animal = controller.getAnimalType(id, name, birth, repcommands, idType);
        System.out.println();
        System.out.println(animal);
        return animal;
    }
    private String getCommandAnimal() throws SQLException {
        Animal animal = getAnimal();
        String commands = controller.getCommandAnimal(animal);
        System.out.println(commands);
        return commands;
    }

//    private  int totalAnimals(){
//        int count = controller.totalAnimals();
//        return count;
//    }

    private List<Animal> sortAnimalsBirthday() throws SQLException {
        List <Animal> an = getAllAnimals();
        controller.sortAnimalsBirthday(an);
        System.out.println(an);
        return an;
    }
    private int totalAnimalsDB() throws SQLException {
        return controllerDB.totalAnimals();
    }

    private boolean isDateValid(String date)
    {
        boolean isValidFormat = date.matches("([0-9]{4})-([0-9]{2})-([0-9]{2})");
        return isValidFormat;
    }

    private boolean isValidString (String check){
       return  check != null && !check.isEmpty();
    }

}
