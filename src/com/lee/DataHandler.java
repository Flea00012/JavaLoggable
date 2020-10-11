

package com.lee;


import java.io.*;
import java.util.*;


public class DataHandler implements Comparable<Transactions> {


    private String newItem;
    private double newValue;

    public DataHandler(String newItem, double newValue) {
        this.newItem = newItem;
        this.newValue = newValue;
    }

    static List<String> stringList = new LinkedList<>();
    static List<Transactions> objList = new LinkedList<>();



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
    public <E extends Transactions> void readTransactions()  {
        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader("Resources/AllTransactions.txt")));
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("Resources/TransactionsObjectFile.txt"))){
                int iterations = 0;

            do {
                E objPerson = (E) inputStream.readObject();
                System.err.println("while loop reached");
                System.out.println(objPerson);

                inputStream.readObject();
                String str = scanner.useDelimiter("\\.").nextLine();
                stringList.add(str);

                iterations++;
            } while (scanner.hasNext() && inputStream.readObject() != null && iterations < 5);
            System.out.println(stringList);

        } catch (Exception e) {
            e.printStackTrace();
        }


        public static void search(String str) {
        readTransactions();


//error since we have a string and object incompatibility
//        int checker = Collections.binarySearch(objList, transactions, null);

            if(checker >= 0){
                System.out.println("you found the item");
                System.out.println("the index of your transaction is = " + checker);
                return true;
            }else{
                System.err.println("transaction not found");
                return false;
            }

    }


}

