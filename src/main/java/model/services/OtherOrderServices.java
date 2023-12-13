package model.services;

import data.DatabaseOperations;
import model.modules.Coupon;
import model.modules.FoodOrder;
import model.modules.Services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OtherOrderServices {

    public static List<Coupon> getCoupons(int ID) throws SQLException {
        List<Coupon> coupons = new ArrayList<>();
        ResultSet resultSet = DatabaseOperations.getCoupons(ID);

        while (resultSet.next())
        {
            coupons.add(
                    new Coupon(resultSet.getInt(1), resultSet.getString(2),
                            resultSet.getInt(3), resultSet.getDate(4),
                            resultSet.getString(5))
            );
        }
        return coupons;
    }

    public static void useCoupon(int couponID, int clientID) throws SQLException {
        DatabaseOperations.useCoupon(couponID, clientID);
    }

    public static int newDeliveryToHome(String address, double cost, LocalTime time, LocalDate date, String number) throws SQLException {
        Map<String, Object> values = new HashMap<>();
        values.put("Adresas", address);
        values.put("Kaina", cost);
        values.put("Laikas", time);
        values.put("Data", date);
        values.put("TlNumeris", number);
        String newID = DatabaseOperations.newDeliveryToHome(values);
        return Integer.parseInt(newID);
    }

    public static int newReservation(LocalTime time, LocalDate date, String spot, int restaurantID, int clientID) throws SQLException {
        Map<String, Object> values = new HashMap<>();
        values.put("Laikas", time);
        values.put("Data", date);
        values.put("Vieta", spot);
        values.put("RestoranoID", restaurantID);
        values.put("KlientoID", clientID);
        String newID = DatabaseOperations.newReservation(values);
        return Integer.parseInt(newID);
    }



    public static List<Services> getServices() throws SQLException {
        List<Services> services = new ArrayList<>();
        ResultSet resultSet = DatabaseOperations.getServices();

        while (resultSet.next())
        {
            services.add(
                    new Services(resultSet.getInt(1), resultSet.getString(2),
                            resultSet.getString(3), resultSet.getDouble(4))
            );
        }
        return services;
    }

    public static int newServiceOrder(double cost, LocalDate date, LocalTime time, int restaurantID, int serviceID) throws SQLException {
        Map<String, Object> values = new HashMap<>();
        values.put("Kaina", cost);
        values.put("Data", date);
        values.put("Laikas", time);
        values.put("RestoranoID", restaurantID);
        values.put("PaslaugosID", serviceID);
        String newID = DatabaseOperations.newServiceOrder(values);
        return Integer.parseInt(newID);
    }



    public static String newOrder_Reservation(List<FoodOrder> totalOrder, LocalDate date, LocalTime time, String state,
                                              int couponID, int reservationID, int clientID,
                                              boolean orderFood, boolean useCoupon) throws SQLException {
        Map<String, Object> values = new HashMap<>();
        values.put("Data", date);
        values.put("Laikas", time);
        values.put("Busena", state);
        if(useCoupon)
            values.put("KlientoKuponoID", couponID);
        values.put("RezervacijosID", reservationID);
        values.put("KlientoID", clientID);
        String newID = DatabaseOperations.newOrder_Reservation(values);

        if(orderFood)
            FoodOrderServices.newFoodOrder(totalOrder, Integer.parseInt(newID));
        return newID;

    }

    public static String newOrder_Service(LocalDate date, LocalTime time, String state,
                                          int couponID, int serviceID, int clientID, boolean useCoupon) throws SQLException {
        Map<String, Object> values = new HashMap<>();
        values.put("Data", date);
        values.put("Laikas", time);
        values.put("Busena", state);
        if(useCoupon)
            values.put("KlientoKuponoID", couponID);
        values.put("PaslaugosID", serviceID);
        values.put("KlientoID", clientID);
        String newID = DatabaseOperations.newOrder_Service(values);

        return newID;

    }



    public static String getReservation(int ID) throws SQLException {
        ResultSet resultSet = DatabaseOperations.getReservation(ID);
        resultSet.next();
        String reservation  = "Uzrezervuota " + resultSet.getString(4) + " vieta, " + resultSet.getTime(2) +
                " laiku, " + resultSet.getDate(3) + " diena.";
        return reservation;
    }

    public static String getService(int serviceID) throws SQLException {
        ResultSet resultSet = DatabaseOperations.getService(serviceID);
        resultSet.next();
        return "Uzsakyta " + resultSet.getString(1) + " paslauga.";
    }
}
