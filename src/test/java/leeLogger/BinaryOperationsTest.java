package leeLogger;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BinaryOperationsTest {

    @BeforeEach
    void makeAFileWithDataForTestingBinaryOperationsClass(){

        List<Transactions> transactions = new ArrayList<>();
        transactions.add(new Transactions(true, "12/22/2020", "work", 10000));
        transactions.add(new Transactions(false, "10/10/2020", "shoes", 500));
        transactions.add(new Transactions(true, "08/08/2020", "freelance",10000));
        transactions.add(new Transactions(false, "07/07/2020", "jacket", 700));

        Object obj = (Object) transactions;
        try{

            FileOutputStream fos = new FileOutputStream("resources/data.BIN");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
//            fos.write(obj);

        }catch(IOException e){
            e.printStackTrace();

        }

    }

    @Test
    void listOfTransactionSavedToBinaryFile() {


    }


    @Test
    void inputByteArrayIntoInputStream() throws IOException{


            try{
                BinaryOperations unit = new BinaryOperations();

                Object trans = new Transactions(true,"12/12/2020", "jeans", 1000);

                ObjectInputStream input = new ObjectInputStream((InputStream) trans);


//                unit.readBinary(transactions);
//
//                assertEquals("123", unit.tokens.get(0));
//                assertEquals("456", unit.tokens.get(1));
//                assertEquals("789", unit.tokens.get(2));
//                assertEquals("123", unit.tokens.get(3));
//                assertEquals("456", unit.tokens.get(4));
//                assertEquals("789", unit.tokens.get(5));
//                }catch(Exception e){

                }catch(Exception e){
                e.printStackTrace();
            }

    }





}