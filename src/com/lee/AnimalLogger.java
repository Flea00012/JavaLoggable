/**
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
import java.util.Scanner;

public class AnimalLogger extends Logger implements Loggable, java.io.Serializable {

    private static String str;

    public AnimalLogger() {
    }

    //separates Dog and Cat objects into files by reading and writing from Pet files.
    public static void fileInput() {

        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader("Resources/AnimalClients.txt")));
             PrintWriter dogFileWriter = new PrintWriter(new BufferedWriter(new FileWriter("Resources/DogGrooming.txt")));
             PrintWriter catFileWriter = new PrintWriter(new BufferedWriter(new FileWriter("Resources/CatGrooming.txt")))) {

            System.err.println("try-scanner-block reached");
            while (scanner.hasNext()) {
                str = scanner.useDelimiter("\\.").nextLine();

                if (str.contains("dog")) {
                    System.err.println("str contains: " + str);
                    dogFileWriter.write(str + "\n");
                } else if (str.contains("cat")) {
                    catFileWriter.write(str + "\n");
                } else {
                    System.err.println("Invalid Pet type. Check if its a dog or cat to visit the Parlour");
                }

            }

        } catch (IOException e) {
            System.err.println("FileInput catch blocked reached");
            e.printStackTrace();

        }

    } //end fileInput


    //sends user input from list objects to the Resources/AnimalAdditions.txt directory.
    @Override
    public void userInput(List<? extends Animal> list) {

        System.out.println("list: " + list + "\n");
        try (PrintWriter fileWriter = new PrintWriter(new BufferedWriter(new FileWriter("Resources/AnimalAdditions.txt")))) {

            Iterator itr = list.iterator();

            int i = 0;
            while (itr.hasNext() && i < 10) {
                String obj = itr.next().toString();
                System.err.println("scanner-while from userInput is reached for the " + i + "-nth time");
                fileWriter.write(obj + "\n");
                i++;
            }
        } catch (Exception e) {
            System.err.println("userInput error block is reached");
            e.printStackTrace();

        }

    } //end userInput

    //method to transfer data from AnimalAdditions to AnimalClients with a Check for injectionCosts or something else.

}
