package br.com.renan.main.infra;
import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;

public class Database {
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }


    public Database() {
        Dotenv env = Dotenv.load();

        String url = env.get("DATABASE_URL");
        String user = env.get("DATABASE_USERNAME");
        String pass = env.get("DATABASE_PASSWORD");

        try {
            connection = DriverManager.getConnection(url, user, pass);
            System.out.println("Connection to the database successfully");
        } catch (SQLException e) {
            System.err.println("Failed to connect to the database: " + e.getMessage());
        }
    }
}
