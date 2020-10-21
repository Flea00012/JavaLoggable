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

package leeLogger;


import java.io.*;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

/**
 *  Class saves Object data in .CSV format and reads this data from a .CSV file
 *  *
 *  * The {@code FileHandler} class takes in the transactions
 *  * as a list object of type Transactions and saves the data to directory
 *  * <b>"Resources/AllTransactions.csv"</b>. The same file is updated in storage
 *  * when the user re-starts the application and saves the project before exiting.
 *  *
 *  * @author leefowler
 */
public class FileHandler implements Serializable {

    /**
     * the String for reading the Transactions from one file to another
     */
    public static String str;


    /**
     * The {@code fileInput} method separates all the Transactions from the main file into separate files for income and expenses.
     */
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


    /**
     * The {@code userInput} method takes in user input from a list of objects of type Transactions.
     * These objects are saved in to the Resources/AllTransactions.csv directory.
     *
     * @param list List<> the list object read in from the user containing a list of user transactions
     */
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



}





