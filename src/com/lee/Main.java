package com.lee;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class Main {

    public static void main(String[] args) throws InputMismatchException {


//        fileLogger.userInput(transactions);



        //read Transaction from Main file to Income and Expenses files
//        FileHandler.fileInput();

//
//        DataHandler dataHandler = new DataHandler("INCOME",2000.5);
////        dataHandler.search(new Transactions(true,"12/12/2020", 1000.5));
////        dataHandler.search("files");
////        System.out.println("check = " + check);
//        dataHandler.readTransactions();
//
//            List<String> list = dataHandler.readToList("Resources/AllTransactions.txt");
//          	Iterator<String> itr = list.iterator();
//            System.out.println();
//
//          	while (itr.hasNext()) {
//                System.out.println(itr.next());
//            }
//



        //make List of type Transactions and read into appropriate files
        FileHandler fileLogger = new FileHandler();
        List<Object> transactions = new ArrayList<>();


        String fileSaver = " ";

        boolean ON = true;
        int counts = 0;
        System.out.println("Welcome to the Banking Application \n");

        do {
            //read the file into list just as the loop starts
            try(Scanner scanner = new Scanner(new FileReader("Resources/StorageFile.txt"))){

                while(scanner.hasNextLine()){
                    fileSaver = fileSaver.concat(scanner.nextLine() + "\n");
                }
            }catch(IOException e){
                e.printStackTrace();
            }

            String[] str = fileSaver.split(",");
            List<String> list = new ArrayList<>();
            list = Arrays.asList(str);




//            transactions = FileHandler.readFile("Resources/SavedItems");



            System.out.println("Please choose an option below: \n");
            System.out.println("(1) Show items \n");
            System.out.println("(2) Add items \n");
            System.out.println("(3) Edit items \n");
            System.out.println("(4) Save and Exit. \n");

            Scanner scanner = new Scanner((System.in));
            int option;
            option = scanner.nextInt();

            switch (option) {

                case 1: // show item menu
                    System.out.println("You chose to show the stored items. Please select from the given options. ");
                    System.out.println("(1) Show all items \n");
                    System.out.println("(2) Show expense(s) items \n");
                    System.out.println("(3) Show income(s) items \n");

                    int showOption = scanner.nextInt();

                    switch (showOption) {
                        case 1:
                            System.out.println("You chose to show all items.");
                            //streams


                            break;
                        case 2:
                            System.out.println("You chose to show expense(s) only.");
//                                transactions.stream()
//                                        .filter(transactions1 -> transactions1.getMonetaryValue().equals(1000.0));

                            break;
                        case 3:
                            System.out.println("You chose to show income(s) only.");

                            break;
                        default:
                            System.err.println("Please enter a valid option from the menu. You will be re-directed to the main menu.");
                            break;
                    }

                    break;

                case 2: // add item menu
                    System.out.println("You chose to add items. Please select from the given options. ");

                    System.out.println("(1) Add expense(s) \n");
                    System.out.println("(2) Add income(s) \n");

                    int addOption = scanner.nextInt();

                    switch (addOption) {
                        case 1:
                            System.out.println("You chose to add expense(s). Please insert the date (DD/MM/YYYY), followed by the monetary value below.");
                            String expenseDate = scanner.next();
                            double expenseMoney = scanner.nextDouble();
                            if (!expenseDate.contains("/")) {
                                System.err.println("Please enter a valid date in the specified format.");
                                ON = false;
                            } else if (expenseMoney <= 0) {
                                System.err.println("Please enter a non-zero transaction.");
                                ON = false;
                            } else {
                                transactions.add(new Transactions(false, expenseDate, expenseMoney));
                            }
                            break;
                        case 2:
                            System.out.println("You chose to add income(s). Please insert the date (DD/MM/YYYY), followed by the monetary value below.");
                            String incomeDate = scanner.next();
                            double incomeMoney = scanner.nextDouble();
                            if (!incomeDate.contains("/")) {
                                System.err.println("Please enter a valid date in the specified format.");
                                ON = false;
                            } else if (incomeMoney <= 0) {
                                System.err.println("Please enter a non-zero transaction.");
                                ON = false;
                            } else {
                                transactions.add(new Transactions(true, incomeDate, incomeMoney));
                            }

                            break;
                        default:
                            System.err.println("Please enter a valid option from the menu. You will be re-directed to the main menu.");
                            break;
                    }

                    break;

                case 3: //edit menu
                    System.out.println("You chose to edit/remove items. Please select from the given options. ");

                    System.out.println("(1) Edit item \n");
                    System.out.println("(2) Remove item \n");

                    int editOption = scanner.nextInt();

                    switch (editOption) {
                        case 1:
                            System.out.println("You chose to edit an item. Please enter 'E' for expense or 'I' for income.");
                            String editType = scanner.next();


                            break;
                        case 2:
                            System.out.println("You chose to remove an item. Please enter 'E' for expense or 'I' for income.");
                            String removeType = scanner.next();
                            break;
                        default:
                            System.err.println("Please enter a valid option from the menu. You will be re-directed to the main menu.");
                            break;
                    }


                    break;
                case 4:
                    System.out.println("You chose to save and exit. Goodbye.");
                    //userInput -> save items
                    fileLogger.userInput(transactions);
                    //fileInput -> read to expenses and incomes
                    FileHandler.fileInput();
                    //make a file to append with new data everytime
                    FileHandler.saveToStorage();


                    ON = false;
                    break;
                default:
                    System.err.println("Please enter a valid option from the menu.");

            }


        } while (ON && counts < 5);




    } // end main()
} // end class Main













