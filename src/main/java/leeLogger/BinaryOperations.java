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
     * @throws      IOException                 the file cannot be found or cannot be written to
     * @throws      ClassNotFoundException      the class is not found for the data transfer
     */
    public static Object readBinary(){
        try{
            FileInputStream fiStream = new FileInputStream("Resources/UserData");
            ObjectInputStream iStream = new ObjectInputStream(fiStream);
            Object transactionsList= iStream.readObject();
            iStream.close();
            System.err.println("From binary file: " + transactionsList);
            return transactionsList;

        }
        catch(IOException | ClassNotFoundException e){
            return e.getMessage();

        }
    }


    /**
     * Method saves transactions to a binary file from a list
     * of type Object for use in data operations and storage of
     * data
     *
     * @param   transactionList         a list of type Object that is saved to file
     * @throws  IOException             if the file cannot be found or created, or the file
     *                                  cannot be opened
     */
    public static void saveBinary(Object transactionList){
        try{
            FileOutputStream foStream = new FileOutputStream("Resources/UserData");
            ObjectOutputStream oStream = new ObjectOutputStream(foStream);
            oStream.writeObject(transactionList);
            System.err.println("Transactions saved: "+ transactionList);
            oStream.close();

        }
        catch(IOException e){

            System.out.println(e.getMessage());
        }
    }






}
