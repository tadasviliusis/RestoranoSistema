package model.modules;

public class Services {
    private int ID;
    private String name;
    private String description;
    private double cost;

    public Services(int ID, String name, String description, double cost) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.cost = cost;
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

    public String description() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double cost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
