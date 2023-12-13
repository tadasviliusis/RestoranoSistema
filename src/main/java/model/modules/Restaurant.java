package model.modules;

public class Restaurant {
    private int ID;
    private String address;
    private String number;

    public Restaurant(int ID, String address, String number) {
        this.ID = ID;
        this.address = address;
        this.number = number;
    }

    public int ID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String address() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String number() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
