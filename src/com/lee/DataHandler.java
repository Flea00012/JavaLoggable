package com.lee;


import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.*;


public class DataHandler implements Comparable<Transactions> {


    enum TransactionType{
        INCOME,EXPENSE;
    }

    private String newItem;
    private double newValue;

    public DataHandler(String newItem, double newValue) {
        this.newItem = newItem;
        this.newValue = newValue;
    }

    static List<String> stringList = new LinkedList<>();
    static List<Byte> objList = new LinkedList<>();



    @Override
    public int compareTo(Transactions transactions) {

        if(newValue == transactions.getMonetaryValue()) {
            return 0;
        }else if(newValue > transactions.getMonetaryValue()){
            return 1;
        }else{
            return -1;
        }
    }



    public static void Edit(){


    }

    public static void Remove(){

    }

    public static void Sort(){
        Collections.sort(stringList);

    }


//    reads data in string format for display to screen and byte format for display internally to the application
    public void readTransactions() throws ClassNotFoundException {
        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader("Resources/AllTransactions.txt")));
            ObjectInputStream objReader = new ObjectInputStream(new FileInputStream("Resources/TransactionsObjectFile.txt"))){
            int iterations = 0;

//          error exists at EOF for byte reader
            while (scanner.hasNext() && iterations < 5 && ) {
                String str = scanner.useDelimiter("\\.").nextLine();
                    stringList.add(str);
//
//              error exists for this reading to the list
//                objReader.readObject();
                objList.addAll((Collection<? extends Byte>) objReader.readObject());



                iterations++;
            }
            System.out.println(stringList);

        }catch (IOException e){
            System.err.println("error in catch for readTransactions() in DataHandler");
            e.printStackTrace();

        }
    }




    public <E extends Transactions> boolean search(E transactions) throws ClassNotFoundException{
        readTransactions();


//error since we have a string and object incompatibility
        int checker = Collections.binarySearch(objList, transactions, null);

            if(checker >= 0){
                System.out.println("you found the value");
                System.out.println("the index of your transaction is = " + checker);
                return true;
            }else{
                System.err.println("transaction not found");
                return false;
            }

    }


}

