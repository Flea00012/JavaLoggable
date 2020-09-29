package com.lee;

public class Animal implements java.io.Serializable {


    private String category;
    private String name;
    private String breed;
    private String color;
    private String owner;

    public Animal(String category, String name, String breed, String color, String owner) {
        this.category = category;
        this.name = name;
        this.breed = breed;
        this.color = color;
        this.owner = owner;
    }

    @Override
    public String toString(){
        return new String (category + ", " + name + ", " + breed + ", "+ color + ", " + owner);
    }


    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public String getColor() {
        return color;
    }

    public String getOwner() {
        return owner;
    }
}


