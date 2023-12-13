package model.services;

import data.DatabaseOperations;
import model.modules.ClientOrder;
import model.modules.FoodOrder;
import model.modules.Menu;
import model.modules.Restaurant;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FoodOrderServices {
    public static List<Restaurant> getRestaurantList() throws SQLException {
        ResultSet resultSet = DatabaseOperations.getRestaurantList();

        List<Restaurant> restaurants = new ArrayList<>();
        while (resultSet.next()){
            restaurants.add(new Restaurant(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)));
        }
        return restaurants;
    }

    public static List<Menu> getRestaurantMenu(int restaurantID) throws SQLException {
        List<Menu> menu = new ArrayList<>();
        ResultSet resultSet = DatabaseOperations.getRestaurantMenu(restaurantID);

        while (resultSet.next())
        {
            menu.add(
                    new Menu(resultSet.getInt(1), resultSet.getString(2),
                            resultSet.getDouble(3), resultSet.getString(4),
                            resultSet.getString(5))
            );
        }
        return menu;
    }


    public static void newFoodOrder(List<FoodOrder> totalOrder, int orderID) throws SQLException {
        Map<String, Object> values = new HashMap<>();

        for(FoodOrder order : totalOrder)
        {
            values.put("Kiekis", order.amount());
            values.put("Kaina", order.cost());
            values.put("PatiekaloID", order.foodID());
            values.put("KlientoUzsakymoID", orderID);
            DatabaseOperations.newFoodOrder(values);
            values.clear();
        }
    }

    public static String newOrder_Food(List<FoodOrder> totalOrder, LocalDate date, LocalTime time, String state, int deliveryID,
                                       int couponID, boolean useCoupon, int clientID, boolean isDelivery) throws SQLException {
        Map<String, Object> values = new HashMap<>();
        values.put("Data", date);
        values.put("Laikas", time);
        values.put("Busena", state);
        if(isDelivery)
            values.put("PristatymoID", deliveryID);
        if(useCoupon)
            values.put("KlientoKuponoID", couponID);
        values.put("KlientoID", clientID);
        String newID = DatabaseOperations.newOrder_Food(values);
        newFoodOrder(totalOrder, Integer.parseInt(newID));
        return newID;

    }



    public static List<ClientOrder> getOrders(int id) throws SQLException {
        List<ClientOrder> orders = new ArrayList<>();
        ResultSet resultSet = DatabaseOperations.getOrders(Integer.toString(id));

        while (resultSet.next())
        {
            LocalDate localdate = Instant.ofEpochMilli(resultSet.getDate(2).getTime())
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
            orders.add(
                    new ClientOrder(resultSet.getInt(1), localdate,
                            resultSet.getTime(3).toLocalTime(), resultSet.getString(4),
                            resultSet.getInt(5), resultSet.getInt(6), resultSet.getInt(7),
                            resultSet.getInt(8), resultSet.getInt(9)
                    )
            );
        }
        return orders;
    }

    public static void cancelOrder(int ID) throws SQLException {
        Map<String, Object> newValues = new HashMap<>();
        newValues.put("Busena", "Atsauktas");

        Map<String, Object> whereValues = new HashMap<>();
        whereValues.put("UzsakymoID",ID);
        DatabaseOperations.cancelOrder(newValues, whereValues);
    }






    public static List<FoodOrder> getFoodOrder(int orderID) throws SQLException {
        List<FoodOrder> orders = new ArrayList<>();
        ResultSet resultSet = DatabaseOperations.getFoodOrder(orderID);
        while (resultSet.next())
        {
            orders.add(
                    new FoodOrder(resultSet.getInt(1),resultSet.getString("meniu.Pavadinimas"), resultSet.getInt(2), resultSet.getDouble(3))
            );
        }
        return orders;
    }
}
