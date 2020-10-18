package com.lee;

import java.io.FileNotFoundException;
import java.util.List;

public interface Loggable {

    void userInput(List<? extends Transactions> list) throws FileNotFoundException;

    void logToDataBase();



}
