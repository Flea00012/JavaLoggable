/*
 * Class {@code AnimalLogger} is the subclass of abstract class Logger.
 * Logs information about Pets in files. The
 * information comes from files and from user
 * input. file input is read using the Scanner while
 * user input is taken from lists and sent to files
 * via the ObjectOutputStream.
 * Use with the Animal and Dog class to record
 * all the operations of the Dog Parlour.
 *
 * @param <Animal> the type of elements in this list
 * @author Lee Fowler
 */

package com.lee;


import java.io.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.spec.ECField;
import java.util.*;

public class FileHandler implements java.io.Serializable {

    public static String str;


    //separates Transactions from files into separate files for income and expenses.
    public static void fileInput() {

        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader("Resources/AllTransactions.txt")));
             PrintWriter incomeWriter = new PrintWriter(new BufferedWriter(new FileWriter("Resources/IncomeTransactions.txt")));
             PrintWriter expensesWriter = new PrintWriter(new BufferedWriter(new FileWriter("Resources/ExpensesTransactions.txt")))) {

            System.err.println("try-scanner-block reached");
            while (scanner.hasNext()) {
                str = scanner.useDelimiter("\\.").nextLine();

                if (str.contains("INCOME")) {
                    System.err.println("str contains: " + str);
                    incomeWriter.write(str + "\n");
                } else if (str.contains("EXPENSE")) {
                    expensesWriter.write(str + "\n");
                } else {
                    System.err.println("Invalid transaction type. Please check if its an income or expenses type of transaction.");
                }

            }

        } catch (IOException e) {
            System.err.println("FileInput catch blocked reached");
            e.printStackTrace();

        }

    } //end fileInput



//    sends Transactions user input from list objects to the Resources/TransactionsAdditions.txt directory.
    public void userInput(List<Object> list) {

        System.err.println("list: " + list + "\n");
        try (PrintWriter fileWriter = new PrintWriter(new BufferedWriter(new FileWriter("Resources/AllTransactions.txt")))) {

            ListIterator<Object> itr = list.listIterator();


            int i = 1;
            while (itr.hasNext() && i < 11) {

                System.err.println("scanner-while from userInput is reached for the " + i + "-nth time");
                String obj = itr.next().toString();
                fileWriter.write(" " + i + " - " + obj + "\n");

                i++;
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


    } // end FileHandler


    public static void saveToStorage() {

        try (Scanner scanner = new Scanner(new FileReader("Resources/AllTransactions.txt"))) {
            String fileContent = " ";
            while (scanner.hasNext()) {
                fileContent = fileContent.concat(scanner.nextLine() + "\n");

            }
            FileWriter writer = new FileWriter("Resources/StorageFile.txt");
            writer.write(fileContent);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }




}





