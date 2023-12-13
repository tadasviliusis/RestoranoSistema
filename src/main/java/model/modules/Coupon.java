package model.modules;

import java.util.Date;

public class Coupon {
    private int ID;
    private String name;
    private int discount;
    private Date date;
    private String state;

    public Coupon(int ID, String name, int discount, Date date, String state) {
        this.ID = ID;
        this.name = name;
        this.discount = discount;
        this.date = date;
        this.state = state;
    }

    public int ID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int discount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public Date date() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String state() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
