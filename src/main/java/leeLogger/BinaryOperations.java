package leeLogger;


import java.io.*;

/**
 * Class saves binary data and reads binary data from a .BIN file
 *
 * The {@code BinaryOperations} class takes in the transactions
 * as a list Object and saves the data to directory
 * <b>"Resources/UserData.Bin"</b>. The same file is used for storage
 * and is read when the user re-starts the application.
 *
 * @author leefowler
 */
public class BinaryOperations implements Serializable {


    /**
     * Method reads transactions from a binary file into a list
     * of type Object for use in data operations
     *
     * @throws  IOException                 the file cannot be found or cannot be written to
     * @throws  ClassNotFoundException      the class is not found for the data transfer
     * @return Object                      returns an Object of data that contains list objects to be cast to type Transaction
     * @param fileName The file that is read from
     */
    public static Object readBinary(String fileName){
        Object transactionsList = null;
        try{
            FileInputStream fiStream = new FileInputStream(new File(fileName));
            ObjectInputStream iStream = new ObjectInputStream(fiStream);
            transactionsList= iStream.readObject();
            iStream.close();

            return transactionsList;

        }
        catch(IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
            return transactionsList;

        }
    }

    /**
     * Method saves transactions to a binary file from a list
     * of type Object for use in data operations and storage of
     * data
     *
     * @param   transactionList         a list of type Object that is saved to file
     * @param   fileName                a file name specified for file storage
     * @throws  IOException             if the file cannot be found or created, or the file
     *                                  cannot be opened
     */
    public static void saveBinary(Object transactionList, String fileName){
        try{
            FileOutputStream foStream = new FileOutputStream(fileName);
            ObjectOutputStream oStream = new ObjectOutputStream(foStream);
            oStream.writeObject(transactionList);

            oStream.close();

        }
        catch(IOException e){

            System.out.println(e.getMessage());
        }
    }






}
