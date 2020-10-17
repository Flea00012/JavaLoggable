package com.lee;

import java.io.Serializable;

public class Transactions implements  Serializable, Comparable<Transactions> {




    enum TransactionType{
        INCOME, EXPENSE;
    }

    protected  TransactionType itemType;
    private String dateOfTransaction;
    private String title;
    private double monetaryValue;




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


    public String getDateOfTransaction() {
        return dateOfTransaction;
    }


    public double getMonetaryValue() {
        return monetaryValue;
    }


    public String getTitle() {
        return title;
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


