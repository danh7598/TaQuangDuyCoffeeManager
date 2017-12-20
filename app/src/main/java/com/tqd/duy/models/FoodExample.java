package com.tqd.duy.models;

import java.util.ArrayList;

/**
 * Created by Danh on 12/18/2017.
 */

public class FoodExample {
    private ArrayList<Food> listFood;

    public FoodExample(ArrayList<Food> listFood) {
        this.listFood = listFood;
    }
    public void SetFoodExample(){
        listFood.add(new Food("Cà phê đen",10000.0));
        listFood.add(new Food("Cà phê sữa",12000.0));
        listFood.add(new Food("Cà phê đen Sài Gòn",15000.0));
        listFood.add(new Food("Cà phê sữa Sài Gòn",17000.0));
        listFood.add(new Food("Nước cam",15000.0));
        listFood.add(new Food("Nước chanh",12000.0));
        listFood.add(new Food("Pepsi",8000.0));
        listFood.add(new Food("Sting vàng",9000.0));
        listFood.add(new Food("Sting dâu",90000.0));
        listFood.add(new Food("Nước suối Aquafina",5000.0));
    }
}
