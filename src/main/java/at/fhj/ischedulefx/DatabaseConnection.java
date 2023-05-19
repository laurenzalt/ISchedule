package at.fhj.ischedulefx;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public Connection database;

    public Connection getConnection() {
        String databaseName = "ischedule";
        String databaseUser = "root";
        String databasePassword = "root";
        String url = "jdbc:mysql://localhost:3306/" + databaseName;

        try {
            database = DriverManager.getConnection(url, databaseUser, databasePassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return database;
    }
}
