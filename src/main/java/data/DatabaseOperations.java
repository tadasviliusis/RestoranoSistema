package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class DatabaseOperations {

    public static ResultSet getLogInCredentials() throws SQLException {
        ResultSet resultSet = MySQL.getData("SELECT * FROM programelesklientai");
        return resultSet;
    }

    public static ResultSet getAppVersion() throws SQLException {
        return MySQL.getData("SELECT MAX(ProgramelesID) FROM programele");
    }
    
    public static ResultSet getAllLoginNames() throws SQLException {
        return MySQL.getData("SELECT all(PrisijungimoVardas) FROM programelesklientai");
    }

    public static String createLoginCredentials(Map<String, Object> values) throws SQLException {
        String newID = MySQL.insertData("klientai", values);
        return newID;
    }

    public static void createProfile(Map<String, Object> values) throws SQLException {
        MySQL.insertData("programelesklientai", values);
    }

    public static void updateUserInfo(Map<String, Object> newValues, Map<String, Object> whereValues) throws SQLException {
        MySQL.updateData("klientai", newValues, whereValues);
    }

    public static void updateLoginInfo(Map<String, Object> newValues, Map<String, Object> whereValues) throws SQLException {
        MySQL.updateData("programelesklientai", newValues, whereValues);
    }

    public static ResultSet getUserInfo(String login, String password) throws SQLException {
        ResultSet resultSet = MySQL.getData("SELECT\n" +
                "klientai.* " +
                "FROM programelesklientai " +
                "INNER JOIN klientai " +
                "ON programelesklientai.KlientoID = klientai.KlientoID " +
                "WHERE programelesklientai.PrisijungimoVardas = '" + login + "' " +
                "AND programelesklientai.Slaptazodis = '" + password + "' " +
                "AND programelesklientai.KlientoID = klientai.KlientoID");
        return resultSet;
    }
    
    public static ResultSet getLoginInfo(String id) throws SQLException {
        ResultSet resultSet = MySQL.getData("SELECT * FROM programelesklientai WHERE KlientoID = " + id);
        return resultSet;
    }

    public static ResultSet getRestaurantList() throws SQLException {
        ResultSet resultSet = MySQL.getData("SELECT * FROM restoranotinklas");
        return resultSet;
    }

    public static ResultSet getRestaurantMenu(int restaurantID) throws SQLException {
        ResultSet resultSet = MySQL.getData(
        "SELECT " +
                "meniu.PatiekaloID, " +
                "meniu.Pavadinimas, " +
                "meniu.Kaina, " +
                "meniu.Aprasymas, " +
                "maistokategorijos.Pavadinimas " +
                "FROM meniu " +
                "LEFT JOIN maistokategorijos " +
                "ON meniu.KategorijosID = maistokategorijos.KategorijosID " +
                "WHERE meniu.RestoranoID = " + restaurantID + "");
        return resultSet;
    }

    public static ResultSet getCoupons(int ID) throws SQLException {
        ResultSet resultSet = MySQL.getData(
                "SELECT " +
                        "nuolaidukuponai.KuponoID, " +
                        "nuolaidukuponai.Pavadinimas, " +
                        "nuolaidukuponai.Nuolaida, " +
                        "nuolaidukuponai.GaliojimoLaikotarpis, " +
                        "klientokuponai.Busena " +
                        "FROM nuolaidukuponai " +
                        "INNER JOIN klientokuponai " +
                        "ON nuolaidukuponai.KuponoID = klientokuponai.KuponoID " +
                        "WHERE klientokuponai.KlientoID = '" + ID + "'");
        return resultSet;
    }

    public static void useCoupon(int couponID, int clientID) throws SQLException {
    MySQL.deleteData("DELETE FROM klientokuponai WHERE KuponoID = '" + couponID + "' AND KlientoID = '" + clientID + "'");
    }

    public static String newDeliveryToHome(Map<String, Object> values) throws SQLException {
        String newID = MySQL.insertData("pristatymasinamus", values);
        return newID;
    }

    public static void newFoodOrder(Map<String, Object> values) throws SQLException {
        String newID = MySQL.insertData("maistouzsakymas", values);
    }

    public static String newReservation(Map<String, Object> values) throws SQLException {
        String newID = MySQL.insertData("rezervacijos", values);
        return newID;
    }

    public static ResultSet getServices() throws SQLException {
        ResultSet resultSet = MySQL.getData("SELECT * FROM restoranopaslaugos");
        return resultSet;
    }

    public static String newServiceOrder(Map<String, Object> values) throws SQLException {
        String newID = MySQL.insertData("paslaugosuzsakymas", values);
        return newID;


    }
    public static String newOrder_Food(Map<String, Object> values) throws SQLException {
        String newID = MySQL.insertData("klientouzsakymas", values);
        return newID;

    }

    public static String newOrder_Reservation(Map<String, Object> values) throws SQLException {
        String newID = MySQL.insertData("klientouzsakymas", values);
        return newID;
    }

    public static String newOrder_Service(Map<String, Object> values) throws SQLException {
        String newID = MySQL.insertData("klientouzsakymas", values);
        return newID;

    }


    public static ResultSet getOrders(String id) throws SQLException {
        ResultSet resultSet = MySQL.getData("SELECT * FROM klientouzsakymas WHERE KlientoID = " + id);
        return resultSet;
    }

    public static void cancelOrder(Map<String, Object> newValues, Map<String, Object> whereValues) throws SQLException {
        MySQL.updateData("klientouzsakymas", newValues, whereValues);
    }

    public static ResultSet getReservation(int ID) throws SQLException {
        ResultSet resultSet = MySQL.getData("SELECT * FROM rezervacijos WHERE RezervacijosID = '" + ID + "'");
        return resultSet;
    }

    public static ResultSet getService(int serviceID) throws SQLException {
        ResultSet resultSet = MySQL.getData(
                "SELECT " +
                        "restoranopaslaugos.Pavadinimas " +
                        "FROM paslaugosuzsakymas " +
                        "INNER JOIN restoranopaslaugos " +
                        "ON paslaugosuzsakymas.PaslaugosID = restoranopaslaugos.PaslaugosID " +
                        "WHERE paslaugosuzsakymas.UzsakymoID = '" + serviceID + "' " +
                        "AND restoranopaslaugos.PaslaugosID = paslaugosuzsakymas.PaslaugosID"

        );
        return resultSet;
    }

    public static ResultSet getFoodOrder(int orderID) throws SQLException {
        ResultSet resultSet = MySQL.getData(
                "SELECT " +
                        "maistouzsakymas.*, " +
                        "meniu.Pavadinimas " +
                        "FROM maistouzsakymas " +
                        "LEFT JOIN meniu " +
                        "ON meniu.PatiekaloID = maistouzsakymas.PatiekaloID " +
                        "WHERE maistouzsakymas.KlientoUzsakymoID = '" + orderID + "'");
        return resultSet;
    }
}
