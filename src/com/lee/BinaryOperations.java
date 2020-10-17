package com.lee;


import java.io.*;
import java.util.List;


public class BinaryOperations implements Serializable {


    public void saveBinary(String fileName, Object list) {
        try (ObjectOutputStream oStream = new ObjectOutputStream(new FileOutputStream(fileName))) {

            oStream.writeObject(list);

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object readBinary(String fileName){
        Object transactions = null;
        try (ObjectInputStream iStream = new ObjectInputStream(new FileInputStream(fileName))) {

            while(true) {
                transactions = iStream.readObject();


            }


        } catch (EOFException e) {
            System.out.println("End of file was reached while reading.");
            e.getMessage();
        }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.err.println("From binary file: " + transactions);
        return transactions;
    }



//
//    public static void main(String[] args) {
////        List<Transactions> transactions = new ArrayList<>();
////
////        transactions.add(new Transactions(true, "12/12/2020", 1000.5));
////        transactions.add(new Transactions(false, "11/12/2020", 1000.5));
////        transactions.add(new Transactions(false, "10/12/2020", 0.5));
////        transactions.add(new Transactions(true, "9/12/2020", 500));
//
////        Test.saveBinary("Resources/Herman", transactions);
//
//        List<Transactions> transactions = (List<Transactions>) BinaryOperations.readBinary("Resources/Herman");
//
//        for (Transactions t : transactions){
//            System.out.println(t);
//        }
//
//
//    }


}
