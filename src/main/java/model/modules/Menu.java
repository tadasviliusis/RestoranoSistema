package model.modules;

public class Menu {
    private int ID;
    private String name;
    private double cost;
    private String description;
    private String category;

    public Menu(int ID, String name, double cost, String description, String category) {
        this.ID = ID;
        this.name = name;
        this.cost = cost;
        this.description = description;
        this.category = category;
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

    public double cost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String description() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String category() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
