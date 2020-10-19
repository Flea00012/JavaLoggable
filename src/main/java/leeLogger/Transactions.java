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
     * @param income
     * @param dateOfTransaction
     * @param title
     * @param monetaryValue
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

    @Override
    public String toString() {
        return ("{" + this.itemType + ", " + this.dateOfTransaction +", "  + this.title + ", "  + this.monetaryValue + "}") ;
    }

    @Override
    public int compareTo(Transactions o) {
        return (int) (this.getMonetaryValue()-o.getMonetaryValue());
    }

    /**
     * Getters and Setters for the field variables
     *
     */
    public String getDateOfTransaction() {
        return this.dateOfTransaction;
    }


    public double getMonetaryValue() {
        return this.monetaryValue;
    }


    public String getTitle() {
        return this.title;
    }



    public void setItemType(TransactionType itemType) {
        this.itemType = itemType;
    }

    public void setDateOfTransaction(String dateOfTransaction) {
        this.dateOfTransaction = dateOfTransaction;
    }

    public void setMonetaryValue(double monetaryValue) {
        this.monetaryValue = monetaryValue;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}




