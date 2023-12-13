package model.services;

import data.DatabaseOperations;
import data.MySQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserServices {

    public static boolean checkLogInCredentials(String login, String password) throws SQLException {
        ResultSet resultSet = DatabaseOperations.getLogInCredentials();
        while (resultSet.next()){
            if(resultSet.getString("PrisijungimoVardas").equals(login) &&
                    resultSet.getString("Slaptazodis").equals(password))
                return true;
        }
        return false;
    }
    
    public static List<String> getAllLoginNames() throws SQLException {
        ResultSet resultSet = DatabaseOperations.getAllLoginNames();
        List<String> loginNames = new ArrayList<>();
        while (resultSet.next()){
            loginNames.add(resultSet.getString("PrisijungimoVardas"));
        }
        return loginNames;
    }

    public static void createNewUser(String name, String lastName, String number, String mail, String address, String login, String password) throws SQLException {
        Map<String, Object> values = new HashMap<>();
        values.put("Vardas", name);
        values.put("Pavarde", lastName);
        values.put("TlNumeris", number);
        values.put("ElPastas", mail);
        values.put("Adresas", address);

        String newID = DatabaseOperations.createLoginCredentials(values);

        values.clear();
        ResultSet resultSet = DatabaseOperations.getAppVersion();
        resultSet.next();

        values.put("PrisijungimoVardas", login);
        values.put("Slaptazodis", password);
        values.put("ProgramelesID", resultSet.getInt(1));
        values.put("KlientoID", newID);
        DatabaseOperations.createProfile(values);
    }

    public static void updateUserInfo(Object ID, String name, String lastName, String number, String mail, String address) throws SQLException {
        Map<String, Object> newValues = new HashMap<>();
        newValues.put("Vardas", name);
        newValues.put("Pavarde", lastName);
        newValues.put("TlNumeris", number);
        newValues.put("ElPastas", mail);
        newValues.put("Adresas", address);

        Map<String, Object> whereValues = new HashMap<>();
        whereValues.put("KlientoID",ID);
        DatabaseOperations.updateUserInfo(newValues, whereValues);

    }

    public static void updateLoginInfo(Object ID, String login, String password) throws SQLException {
        Map<String, Object> newValues = new HashMap<>();
        newValues.put("PrisijungimoVardas", login);
        newValues.put("Slaptazodis", password);

        Map<String, Object> whereValues = new HashMap<>();
        whereValues.put("KlientoID",ID);
        DatabaseOperations.updateLoginInfo(newValues, whereValues);
    }

    public static Map<String, Object> getUserInfo(String login, String password) throws SQLException {
        ResultSet resultSet = DatabaseOperations.getUserInfo(login, password);
        resultSet.next();
        Map<String, Object> values = new HashMap<>();
        values.put("ID", resultSet.getInt(1));
        values.put("vardas", resultSet.getString(2));
        values.put("pavarde", resultSet.getString(3));
        values.put("tl.numeris", resultSet.getString(4));
        values.put("el.pastas", resultSet.getString(5));
        values.put("adresas", resultSet.getString(6));
        return values;
    }

    public static Map<String, Object> getLoginInfo(String id) throws SQLException {
        ResultSet resultSet = DatabaseOperations.getLoginInfo(id);
        resultSet.next();
        Map<String, Object> values = new HashMap<>();
        values.put("ID", resultSet.getInt(1));
        values.put("login", resultSet.getString(2));
        values.put("password", resultSet.getString(3));
        return values;
    }


}
