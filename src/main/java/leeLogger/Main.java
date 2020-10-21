package leeLogger;


//import main.java.leeLogger.*;

import java.util.*;
import java.util.stream.Collectors;


/**
 * Class runs User Interface inside console
 *
 * The {@code Main} class takes in the transactions
 *  from the user via the console. The transactions are stored in
 *  a list of type {@code List<Transactions>} The data in the list can be removed,
 *  edited, and viewed as per user specifications. The data can
 *  also be stored in a binary file if the user chooses this option. Finally,
 *  the object data is also read to <b>.csv format</b>
 *
 * @author leefowler
 */
public class Main {

    /**
     * the list for reading the Transactions from the user
     */
    private static List<Transactions> transactions = new ArrayList<>();

    /**
     * the object to read and write Transactions to a file named UserData
     */
    private static BinaryOperations binaryOperations = new BinaryOperations();

    /**
     * switch on the application
     */
    private static boolean ON = true;


    /**
     * Method runs the application
     * at least once using a do-while loop
     * @param args String an argument in string format to run the application
     */
    public static void main(String[] args)  {


        transactions = (List<Transactions>) binaryOperations.readBinary("Resources/UserData");

        if (transactions == null) {
            transactions = new ArrayList<>();
        }


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
     * @throws InputMismatchException   catches the incorrect input from the user
     *                                  and ensures the program returns to main menu
     */
    private static void welcomePanel(){
        //welcome menu

        System.out.println("\nPlease choose an option below: \n");

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

    }//end welcomePanel()

    /**
     * Method displays menu to show items for the user
     * to decide on options of (1) show all items,
     * (2) Show expenses only, (3) Show income only,
     *
     * @throws InputMismatchException An incorrect input from the user will result in an exception and use will be redirected to the menu
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

                }
                System.out.println("\n Please choose (1) descending  or (2) ascending to order the display transactions.");
                int order = scanner.nextInt();

                /**
                 * All the transactions are shown in descending order when the user selects
                 * 1 for the option, to order the transactions in display
                 */
                if(order == 1){
                    System.out.println("--- List of Transactions in descending order based on cost, date  ---\n");
                    System.out.println("Transactions in descending order based on cost \n");
                    Collections.sort(transactions, new DisplayAllTransactionsDescendCost());
                    for(int i=0; i<transactions.size(); i++)
                        System.out.println(transactions.get(i));

//                    Collections.sort(transactions, new TransactionSortingDateCost());

                    System.out.println("\nIn addition items are sorted according to month in descending order as follows :\n");

                    List<Transactions> sortedList = transactions.stream()
                            .sorted(Comparator.comparing(Transactions::getDateOfTransaction))
                            .collect(Collectors.toList());
                            sortedList.forEach(System.out::println);

                }

                /**
                 * All the transactions are shown in ascending order when the user selects
                 * 2 for the option, to order the transactions in display
                 */
                if(order == 2){
                    System.out.println("--- List of Transactions in ascending order based on cost ---\n");
                    System.out.println("Transactions in ascending order based on cost \n");
                    Collections.sort(transactions, new  DisplayAllTransactionsAscendCost());
                    for(int i=0; i<transactions.size(); i++)
                        System.out.println(i + ": " + transactions.get(i));

                    System.out.println("\nIn addition items are sorted according to month as follows in ascending order: \n");
                    List<Transactions> sortedList = transactions.stream()
                            .sorted(Comparator.comparing(Transactions::getDateOfTransaction))
                            .collect(Collectors.toList());
                    sortedList.forEach(System.out::println);

                    System.out.println("\nFinally items are sorted according to title as follows in ascending order:\n");
                    List<Transactions> sortedList2 = transactions.stream()
                            .sorted(Comparator.comparing(Transactions::getTitle))
                            .collect(Collectors.toList());
                    sortedList2.forEach(System.out::println);
                }


                break;
            case 2:
                System.out.println("You chose to show expense(s) only.\n");
                List< Transactions> trans2 = transactions.stream()
                        .filter(transaction -> (transaction.itemType ==  Transactions.TransactionType.EXPENSE)).collect(Collectors.toList());
                trans2.forEach(System.out::println);
                System.out.println("\n");

                break;
            case 3:
                System.out.println("You chose to show income(s) only.\n");
                List< Transactions> trans3 = transactions.stream()
                        .filter(transaction -> (transaction.itemType ==  Transactions.TransactionType.INCOME)).collect(Collectors.toList());
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


    } //end showItemMenu()

    /**
     * Method displays menu to add items for the user
     * to decide on options of (1) add expenses,
     * (2) add incomes.
     *
     * @throws InputMismatchException An incorrect input from the user will result in an exception and use will be redirected to the menu
     */
    private static void addItemMenu(){

        System.out.println("You chose to add items. Please select from the given options. ");

        System.out.println("(1) Add expense(s) \n");
        System.out.println("(2) Add income(s) \n");

        Scanner scanner = new Scanner((System.in));
        int addOption = scanner.nextInt();

    try{

        switch (addOption) {
            case 1:
                System.out.println("You chose to add expense(s). Please insert the date in format (MM/DD/YYYY), followed by title (eg. jeans), followed by cost of item.");
                String expenseDate = scanner.next();
                String expenseTitle = scanner.next();
                double expenseMoney = scanner.nextDouble();

                if (!expenseDate.contains("/")) {
                    System.err.println("Please enter a valid date in the specified format.");
                    addItemMenu();
                }
                if (expenseTitle.getClass() != String.class) {
                    System.out.println("Please enter a valid title for the transaction eg. jeans.");
                    addItemMenu();
                }
                if (expenseMoney <= 0) {
                    System.err.println("Please enter a non-zero transaction.");
                    addItemMenu();
                }
                     Transactions trans = new  Transactions(false, expenseDate, expenseTitle, expenseMoney);
                    transactions.add(trans);
                    System.out.println("transactions:"+ transactions);


                break;
            case 2:
                System.out.println("You chose to add income(s). Please insert the date in format (MM/DD/YYYY), followed by title (eg. work), followed by cost of item.");
                String incomeDate = scanner.next();
                String incomeTitle = scanner.next();
                double incomeMoney = scanner.nextDouble();

                if (!incomeDate.contains("/")) {
                    System.err.println("Please enter a valid date in the specified format.");
                    addItemMenu();
                }
                if (incomeTitle.getClass() != String.class) {
                    System.out.println("Please enter a valid title for the transaction.");
                   addItemMenu();
                }
                if (incomeMoney <= 0) {
                    System.err.println("Please enter a non-zero transaction.");
                    addItemMenu();
                }

                transactions.add(new  Transactions(true, incomeDate, incomeTitle, incomeMoney));
                System.out.println("transactions:" + transactions);

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

    }//end addItemMenu()


    /**
     * Method displays menu to edits items for the user
     * to decide on options of (1) edit item,
     * (2) remove item.
     *
     * @throws InputMismatchException An incorrect input from the user will result in an exception and use will be redirected to the menu
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
                    editTransaction();
                    break;
                case 2:
                    removeTransaction();
                    break;
            }
        }catch (InputMismatchException e){
            System.out.println("You entered invalid input, please try again.");
            welcomePanel();
        }

    }//end editItemMenu()


    /**
     * Method displays menu to edit items for the user
     * to decide on options of for editing a specific item. The
     * user is instructed to enter a specific value and failure to do
     * so will result in a {@code InputMismatchException} being thrown
     *
     * @throws InputMismatchException An incorrect input from the user will result in an exception and use will be redirected to the menu
     */
   private static void editTransaction(){

   try{

       Scanner scanner = new Scanner (System.in);
       for (int i=0; i<transactions.size();i++){
           System.out.println(i + ": " + transactions.get(i));
       }
       System.out.println("\nPlease enter index (on the left) of the item you wish to edit (eg. 1)");
       int index = scanner.nextInt();

       System.out.println("\nPlease select the type of replacement transaction: (1) expense or (2) income.\n");
       int newItem = scanner.nextInt();

       System.out.println("\nPlease insert the date in format (MM/DD/YYYY), followed by title (eg. work), followed by cost of item.\n");
       String newDate = scanner.next();
       String newTitle = scanner.next();
       double newCost = scanner.nextDouble();

       if (!newDate.contains("/")) {
           System.out.println("Please enter a valid date in the specified format.");
           editTransaction();
       }
       if (newTitle.getClass() != String.class) {
           System.out.println("Please enter a valid title for the transaction.");
           editTransaction();
       }
       if (newCost <= 0) {
           System.out.println("Please enter a non-zero transaction.");
           editTransaction();
       }

       if (newItem == 1) {
           transactions.set(index, new  Transactions(false, newDate, newTitle, newCost));
       }else {
           transactions.set(index, new  Transactions(true, newDate, newTitle, newCost));
       }

   }catch (InputMismatchException e){
        System.out.println("You entered invalid input, please try again.");
        welcomePanel();
    }

   }//end editTransaction()



    /**
     * Method displays menu to edit items for the user
     * to decide on options of for editing a specific item. The
     * user is instructed to enter a specific value and failure to do
     * so will result in a {@code InputMismatchException} being thrown
     *
     * @throws InputMismatchException An incorrect input from the user will result in an exception and use will be redirected to the menu
     */
   private  static void removeTransaction() {

   try{
       Scanner scanner = new Scanner(System.in);
       for (int i=0; i<transactions.size();i++){
           System.out.println(i + ": " + transactions.get(i));
       }

       System.out.println("\nPlease enter index (on the left) of the item you wish to remove (eg. 1)");
       int index=scanner.nextInt();
       transactions.remove(index);

   }catch (InputMismatchException e){
        System.out.println("You entered invalid input, please try again.");
        welcomePanel();
    }

   }//end removeTransaction()

    /**
     * Method displays menu to save and exit
     * from the application.
     */
    public static void saveItemMenu(){
        System.out.println("You chose to save and exit. Goodbye. \n");

        //save the list of objects to Binary file
        Object obj = (Object) transactions;
        binaryOperations.saveBinary(obj, "Resources/UserData");

        //switch off the application and exit
        ON = false;

        // write all the objects to .csv files
        FileHandler fileHandler = new FileHandler();
        fileHandler.userInput(transactions);

        //separate income and expenses in separate files
         FileHandler.fileInput();

    }//end saveItemMenu()


} // end class Main













