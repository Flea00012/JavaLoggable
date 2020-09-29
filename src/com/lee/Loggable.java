package com.lee;

import java.util.List;

public interface Loggable {

    void userInput(List<? extends Animal> list);

    void logToDataBase();


}
