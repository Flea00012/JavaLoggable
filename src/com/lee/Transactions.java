package com.lee;

import java.io.Serializable;

public class Transactions implements Serializable {



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
        return (this.itemType + ", " + this.dateOfTransaction + ", "  + this.monetaryValue) ;
    }


//    @Override
//    public int compareTo(Transactions transactions) {
//        if(this.monetaryValue > transactions.getMonetaryValue()) {
//            return 1;
//        }else if (this.monetaryValue < transactions.getMonetaryValue()) {
//            return -1;
//        }
//        return 0;
//    }

    public String getDateOfTransaction() {
        return dateOfTransaction;
    }


    public double getMonetaryValue() {
        return monetaryValue;
    }


}


