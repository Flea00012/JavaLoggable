

package com.lee;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class DataHandler  {


    private String newItem;
    private double newValue;

    public DataHandler(String newItem, double newValue) {
        this.newItem = newItem;
        this.newValue = newValue;
    }

    static List<String> stringList = new LinkedList<>();
    static List<Transactions> objList = new LinkedList<>();



//
//    @Override
//    public int compareTo(Transactions transactions) {
//
//        if(newValue == transactions.getMonetaryValue()) {
//            return 0;
//        }else if(newValue > transactions.getMonetaryValue()){
//            return 1;
//        }else{
//            return -1;
//        }
//    }



    public static void Edit(){

    }

    public static void Remove(){

    }

    public static void Sort(){
//        Collections.sort(stringList);

    }

    public List<String> readToList(String fileName){

        List<String> lines = Collections.emptyList();

        try {
            lines = Files.readAllLines(Paths.get(fileName),StandardCharsets.UTF_8);

        }catch(IOException e){

            System.err.println("catch of readToList was reached");
            e.printStackTrace();
        }
        return lines;
    }



//    reads data in string format for display to screen and byte format for display internally to the application
    public void readTransactions() {
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader("Resources/AllTransactions.txt")))) {
            int iterations = 0;

            do {
                System.err.println("while loop reached in readTransactions()");

                String str = scanner.useDelimiter("\\.").nextLine();
                stringList.add(str);

                iterations++;
            } while (scanner.hasNext() && iterations < 5);
            System.out.println(stringList);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }//end readTransactions()


//        public static void search(String str) {
//        readTransactions();
//
//
////error since we have a string and object incompatibility
////        int checker = Collections.binarySearch(objList, transactions, null);
//
//            if(checker >= 0){
//                System.out.println("you found the item");
//                System.out.println("the index of your transaction is = " + checker);
//                return true;
//            }else{
//                System.err.println("transaction not found");
//                return false;
//            }


} //end DataHandler class

