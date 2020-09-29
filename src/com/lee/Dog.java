package com.lee;

/**
 *
 * Dog class is a subclass of Animal.
 * Also to use the AnimalLogger class to create instances
 * the Dog Parlour clients and record the operations of the shop,
 * such as spending and visits and when is the next visitation.
 */

public class Dog extends Animal {

    private String foodType;
    private String favouriteToy;
    private double injectionCosts;

    public Dog(String category, String name, String breed, String color, String owner, String foodType, String favouriteToy, double injectionCosts) {
        super(category, name, breed, color, owner);
        this.foodType = foodType;
        this.favouriteToy = favouriteToy;
        this.injectionCosts = injectionCosts;
    }

    @Override
    public String toString(){
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

    public double weightIncrease(int oldWeight, int newWeight){
        return (int) Math.abs(oldWeight-newWeight);
    }
}






