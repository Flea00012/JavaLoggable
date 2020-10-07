package com.lee;


import java.util.List;

public abstract class Logger implements Loggable, java.io.Serializable {

    @Override
    public void logToDataBase() {

    }



    public abstract void userInput(List<? extends Transactions> list);



}
