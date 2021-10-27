package home.oberon1989.data;

import home.oberon1989.entityMappers.EntityMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcManager {

    public static Connection getConnection() {
        Connection connection;
        String url = "jdbc:postgresql://localhost:5432/advertBase";
        String user = "advertAdmin";
        String password = "advert1989";
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            ex.printStackTrace();
            connection = null;
        }
        return connection;
    }

    public static <T> List<T> getEntityFromDb(EntityMapper mapper, String sqlQuery) throws SQLException {
        List<T> entities = new ArrayList<>();

        try (Connection con = getConnection()) {
            Statement statement = con.createStatement();
            ResultSet set = statement.executeQuery(sqlQuery);

            while (set.next()) {
                entities.add((T) mapper.mapField(set));

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return entities;

    }

    public static String getColumnTextValueById(int id, String tableName, String columnName) throws SQLException {
        String result = "";
        try {
            Connection con = getConnection();
            try {
                Statement statement = con.createStatement();
                ResultSet set = statement.executeQuery(String.format("SELECT %s FROM %s WHERE id=%s", columnName, tableName, id));

                while (set.next()) {
                    result = set.getString(columnName);

                }
            } finally {
                con.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return result;

    }
}
