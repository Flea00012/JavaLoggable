package leeLogger;

import leeLogger.Transactions;

import java.io.FileNotFoundException;
import java.util.List;


/**
 *  Interface specifies the methods that a Loggable program should have.
 *
 *     The {@code Logger} interface specifies in broad outline what the functions
 *    are that a class that inherits from the Loggable interface should be able to perform. These include being able to
 *    log data to a database, and read data from a user. The data is specified as type Transactions in this case
 *    or any of the subclasses of a Transactions parent class.
 *
 * @author leefowler
 */
public interface Loggable {

    /**
     * method specifies that the class that extends this class should read user data from a list
     *
     * @param list          the list of data that is to be saved to the file
     * @throws FileNotFoundException when the file is not found for the user data to be saved to
     */
    void userInput(List<? extends Transactions> list) throws FileNotFoundException;


    /**
     * the method specifies that the class that inherits this interface should log data to a data from the program
     */
    void logToDataBase();


}
