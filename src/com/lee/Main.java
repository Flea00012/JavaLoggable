package com.lee;

import java.util.*;


public class Main {

    public static void main(String[] args) {

        /*

        //make List of type Transactions and read into appropriate files
        FileHandler fileLogger = new FileHandler();
        ArrayList<Transactions> transactions = new ArrayList<>();

        transactions.add(new Transactions(true, "12/12/2020", 1000.5));
        transactions.add(new Transactions(false, "11/12/2020", 1000.5));
        transactions.add(new Transactions(false, "10/12/2020", 0.5));
        transactions.add(new Transactions(true, "9/12/2020", 500));
        fileLogger.userInput(transactions);



        //read Transaction from Main file to Income and Expenses files
        FileHandler.fileInput();


        DataHandler dataHandler = new DataHandler("INCOME",2000.5);
//        dataHandler.search(new Transactions(true,"12/12/2020", 1000.5));
//        dataHandler.search("files");
//        System.out.println("check = " + check);
        dataHandler.readTransactions();

            List<String> list = dataHandler.readToList("Resources/AllTransactions.txt");
          	Iterator<String> itr = list.iterator();
            System.out.println();

          	while (itr.hasNext()) {
                System.out.println(itr.next());
            }

          	*/


            boolean ON = true;
            int counts = 0;

        do {

            System.out.println("Welcome to the Banking Application \n");
            System.out.println("Please choose an option below: \n");
            System.out.println("(1) Show items \n");
            System.out.println("(2) Add items \n");
            System.out.println("(3) Edit items \n");
            System.out.println("(4) Save and Exit. \n");

            Scanner scanner = new Scanner((System.in));
            int option;
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("You chose to show the stored items. Please select from the given options. ");
                    System.out.println("(1) Show all items \n");
                    System.out.println("(2) Show expense(s) items \n");
                    System.out.println("(3) Show income(s) items \n");

                    int showOption = scanner.nextInt();

                        switch (showOption) {
                            case 1:
                                System.out.println("You chose to show all items.");

                                break;
                            case 2:
                                System.out.println("You chose to show expense(s) only.");

                                break;
                            case 3:
                                System.out.println("You chose to show income(s) only.");

                                break;
                            default:
                                System.err.println("Please enter a valid option from the menu. You will be re-directed to the main menu.");
                                break;
                        }

                    break;
                case 2:
                    System.out.println("You chose to add items. Please select from the given options. ");

                        System.out.println("(1) Add expense(s) \n");
                        System.out.println("(2) Add income(s) \n");

                        int addOption = scanner.nextInt();

                        switch (addOption) {
                            case 1:
                                System.out.println("You chose to add expense(s).");
                                break;
                            case 2:
                                System.out.println("You chose to add income(s).");
                                break;
                            default:
                                System.err.println("Please enter a valid option from the menu. You will be re-directed to the main menu.");
                                break;
                        }

                    break;

                case 3:
                    System.out.println("You chose to edit items. Please select from the given options. ");

                    System.out.println("(1) Edit item \n");
                    System.out.println("(2) Remove item \n");

                    int editOption = scanner.nextInt();

                    switch (editOption) {
                        case 1:
                            System.out.println("You chose to edit an item.");
                            break;
                        case 2:
                            System.out.println("You chose to remove an item.");
                            break;
                        default:
                            System.err.println("Please enter a valid option from the menu. You will be re-directed to the main menu.");
                            break;
                    }


                    break;
                case 4:
                    System.out.println("You chose to save and exit. Goodbye.");
                    //userInput -> save items
                    //fileInput -> read to expenses and incomes
                    ON = false;
                    break;
                default:
                    System.err.println("Please enter a valid option from the menu.");

            }



        } while(ON && counts<5);








    } // end main()
} // end class Main













