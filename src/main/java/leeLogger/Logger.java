package leeLogger;


//import leeLogger.Loggable;
//import leeLogger.Transactions;


import java.util.List;


/**
 *  Abstract Class specified in broad outline that a class that extends this class should
 *  log data from a user and store data on a database
 *
 *  The {@code Logger} abstract specifies in broad outline what the functions
 *  are that a class that inherits from the Logger abstract class should be able to perform. These include being able to
 *  log data to a database, and read data from a user. The data is specified as type Transactions in this case
 *  or any of the subclasses of a Transactions parent class.
 *
 *  @author leefowler student at SDA8 (KTH Stockholm)
 */
public abstract class Logger implements Loggable, java.io.Serializable {

    /**
     * the method specifies that the class that inherits this interface should log data to a data from the program
     */
    @Override
    public void logToDataBase() {

    }


    /**
     * the abstract method specifies that class that extend this class should read user data from a list
     *
     * @param list          the list of data that is to be saved to the file
     *
     */
    public abstract void userInput(List<? extends Transactions> list);




}
