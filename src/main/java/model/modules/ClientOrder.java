package model.modules;

import java.time.LocalDate;
import java.time.LocalTime;

public class ClientOrder {
    private int ID;
    private LocalDate date;
    private LocalTime time;
    private String state;
    private int deliveryID;
    private int couponID;
    private int reservationID;
    private int serviceID;
    private int clientID;

    public ClientOrder(int ID, LocalDate date, LocalTime time, String state, int deliveryID, int couponID, int reservationID, int serviceID, int clientID) {
        this.ID = ID;
        this.date = date;
        this.time = time;
        this.state = state;
        this.deliveryID = deliveryID;
        this.couponID = couponID;
        this.reservationID = reservationID;
        this.serviceID = serviceID;
        this.clientID = clientID;
    }

    public int ID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public LocalDate date() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime time() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String state() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int deliveryID() {
        return deliveryID;
    }

    public void setDeliveryID(int deliveryID) {
        this.deliveryID = deliveryID;
    }

    public int couponID() {
        return couponID;
    }

    public void setCouponID(int couponID) {
        this.couponID = couponID;
    }

    public int reservationID() {
        return reservationID;
    }

    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }

    public int serviceID() {
        return serviceID;
    }

    public void setServiceID(int serviceID) {
        this.serviceID = serviceID;
    }

    public int clientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }
}
