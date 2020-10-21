package leeLogger;

import java.io.Serializable;


/**
 * Class is used to produce objects of type transaction.
 *
 * Class implements Serializable and is used to create objects of transactions
 * for the Banking application. These objects are used to recorde transactions by the user.
 *
 *
 * @author leefowler
 */
public class Transactions implements  Serializable, Comparable<Transactions> {


    /**
     * Class TransactionType has two possible variables
     * of INCOME and EXPENSE, which is used to limit the type of
     * transaction types in the application.
     */
    enum TransactionType{
        INCOME, EXPENSE;
    }

    /**
     * The transaction type with possible values
     * INCOME and EXPENSE.
     */
    protected TransactionType itemType;
    /**
     * The String to show date of the transaction.
     */
    private String dateOfTransaction;
    /**
     * The String of the title of the transaction.
     */
    private String title;

    /**
     * The double to store the cost of the transaction.
     */
    private double monetaryValue;


    /**
     * Constructor makes the object of type Transaction with parameters that define the
     * transactions. The income field is boolean to allow true (income) and false (expense).
     *
     * @param income                boolean the type of the transaction (based on Enum class for INCOME and EXPENSE) true is INCOME, false is EXPENSE
     * @param dateOfTransaction     String
     * @param title                 String title of the transaction eg. jeans or income
     * @param monetaryValue         double this is the cost of the item
     */
    public Transactions(boolean income, String dateOfTransaction, String title, double monetaryValue) {

        if(income){
            itemType = TransactionType.INCOME;
        }else{
            itemType = TransactionType.EXPENSE;
        }
        this.dateOfTransaction = dateOfTransaction;
        this.title = title;
        this.monetaryValue = monetaryValue;
    }

    /**
     * Prints the objects of type transaction in String format for the user to read
     *
     * @return String the String object is returned for use in display to console and printing
     */
    @Override
    public String toString() {
        return ("{" + this.itemType + ", " + this.dateOfTransaction +", "  + this.title + ", "  + this.monetaryValue + "}") ;
    }

    /**
     * Compared transaction of present object with transaction of another object
     *
     * @param o the transaction from another object of type Transaction
     * @return int the value to allow sorting of the two objects in natural order
     */
    @Override
    public int compareTo(Transactions o) {
        return (int) (this.getMonetaryValue()-o.getMonetaryValue());
    }

    /**
     *
     * @return this.dateOfTransaction the date is returned for the transaction
     */
    public String getDateOfTransaction() {
        return this.dateOfTransaction;
    }

    /**
     *
     * @return this.monetaryValue the cost is returned for the transaction
     */
    public double getMonetaryValue() {
        return this.monetaryValue;
    }

    /**
     *
     * @return this.title the title is returned for the transaction
     */
    public String getTitle() {
        return this.title;
    }


    /**
     *
     * @param itemType sets the type of transaction based on class Enum (INCOME and EXPENSE)
     */
    public void setItemType(TransactionType itemType) {
        this.itemType = itemType;
    }

    /**
     *
     * @param dateOfTransaction sets the date of the transaction
     */
    public void setDateOfTransaction(String dateOfTransaction) {
        this.dateOfTransaction = dateOfTransaction;
    }

    /**
     *
     * @param monetaryValue sets the cost of the transaction
     */
    public void setMonetaryValue(double monetaryValue) {
        this.monetaryValue = monetaryValue;
    }

    /**
     *
     * @param title sets the title for the transaction
     */
    public void setTitle(String title) {
        this.title = title;
    }
}




