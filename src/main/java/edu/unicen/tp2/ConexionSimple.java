package edu.unicen.tp2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConexionSimple {
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/turni?schema=turni";
        String user = "postgres";
        String password = "1234";

        try {

            Class.forName("org.postgresql.Driver");

            Connection connection = DriverManager.getConnection(url, user, password);

            System.out.println("Conexión establecida exitosamente");

            Statement statement = connection.createStatement();

            String query = "SELECT * FROM turni.person";

            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String id = resultSet.getString("phone");
                String nombre = resultSet.getString("name");
                System.out.println("ID: " + id + ", Nombre: " + nombre);
            }

            connection.close();


        } catch (Exception e) {
            System.out.println(e);
        }

    }

}

