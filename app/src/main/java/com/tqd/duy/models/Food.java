package com.tqd.duy.models;

import java.io.Serializable;

/**
 * Created by Danh on 12/18/2017.
 */

public class Food implements Serializable {
    private String nameFood;
    private Double priceFood;
    private int numberFood;

    @Override
    public String toString() {
        return "Tên: "+nameFood+"\nSố lượng: "+numberFood+
                "\nTổng tiền: "+(priceFood*numberFood);
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
}
