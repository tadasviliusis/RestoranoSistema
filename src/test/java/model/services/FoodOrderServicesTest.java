package model.services;

import data.DatabaseOperations;
import model.modules.ClientOrder;
import model.modules.FoodOrder;
import model.modules.Menu;
import model.modules.Restaurant;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FoodOrderServicesTest {

    @Test
    public void getRestaurantListTest() throws SQLException {
        List<Restaurant> restaurantList = FoodOrderServices.getRestaurantList();
        for(Restaurant restaurant : restaurantList) {
            assertTrue(restaurant.ID() > 0);
            assertFalse(restaurant.address().equals(""));
            assertFalse(restaurant.number().equals(""));
        }
    }

    @Test
    public void getRestaurantMenuTest() throws SQLException {
        List<Menu> menuList = FoodOrderServices.getRestaurantMenu(1);
        for(Menu menu : menuList) {
            assertTrue(menu.ID() > 0);
            assertFalse(menu.name().equals(""));
            assertTrue(menu.cost() > 0);
            assertFalse(menu.description().equals(""));
            assertFalse(menu.category().equals(""));
        }
    }


    @Test
    public void getOrdersTest() throws SQLException {
        //
        List<ClientOrder> clientOrderList = FoodOrderServices.getOrders(10);
        for(ClientOrder clientOrder : clientOrderList) {
            assertTrue(clientOrder.ID() > 0);
            assertFalse(clientOrder.state().equals(""));
        }
    }

    @Test
    public void getFoodOrderTest() throws SQLException {
        //
        List<FoodOrder> foodOrderList = FoodOrderServices.getFoodOrder(1);
        for(FoodOrder foodOrder : foodOrderList) {
            assertTrue(foodOrder.foodID() > 0);
            assertTrue(foodOrder.amount() > 0);
            assertTrue(foodOrder.cost() > 0);
            assertFalse(foodOrder.foodname().equals(""));
        }
    }
}