package me.nelson131.store.db;

import java.sql.*;

import static me.nelson131.store.utils.Properties.getCFG;

public class MySQL {

    private static final String url = getCFG("sql-url");
    private static final String user = getCFG("sql-user");
    private static final String password = getCFG("password");

    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    static {
        try {
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();

            statement.execute("CREATE TABLE IF NOT EXISTS users (" +
                    "nametag VARCHAR(30)," +
                    "id LONG," +
                    "slot1 BOOLEAN," +
                    "slot2 BOOLEAN," +
                    "slot3 BOOLEAN," +
                    "slot4 BOOLEAN," +
                    "slot5 BOOLEAN," +
                    "slot6 BOOLEAN," +
                    "slot7 BOOLEAN," +
                    "slot8 BOOLEAN," +
                    "slot9 BOOLEAN," +
                    "slot10 BOOLEAN," +
                    "slot11 BOOLEAN," +
                    "slot12 BOOLEAN);");

            System.out.println("table initialization");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
