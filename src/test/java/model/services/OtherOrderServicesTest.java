package model.services;

import model.modules.Coupon;
import model.modules.Services;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class OtherOrderServicesTest {

    @Test
    public void getCouponsTest() throws SQLException {
        List<Coupon> couponList = OtherOrderServices.getCoupons(2);
        for (Coupon coupon : couponList)
        {
            assertTrue(coupon.ID() > 0);
            assertFalse(coupon.name().equals(""));
            assertTrue(coupon.discount() > 0);
        }
    }

    @Test
    public void getServicesTest() throws SQLException {
        List<Services> servicesList = OtherOrderServices.getServices();
        for (Services service : servicesList)
        {
            assertTrue(service.ID() > 0);
            assertFalse(service.name().equals(""));
            assertFalse(service.description().equals(""));
            assertTrue(service.cost() > 0);
        }
    }

    @Test
    public void getReservationTest() throws SQLException {
        String reservation = OtherOrderServices.getReservation(1);
        assertTrue(reservation.equals("Uzrezervuota A3 vieta, 13:00:00 laiku, 2023-05-12 diena."));
    }

    @Test
    public void getServiceTest() throws SQLException {
        String service = OtherOrderServices.getService(1);
        assertTrue(service.equals("Uzsakyta Teminiai vakarai paslauga."));
    }

}