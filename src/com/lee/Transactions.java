package com.lee;

public class Transactions implements java.io.Serializable {

    enum TransactionType{
        INCOME, EXPENSE;
    }
    protected  TransactionType itemType;
    private String dateOfTransaction;
    private double monetaryValue;

    public Transactions(boolean income, String dateOfTransaction, double monetaryValue) {

        if(income){
            itemType = TransactionType.INCOME;
        }else{
            itemType = TransactionType.EXPENSE;
        }
        this.dateOfTransaction = dateOfTransaction;
        this.monetaryValue = monetaryValue;
    }

    @Override
    public String toString() {
        return new String(this.itemType + ", " + this.dateOfTransaction+ ", "  + this.monetaryValue) ;
    }

    public String getDateOfTransaction() {
        return dateOfTransaction;
    }


    public double getMonetaryValue() {
        return monetaryValue;
    }


}


