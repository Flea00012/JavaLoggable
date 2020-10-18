package com.lee;


import java.util.*;
import java.util.stream.Collectors;



/**
 * Class runs User Interface inside console
 *
 * The Main class takes in the transactions
 *  from the user via the console. The transactions are stored in
 *  a list of type List<Transactions> The data in the list can be removed,
 *  edited, and viewed as per user specifications. The data can
 *  also be stored in a binary file if the user chooses this option.
 *
 * @author leefowler
 */
public class Main {

    //the list for reading the Transactions from the user
    private static List<Transactions> transactions = new ArrayList<>();

    //the object to read and write Transactions to a file named UserData
    private static BinaryOperations binaryOperations = new BinaryOperations();

    //switch on the application
    private static boolean ON = true;


    /**
     * Method runs the application once
     * at least once using a do-while loop
     * @param args
     */
    public static void main(String[] args)  {


        transactions = (List<Transactions>) binaryOperations.readBinary();

        //counts the iterations of the application to limit the user to 5 iterations
        int counts = 0;
        System.out.println("Welcome to the Banking Application \n");

        do {
            welcomePanel();

            //can only run the application for 5 iterations
        } while (ON && counts < 5);


    } // end main()

    /**
     * Method displays a welcome panel for the user
     * to decide on options of (1) show items,
     * (2) add items, (3) edit items, (4)
     * save and exit application.
     *
     * @throws InputMismatchException
     */
    private static void welcomePanel(){
        //welcome menu

        System.out.println("Please choose an option below: \n");

        System.out.println("(1) Show items \n");
        System.out.println("(2) Add items \n");
        System.out.println("(3) Edit items \n");
        System.out.println("(4) Save and Exit. \n");


        Scanner scanner = new Scanner((System.in));
        int showOption = scanner.nextInt();

    try{
        switch(showOption) {
            case 1:
                showItemMenu();
                break;
            case 2:
                addItemMenu();
                break;
            case 3:
                editItemMenu();
                break;
            case 4:
                saveItemMenu();
                ON = false;
                break;
            default:
                System.out.println("You entered invalid input, please try again.");

        }
    }catch (InputMismatchException e){
        System.out.println("You entered invalid input, please try again.");
        welcomePanel();
    }

    }


    /**
     * Method displays menu to show items for the user
     * to decide on options of (1) show all items,
     * (2) Show expenses only, (3) Show income only,
     *
     * @throws InputMismatchException
     */
    private static void showItemMenu(){

        System.out.println("You chose to show the stored items. Please select from the given options. ");
        System.out.println("(1) Show all items \n");
        System.out.println("(2) Show expense(s) items \n");
        System.out.println("(3) Show income(s) items \n");

        Scanner scanner = new Scanner((System.in));
        int showOption = scanner.nextInt();


    try{

        switch (showOption) {
            case 1:
                System.out.println("You chose to show all items.\n");
                for (Transactions t : transactions) {
                    System.out.println(t);
                    System.out.println("\n");
                }
                System.out.println("\n Please choose (1) descending  or (2) ascending to order the display data.");
                int order = scanner.nextInt();

                if(order == 1){
                    Collections.sort(transactions, new DisplayAllTransactionsDescendCost());
                    for(int i=0; i<transactions.size(); i++)
                        System.out.println(transactions.get(i));
                }

                if(order == 2){
                    Collections.sort(transactions, new DisplayAllTransactionsAscendCost());
                    for(int i=0; i<transactions.size(); i++)
                        System.out.println(transactions.get(i));
                }

                Collections.sort(transactions, new TransactionSortingDateCost());
                System.out.println("\nIn addition items are sorted according to date and title as follows:\n");
                for (Transactions t : transactions) {
                    System.out.println(t);
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
                welcomePanel();
                break;
        }
    }catch (InputMismatchException e){
        System.out.println("You entered invalid input, please try again.");
        welcomePanel();
    }


    }

    /**
     * Method displays menu to add items for the user
     * to decide on options of (1) add expenses,
     * (2) add incomes.
     *
     * @throws InputMismatchException
     */
    private static void addItemMenu(){

        System.out.println("You chose to add items. Please select from the given options. ");

        System.out.println("(1) Add expense(s) \n");
        System.out.println("(2) Add income(s) \n");

        Scanner scanner = new Scanner((System.in));
        int addOption = scanner.nextInt();



        switch (addOption) {
            case 1:
                System.out.println("You chose to add expense(s). Please insert the date (MM/DD/YYYY), followed by title, followed by cost of item.");
                String expenseDate = scanner.next();
                String title = scanner.next();
                double expenseMoney = scanner.nextDouble();



//                if (!expenseDate.contains("/")) {
//                    System.err.println("Please enter a valid date in the specified format.");
//                    ON = false;
//                }
//                System.out.println("Please enter the transaction title eg. jeans.");
//
//                if (title.getClass() != String.class) {
//                    System.out.println("Please enter a valid title for the transaction.");
//                    ON = false;
//                }
//                System.out.println("Please enter the monetary value.");
//
//                if (expenseMoney <= 0) {
//                    System.err.println("Please enter a non-zero transaction.");
//                    ON = false;
//                }

                    transactions.add(new Transactions(false, expenseDate, title, expenseMoney));
                    System.out.println("transactions:"+ transactions);


                break;
            case 2:
                System.out.println("You chose to add income(s). Please insert the date (MM/DD/YYYY).");
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
                    System.out.println("transactions:"+ transactions);
                }catch(NullPointerException e){
                    e.getMessage();
                }

                break;
            default:
                System.err.println("Please enter a valid option from the menu. You will be re-directed to the main menu.");
                welcomePanel();
                break;
        }


    }




    /**
     * Method displays menu to edits items for the user
     * to decide on options of (1) edit item,
     * (2) remove item.
     *
     * @throws InputMismatchException
     */
    private static void editItemMenu(){

        System.out.println("You chose to edit/remove items. Please select from the given options. ");

        System.out.println("(1) Edit item \n");
        System.out.println("(2) Remove item \n");

        Scanner scanner = new Scanner((System.in));
        int editOption = scanner.nextInt();

        try {
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
                    welcomePanel();
                    break;
            }
        }catch (InputMismatchException e){
            System.out.println("You entered invalid input, please try again.");
            welcomePanel();
        }

    }

    /**
     * Method displays menu to save and exit
     * from the application.
     */
    private static void saveItemMenu(){
        System.out.println("You chose to save and exit. Goodbye. \n");

        //save the list of objects to Binary file
        Object obj = (Object) transactions;
        binaryOperations.saveBinary(obj);

        //switch off the application and exit
        ON = false;


//                    // write all the objects to .csv files
//                    FileHandler fileHandler = new FileHandler();
//                    fileHandler.userInput(transactions);
//                    //separate income and expenses in separate files
//                    FileHandler.fileInput();





    }






} // end class Main













