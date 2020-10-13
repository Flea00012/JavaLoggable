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

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class FileHandler extends Logger implements Loggable, java.io.Serializable {

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



    //sends Transactions user input from list objects to the Resources/TransactionsAdditions.txt directory.
    public void userInput(List<? extends Transactions> list) {

        System.err.println("list: " + list + "\n");
        try (PrintWriter fileWriter = new PrintWriter(new BufferedWriter(new FileWriter("Resources/AllTransactions.txt")))) {

            ListIterator<? extends Transactions> itr = list.listIterator();


            int i = 0;
            while (itr.hasNext() && i < 10) {

                System.err.println("scanner-while from userInput is reached for the " + i + "-nth time");
                String obj = itr.next().toString();
                fileWriter.write(obj + "\n");

                i++;
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


    } // end FileHandler
}