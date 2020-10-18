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

package main.java.leeLogger;


import java.io.*;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class FileHandler implements Serializable {

    public static String str;


    //separates Transactions from files into separate files for income and expenses.
    public static void fileInput() {

        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader("Resources/AllTransactions.csv")));
             PrintWriter incomeWriter = new PrintWriter(new BufferedWriter(new FileWriter("Resources/IncomeTransactions.csv")));
             PrintWriter expensesWriter = new PrintWriter(new BufferedWriter(new FileWriter("Resources/ExpensesTransactions.csv")))) {


            while (scanner.hasNext()) {
                str = scanner.useDelimiter("\\.").nextLine();

                if (str.contains("INCOME")) {
                    incomeWriter.write(str + "\n");
                } else if (str.contains("EXPENSE")) {
                    expensesWriter.write(str + "\n");
                } else {
                    System.err.println("Invalid transaction type. Please check if its an income or expenses type of transaction.");
                }

            }

        } catch (IOException e) {

            e.printStackTrace();

        }

    } //end fileInput



//    sends Transactions user input from list objects to the Resources/TransactionsAdditions.txt directory.
    public void userInput(List<Transactions> list) {


        try (PrintWriter fileWriter = new PrintWriter(new BufferedWriter(new FileWriter("Resources/AllTransactions.csv")))) {

            ListIterator<Transactions> itr = list.listIterator();


            int i = 1;
            while (itr.hasNext() && i < 11) {


                String obj = itr.next().toString();
                fileWriter.write(" " + i + " - " + obj + "\n");

                i++;
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


    } // end FileHandler


    public static void saveToStorage() {

        try (Scanner scanner = new Scanner(new FileReader("Resources/AllTransactions.csv"))) {
            String fileContent = " ";
            while (scanner.hasNext()) {
                fileContent = fileContent.concat(scanner.nextLine() + "\n");

            }
            FileWriter writer = new FileWriter("Resources/StorageFile.csv");
            writer.write(fileContent);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }




}





