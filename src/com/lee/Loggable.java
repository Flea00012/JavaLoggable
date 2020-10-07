package com.lee;

import java.util.List;

public interface Loggable {

    void userInput(List<? extends Transactions> list);

    void logToDataBase();



}
