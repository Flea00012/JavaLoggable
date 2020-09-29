package com.lee;

public class Cat extends Animal {
    private String foodType;
    private String favouriteToy;
    private double injectionCosts;

    public Cat(String category, String name, String breed, String color, String owner, String foodType, String favouriteToy, double injectionCosts) {
        super(category, name, breed, color, owner);
        this.foodType = foodType;
        this.favouriteToy = favouriteToy;
        this.injectionCosts = injectionCosts;
    }


    @Override
    public String toString() {
        return new String(super.toString() + ", " + foodType + ", " + favouriteToy + ", " + injectionCosts) ;
    }

    public String getFoodType() {
        return foodType;
    }

    public String getFavouriteToy() {
        return favouriteToy;
    }

    public double getInjectionCosts() {
        return injectionCosts;
    }
}
