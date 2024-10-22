package service;
import model.Animal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBService {


    private static final String USER = "root";
    private static final String PASSWORD = "vfrfh";
    private static final String URL = "jdbc:mysql://localhost:3306/AllAnimals";
    public static Connection conn;
    private static Statement stmt;
    private static ResultSet rs;
    private static PreparedStatement statement;
    private AnimalService service = new AnimalService();

    public void getConnectionDB() throws SQLException {
        conn = DriverManager.getConnection(URL, USER, PASSWORD);
    }
    public void closeConnectionDB() throws SQLException {
        if (conn != null){
            conn.close();
        }
    }
    public  void showTypesAnimals() throws SQLException {
        String request = "SELECT * FROM typesanimals";
        stmt=conn.createStatement();
        rs=stmt.executeQuery(request);
        while (rs.next()){
            Integer id = rs.getInt(1);
            String name_type = rs.getString(2);
            System.out.printf("id: %s, name_type: %s %n", id, name_type);
        }

    }
    public  void addAnimalInDB(Animal animal) throws SQLException {
        String request = "INSERT INTO Allanimals (id, name, type_id, birthday, commands) VALUES (?, ?, ?, ?, ?)";
         statement = conn.prepareStatement(request);
         statement.setInt(1, service.totalAnimals());
         statement.setString(2, animal.name);
         statement.setInt(3, animal.TYPE_ID);
         statement.setDate(4, (Date) animal.birthday);
         statement.setString(5, animal.getCommands());

         int count = statement.executeUpdate();
         if (count>0){
             System.out.println("the animal is included in the register");
         }
    }
    public List<Animal> getAllAnimals() throws SQLException {
        String request = "SELECT * FROM Allanimals";
        stmt = conn.createStatement();
        rs = stmt.executeQuery(request);

        ArrayList<Animal> an =new ArrayList<Animal>();
        while (rs.next()){
            Animal animal = service.getAnimalType(rs.getInt(1), rs.getString(2), rs.getDate(4), rs.getString(5), rs.getInt(3));
            an.add(animal);
        }
        return an;
    }
    public void changeCommandsAnAnimals(String commands, Animal animal) throws SQLException {
        String request = "Update allanimals set commands = ? Where id = ?";
        statement = conn.prepareStatement(request);
        statement.setString(1, commands);
        statement.setInt(2, animal.id);
        int count = statement.executeUpdate();
         if (count > 0){
             System.out.println("the animal's commands have been updated");
         }

    }

}
