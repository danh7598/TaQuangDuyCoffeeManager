package com.tqd.duy.models;

import android.app.Activity;
import com.tqd.duy.coffeemanagement.R;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Danh on 12/18/2017.
 */

public class Food implements Serializable {
    private String nameFood;
    private Double priceFood;
    private int numberFood;

    @Override
    public String toString() {
        return "Tên: " + nameFood + "\nSố lượng: " + numberFood +
                "\nTổng tiền: " + (priceFood * numberFood);
    }

    public String getNameFood() {
        return nameFood;
    }

    public void setNameFood(String nameFood) {
        this.nameFood = nameFood;
    }

    public Double getPriceFood() {
        return priceFood;
    }

    public void setPriceFood(Double priceFood) {
        this.priceFood = priceFood;
    }

    public int getNumberFood() {
        return numberFood;
    }

    public void setNumberFood(int numberFood) {
        this.numberFood = numberFood;
    }

    public Food(String nameFood, Double priceFood) {
        this.nameFood = nameFood;
        this.priceFood = priceFood;
        this.numberFood = 0;
    }

    public Food() {
    }

    public ArrayList<Food> getSampleFood(Activity context) {
        ArrayList<Food> listFood = new ArrayList<>();
        listFood.add(new Food(context.getResources().getString(R.string.Black_coffee), 10000.0));
        listFood.add(new Food(context.getResources().getString(R.string.Black_coffee_SG), 12000.0));
        listFood.add(new Food(context.getResources().getString(R.string.Coffee_milk), 15000.0));
        listFood.add(new Food(context.getResources().getString(R.string.Coffee_milk_SG), 17000.0));
        listFood.add(new Food(context.getResources().getString(R.string.Orange_juice), 15000.0));
        listFood.add(new Food(context.getResources().getString(R.string.Lemon_juice), 12000.0));
        listFood.add(new Food(context.getResources().getString(R.string.Pepsi), 8000.0));
        listFood.add(new Food(context.getResources().getString(R.string.Yellow_sting), 9000.0));
        listFood.add(new Food(context.getResources().getString(R.string.Strawberry_sting), 9000.0));
        listFood.add(new Food(context.getResources().getString(R.string.Aquafina), 5000.0));
        return listFood;
    }
}
