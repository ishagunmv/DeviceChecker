package mysql;

import java.sql.*;
import java.util.ArrayList;

import static mysql.MySqlConnectData.*;

public class UsersTableDB {
    
    public static ArrayList<UsersTable> select() {
        ArrayList<UsersTable> usersTables = new ArrayList<UsersTable>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
                while(resultSet.next()) {

                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String telegram = resultSet.getString(3);
                    UsersTable usersTable = new UsersTable(id, name, telegram);
                    usersTables.add(usersTable);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return usersTables;
    }

    public static UsersTable selectOne(int id) {
        UsersTable usersTable = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

                String sql = "SELECT * FROM products WHERE id=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()) {

                        int usersId = resultSet.getInt(1);
                        String name = resultSet.getString(2);
                        String telegram = resultSet.getString(3);
                        usersTable = new UsersTable(usersId, name, telegram);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return usersTable;
    }

    public static int insert(UsersTable usersTable) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
                  
                String sql = "INSERT INTO users (name, telegram) Values (?, ?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setString(1, usersTable.getName());
                    preparedStatement.setString(2, usersTable.getTelegram());

                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
     
    public static int update(UsersTable usersTable) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
                  
                String sql = "UPDATE products SET name = ?, price = ? WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setString(1, usersTable.getName());
                    preparedStatement.setString(2, usersTable.getTelegram());
                    preparedStatement.setInt(3, usersTable.getId());
                      
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }

    public static int delete(int id) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)){
                  
                String sql = "DELETE FROM users WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                      
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
}