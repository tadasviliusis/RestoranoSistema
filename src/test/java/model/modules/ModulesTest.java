package model.modules;

import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModulesTest {

    @Test
    public void RestaurantTest(){
        Restaurant restaurant = new Restaurant(0, "ADDRESS", "12345678");

        assertEquals(restaurant.ID(), 0);
        assertEquals(restaurant.address(), "ADDRESS");
        assertEquals(restaurant.number(), "12345678");

        restaurant.setID(9);
        restaurant.setAddress("2_ADDRESS");
        restaurant.setNumber("87654321");

        assertEquals(restaurant.ID(), 9);
        assertEquals(restaurant.address(), "2_ADDRESS");
        assertEquals(restaurant.number(), "87654321");
    }

    @Test
    public void CouponTest(){
        Date date = new Date();
        Coupon coupon = new Coupon(0, "DISH#1", 10, date, "AVAILABLE");

        assertEquals(coupon.ID(), 0);
        assertEquals(coupon.name(), "DISH#1");
        assertEquals(coupon.discount(), 10);
        assertEquals(coupon.date(), date);
        assertEquals(coupon.state(), "AVAILABLE");

        Date date1 = new Date();

        coupon.setID(9);
        coupon.setName("DRINK#9");
        coupon.setDiscount(99);
        coupon.setDate(date1);
        coupon.setState("USED");

        assertEquals(coupon.ID(), 9);
        assertEquals(coupon.name(), "DRINK#9");
        assertEquals(coupon.discount(), 99);
        assertEquals(coupon.date(), date1);
        assertEquals(coupon.state(), "USED");
    }

    @Test
    public void FoodOrderTest() {
        FoodOrder foodOrder = new FoodOrder(0, "FOOD#1", 1, 10.99);

        assertEquals(foodOrder.foodID(), 0);
        assertEquals(foodOrder.foodname(), "FOOD#1");
        assertEquals(foodOrder.amount(), 1);
        assertEquals(foodOrder.cost(), 10.99);

        foodOrder.setFoodID(9);
        foodOrder.setfoodname("FOOD#99");
        foodOrder.setAmount(99);
        foodOrder.setCost(99.01);

        assertEquals(foodOrder.foodID(), 9);
        assertEquals(foodOrder.foodname(), "FOOD#99");
        assertEquals(foodOrder.amount(), 99);
        assertEquals(foodOrder.cost(), 99.01);
    }

    @Test
    public void MenuTest() {
        Menu menu = new Menu(0, "DISH#1", 10.99, "FRESH_FOOD", "LUNCH");

        assertEquals(menu.ID(), 0);
        assertEquals(menu.name(), "DISH#1");
        assertEquals(menu.cost(), 10.99);
        assertEquals(menu.description(), "FRESH_FOOD");
        assertEquals(menu.category(), "LUNCH");

        menu.setID(9);
        menu.setName("DRINK#99");
        menu.setCost(99.01);
        menu.setDescription("COLD_DRINK");
        menu.setCategory("DESSERT");

        assertEquals(menu.ID(), 9);
        assertEquals(menu.name(), "DRINK#99");
        assertEquals(menu.cost(), 99.01);
        assertEquals(menu.description(), "COLD_DRINK");
        assertEquals(menu.category(), "DESSERT");
    }

    @Test
    public void ServicesTest() {
        Services services = new Services(0, "PARTY", "BIRTHDAY_PARTY", 99.99);

        assertEquals(services.ID(), 0);
        assertEquals(services.name(), "PARTY");
        assertEquals(services.description(), "BIRTHDAY_PARTY");
        assertEquals(services.cost(), 99.99);

        services.setID(9);
        services.setName("DINNER");
        services.setDescription("DINNER_FOR_TWO");
        services.setCost(19.01);

        assertEquals(services.ID(), 9);
        assertEquals(services.name(), "DINNER");
        assertEquals(services.description(), "DINNER_FOR_TWO");
        assertEquals(services.cost(), 19.01);
    }

    @Test
    public void ClientOrderTest() {
        LocalDate localdate = Instant.ofEpochMilli(new Date().getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        LocalTime time = LocalTime.now();

        ClientOrder clientOrder = new ClientOrder(0, localdate, time, "PROCESSING", 0, 0, 0, 0, 0);

        assertEquals(clientOrder.ID(), 0);
        assertEquals(clientOrder.date(), localdate);
        assertEquals(clientOrder.time(), time);
        assertEquals(clientOrder.state(), "PROCESSING");
        assertEquals(clientOrder.deliveryID(), 0);
        assertEquals(clientOrder.couponID(), 0);
        assertEquals(clientOrder.reservationID(), 0);
        assertEquals(clientOrder.serviceID(), 0);
        assertEquals(clientOrder.clientID(), 0);

        LocalDate localdate1 = Instant.ofEpochMilli(new Date().getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        LocalTime time1 = LocalTime.now();

        clientOrder.setID(9);
        clientOrder.setDate(localdate1);
        clientOrder.setTime(time1);
        clientOrder.setState("DONE");
        clientOrder.setDeliveryID(9);
        clientOrder.setCouponID(9);
        clientOrder.setReservationID(9);
        clientOrder.setServiceID(9);
        clientOrder.setClientID(9);

        assertEquals(clientOrder.ID(), 9);
        assertEquals(clientOrder.date(), localdate1);
        assertEquals(clientOrder.time(), time1);
        assertEquals(clientOrder.state(), "DONE");
        assertEquals(clientOrder.deliveryID(), 9);
        assertEquals(clientOrder.couponID(), 9);
        assertEquals(clientOrder.reservationID(), 9);
        assertEquals(clientOrder.serviceID(), 9);
        assertEquals(clientOrder.clientID(), 9);
    }
}
