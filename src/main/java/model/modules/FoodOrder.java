package model.modules;

public class FoodOrder {
    private int foodID;
    private int amount;
    private double cost;
    private String foodname;

    public FoodOrder(int foodID,String foodname, int amount, double cost) {
        this.foodID = foodID;
        this.amount = amount;
        this.cost = cost;
        this.foodname = foodname;
    }

    public int foodID() {
        return foodID;
    }

    public void setFoodID(int foodID) {
        this.foodID = foodID;
    }
    
     public String foodname() {
        return foodname;
    }

    public void setfoodname(String foodname) {
        this.foodname = foodname;
    }


    public int amount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double cost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
