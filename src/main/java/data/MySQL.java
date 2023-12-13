package data;

import java.sql.*;
import java.util.Map;
import java.util.StringJoiner;

public class MySQL {

    static private String url = "jdbc:mysql://localhost:3306/restoranoduombaze";
    static private String user = "root";
    static private String password = "Xddrakerisx156";
    public static ResultSet getData(String query) throws SQLException {
        Connection connection = DriverManager.getConnection(url, user, password);

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        return resultSet;
    }

    public static String insertData(String tableName, Map<String, Object> values) throws SQLException {
        StringJoiner columns = new StringJoiner(", ");
        StringJoiner placeholders = new StringJoiner(", ");

        for (String column : values.keySet()) {
            columns.add(column);
            placeholders.add("?");
        }

        String sql = "INSERT INTO " + tableName + " (" + columns + ") VALUES (" + placeholders + ")";

        Connection connection = DriverManager.getConnection(url, user, password);
        
        connection.setAutoCommit(false);

        PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        int index = 1;
        for (Object value : values.values()) {
            statement.setObject(index++, value);
        }

        statement.executeUpdate();

        ResultSet keys = statement.getGeneratedKeys();
        String newID = "";
        if (keys.next()) {
            newID = keys.getString(1);
        }

        connection.commit();
        statement.close();
        connection.close();
        return newID;
    }

    public static void updateData(String tableName, Map<String, Object> newValues, Map<String, Object> whereValues) throws SQLException {
        StringJoiner setClause = new StringJoiner(", ");

        for (String column : newValues.keySet()) {
            setClause.add(column + " = ?");
        }

        StringJoiner whereClause = new StringJoiner(" AND ");

        for (String column : whereValues.keySet()) {
            whereClause.add(column + " = ?");
        }

        Connection connection = DriverManager.getConnection(url, user, password);
        
        String sql = "UPDATE " + tableName + " SET " + setClause + " WHERE " + whereClause;
        PreparedStatement statement = connection.prepareStatement(sql);

        int index = 1;
        for (Object value : newValues.values()) {
            statement.setObject(index++, value);
        }

        for (Object value : whereValues.values()) {
            statement.setObject(index++, value);
        }

        statement.executeUpdate();
        statement.close();
    }

    public static void deleteData(String query) throws SQLException {
        Connection connection = DriverManager.getConnection(url, user, password);
        
        PreparedStatement statement = connection.prepareStatement(query);

        statement.executeUpdate();

        statement.close();

        connection.close();
    }
}
