package com.lee;


import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Main extends BinaryOperations {

    public static void main(String[] args)  {

        //the list for reading the Transactions from the user
        List<Transactions> transactions = new ArrayList<>();

        //the object to read and write Transactions to a file named UserData
        BinaryOperations binaryOperations = new BinaryOperations();

        //switch on the application
        boolean ON = true;

        //counts the iterations of the application to limit the user to 5 iterations
        int counts = 0;

        System.out.println("Welcome to the Banking Application \n");
        File file = new File("Resources/UserData");



        //initial file setup in Resources/UserData file to store transactions
        try {


            if(file.exists() && file.canRead() && file.length() != 0 && file.isFile()){
                transactions = (List<Transactions>) binaryOperations.readBinary("Resources/UserData");
            }

        } catch (Exception e) {
            System.out.println("An Exception occurred in the application due to initial file creation. Run the program again.");
            e.printStackTrace();
        }

        do {

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
                            System.out.println("You chose to show all items.\n");
                            for (Transactions t : transactions) {
                                System.out.println(t);
                                System.out.println("\n");
                            }

                            break;
                        case 2:
                            System.out.println("You chose to show expense(s) only.\n");
                            List<Transactions> trans2 = transactions.stream()
                                        .filter(transaction -> (transaction.itemType == Transactions.TransactionType.EXPENSE)).collect(Collectors.toList());
                                        trans2.forEach(System.out::println);
                                        System.out.println("\n");

                            break;
                        case 3:
                            System.out.println("You chose to show income(s) only.\n");
                            List<Transactions> trans3 = transactions.stream()
                                        .filter(transaction -> (transaction.itemType == Transactions.TransactionType.INCOME)).collect(Collectors.toList());
                                        trans3.forEach(System.out::println);
                                        System.out.println("\n");

                            break;
                        default:
                            System.err.println("Please enter a valid option from the menu. You will be re-directed to the main menu.\n");
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
                            System.out.println("You chose to add expense(s). Please insert the date (DD/MM/YYYY).");
                            String expenseDate = scanner.next();
                            if (!expenseDate.contains("/")) {
                                System.err.println("Please enter a valid date in the specified format.");
                                ON = false;
                            }
                            System.out.println("Please enter the transaction title eg. jeans.");
                            String title = scanner.next();
                            if (title.getClass() != String.class) {
                                System.out.println("Please enter a valid title for the transaction.");
                                ON = false;
                            }
                            System.out.println("Please enter the monetary value.");
                            double expenseMoney = scanner.nextDouble();
                            if (expenseMoney <= 0) {
                                System.err.println("Please enter a non-zero transaction.");
                                ON = false;
                            }
                            try {
                                transactions.add(new Transactions(false, expenseDate, title, expenseMoney));
                            }catch(NullPointerException e){
                                transactions.add(new Transactions(false, expenseDate, title, expenseMoney));
                            }

                            break;
                        case 2:
                            System.out.println("You chose to add income(s). Please insert the date (DD/MM/YYYY).");
                            String incomeDate = scanner.next();
                            if (!incomeDate.contains("/")) {
                                System.err.println("Please enter a valid date in the specified format.");
                                ON = false;
                            }
                            System.out.println("Please enter the transaction title eg. freelance");
                            String incomeTitle = scanner.next();
                            if (incomeTitle.getClass() != String.class) {
                                System.out.println("Please enter a valid title for the transaction.");
                                ON = false;
                            }
                            System.out.println("Please enter the monetary value.");
                            double incomeMoney = scanner.nextDouble();
                            if (incomeMoney <= 0) {
                                System.err.println("Please enter a non-zero transaction.");
                                ON = false;
                            }
                            try {
                                transactions.add(new Transactions(true, incomeDate, incomeTitle, incomeMoney));
                            }catch(NullPointerException e){
                                transactions.add(new Transactions(true, incomeDate, incomeTitle, incomeMoney));
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
//                            for(Transactions t : transactions) {
//                                if(transactions!=null && "Doe".equals(transactions.getDateOfTransaction())) {
//                                    transactions.setDateOfTransaction("22/12/2019");
//                                    break;
//                                }
//                            }

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
                    System.out.println("You chose to save and exit. Goodbye. \n");
                    //save the list of objects to Binary file
                    binaryOperations.saveBinary("Resources/UserData",transactions);
//                    // write all the objects to .csv files
//                    FileHandler fileHandler = new FileHandler();
//                    fileHandler.userInput(transactions);
//                    //separate income and expenses in separate files
//                    FileHandler.fileInput();

                    //switch off the application and exit
                    ON = false;
                    break;
                default:
                    System.err.println("Please enter a valid option from the menu.");

            }

            //can only run the application for 5 iterations
        } while (ON && counts < 5);


    } // end main()
} // end class Main













