package com.lee;

import java.util.LinkedList;


public class Main {

    public static void main(String[] args) {

        //read Pets into program and output to appropriate files
        AnimalLogger.fileInput();


        //make List of type AnimalLogger and read into appropriate files
        AnimalLogger dogLogger = new AnimalLogger();
        LinkedList <Dog> dogParlour = new LinkedList<>();
        dogParlour.add(new Dog("dog",
                "Snoopy",
                "Poodle",
                "brown",
                "Peter",
                "Chicken",
                "stick",
                1000));

        dogParlour.add(new Dog("dog",
                "Sasha",
                "German Shepherd",
                "black/brown",
                "lee",
                "Chicken",
                "Lee's Car",
                1500));

        dogParlour.add(new Dog("dog",
                "Rufus",
                "Mixed",
                "White",
                "David",
                "Beef",
                "Ball",
                1000));
        
        dogParlour.add(new Dog("dog",
        		"Leeper",
        		"BullDog",
        		"Brown",
        		"Josefin",
        		"Beef",
        		"Ball",
        		1000));
        

        dogLogger.userInput(dogParlour);




//        TreeMap<Animal, AnimalLogger> treeMap = new TreeMap<>();
//
//        Animal john = new Animal(1,
//                "john",
//                2,
//                "beef");
//        treeMap.put(john,johnLogger);



    }
}
