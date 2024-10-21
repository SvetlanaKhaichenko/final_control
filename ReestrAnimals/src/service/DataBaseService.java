package service;
import java.sql.*;

public class DataBaseService {

    private static final String USER = "root";
    private static final String PASSWORD = "vfrfh";
    private static final String URL = "jdbc:mysql://localhost:3306/AllAnimals";
    private static Connection connection;
    private static Statement statement;
    private static ResultSet rs;

    public static void connectionDB(){
            try {
                connection  = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public static void closeConnectionDB(){
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }try {
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } try{
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void showTypesAnimals(){
        String request = "SELECT * FROM typesanimals";
        connectionDB();
        try {
            rs = statement.executeQuery(request);
            while (rs.next()){
                Integer id = rs.getInt(1);
                String name_type = rs.getString(2);
                System.out.printf("id: %s, name_type: %s %n", id, name_type);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnectionDB();}
    }
    public static void showAllAnimals(){
        String request = "select id, name, name_type, birthday, commands from allanimals as an \n" +
                "inner join typesanimals as type on an.type_id=type.id_type";
        connectionDB();
        try {
            rs = statement.executeQuery(request);

            while (rs.next()) {
                Integer id = rs.getInt(1);
                String name = rs.getString(2);
                String name_type = rs.getString(3);
                Date birthday = rs.getDate(4);
                String commands = rs.getString(5);

                System.out.printf("id: %s, name: %s, name_type: %s, birthday: %s, commands: %s; %n", id, name, name_type, birthday, commands);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnectionDB();
        }
    }
    public static void showAnimalsId(int id_animal){
        String request = "select id, name, name_type, birthday, commands from allanimals as an \n" +
                "inner join typesanimals as type on an.type_id=type.id_type where id = " + String.valueOf(id_animal);
        if (id_animal >countAnimals() || id_animal < 1){
            showAllAnimals();
            System.out.println("the animal ID is missing from the registry.");
        }
        connectionDB();
        try {
            rs = statement.executeQuery(request);

            while (rs.next()) {
                Integer id = rs.getInt(1);
                String name = rs.getString(2);
                String name_type = rs.getString(3);
                Date birthday = rs.getDate(4);
                String commands = rs.getString(5);

                System.out.printf("id: %s, name: %s, name_type: %s, birthday: %s, commands: %s; %n", id, name, name_type, birthday, commands);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnectionDB();
        }
    }
    public static String showCommands(int id){
        String request = "select name, commands from allanimals\n" +
                "where id="+String.valueOf(id);
        if (id >countAnimals() || id < 1){
            showAllAnimals();
            System.out.println("the animal ID is missing from the registry.");
        }
        connectionDB();
        String result = "";
        try {
            rs = statement.executeQuery(request);
            while (rs.next()){
                String name = rs.getString(1);
                String commands = rs.getString(2);
//                System.out.printf("name: %s, commands: %s; %n",name, commands);
                result = commands;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnectionDB();
        }
        return result;
    }


    public static void showAnimalsByDateOfBirthday(){
        String request = "select id, name, name_type, birthday, commands, \n" +
                "timestampdiff(year, an.birthday, now()) as age\n" +
                "from allanimals as an\n" +
                "inner join typesanimals as type on an.type_id=type.id_type\n" +
                "order by birthday;";

        connectionDB();
        try {
            rs = statement.executeQuery(request);
            while (rs.next()){
                Integer id = rs.getInt(1);
                String name = rs.getString(2);
                String type_name = rs.getString(3);
                Date birthday = rs.getDate(4);
                String commands = rs.getString(5);
                Integer age = rs.getInt(6);
                System.out.printf("name: %s, type_name: %s, birthday: %s, commands: %s, age: %s years; %n",name, type_name, birthday, commands,age);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnectionDB();
        }
    }
    public static int countAnimals(){
        String request = "select count(id) from allanimals;";
        connectionDB();
        Integer count = 0;
        try {
            rs = statement.executeQuery(request);
            while (rs.next()){
                 count = rs.getInt(1);
//                System.out.printf("Total animals: %s;", count);
                return count;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnectionDB();
        }
        return count;
    }
    public static void addAnimals(String name, int type_id, Date birthday, String commands){
        StringBuilder request = new StringBuilder("insert into Allanimals");
        request.append("(id, name, type_id, birthday, commands)");
        request.append("VALUES (");
        request.append("?, ?, ?, ?, ?");
        request.append(")");

        try {
            connection  = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            PreparedStatement stmt = connection.prepareStatement(String.valueOf(request));
            stmt.setString(1, String.valueOf(countAnimals()+1));
            stmt.setString(2, name);
            stmt.setInt(3, type_id);
            stmt.setDate(4, birthday);
            stmt.setString(5, commands);
            stmt.executeUpdate();
            System.out.println("The animal has been successfully entered into the registry");
            showAnimalsId(countAnimals());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }try {
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    public static void addCommand(int id, String command) {
        String result = showCommands(id)+", "+ command;
        String request = "Update allanimals set commands = ? Where id = ?";

            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement pst = connection.prepareStatement(request);
                pst.setString(1, result);
                pst.setInt(2, id);
                pst.executeUpdate();
                showAnimalsId(id);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
            }

        }
    }


}
