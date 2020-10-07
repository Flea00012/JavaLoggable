package com.lee;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {




        //make List of type Transactions and read into appropriate files
        FileHandler fileLogger = new FileHandler();
        ArrayList<Transactions> transactions = new ArrayList<>();

        transactions.add(new Transactions(true, "12/12/2020", 1000.5));
        transactions.add(new Transactions(false, "11/12/2020", 1000.5));
        transactions.add(new Transactions(false, "10/12/2020", 0.5));
        transactions.add(new Transactions(true, "9/12/2020", 500));
        fileLogger.userInput(transactions);



        //read Transaction from Main file to Income and Expenses files
        FileHandler.fileInput();


        DataHandler dataHandler = new DataHandler("INCOME",2000.5);
        boolean check = dataHandler.search(new Transactions(true,"12/12/2020", 1000.5));
        System.out.println("check = " + check);
//        dataHandler.readTransactions();

//        System.out.println("Welcome to the BankApp \n");
//        System.out.println("Please choose an option below: \n");
//        System.out.println("(1) Show items \n");
//        System.out.println("(2) Add items \n");
//        System.out.println("(3) Edit items \n");
//        System.out.println("(4) Save and Exit. \n");

//        Scanner scanner = new Scanner((System.in));

//        int iterations = 0;
//        while(scanner.nextInt() != 4 && iterations < 2){
//
//            iterations++;
//        }



//        TreeMap<Animal, AnimalLogger> treeMap = new TreeMap<>();
//
//        Animal john = new Animal(1,
//                "john",
//                2,
//                "beef");
//        treeMap.put(john,johnLogger);



    }
}
