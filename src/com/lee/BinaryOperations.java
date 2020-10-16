package com.lee;



import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BinaryOperations {





    public static void saveBinary(String fileName, Object list) {
        try (ObjectOutputStream oStream = new ObjectOutputStream(new FileOutputStream(fileName))) {

            oStream.writeObject(list);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object readBinary(String fileName){
        Object transactions = null;
        try (ObjectInputStream iStream = new ObjectInputStream(new FileInputStream(fileName))) {

            transactions = iStream.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return transactions;
    }


    public static void main(String[] args) {
//        List<Transactions> transactions = new ArrayList<>();
//
//        transactions.add(new Transactions(true, "12/12/2020", 1000.5));
//        transactions.add(new Transactions(false, "11/12/2020", 1000.5));
//        transactions.add(new Transactions(false, "10/12/2020", 0.5));
//        transactions.add(new Transactions(true, "9/12/2020", 500));

//        Test.saveBinary("Resources/Herman", transactions);

        List<Transactions> transactions = (List<Transactions>) BinaryOperations.readBinary("Resources/Herman");

        for (Transactions t : transactions){
            System.out.println(t);
        }


    }


}
