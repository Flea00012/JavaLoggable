package leeLogger;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryOperationsTest {


    List<Transactions> originalTransactions;
    List<Transactions> readTransactions = new ArrayList<>();

    BinaryOperations unitTestBinary = new BinaryOperations();


    @BeforeEach
    void shouldSaveDataToAFileForTestingBinaryOperations() {

        List<Transactions> originalTransactions = new ArrayList<>();
        originalTransactions.add(new Transactions(true, "12/22/2020", "work", 10000));
        originalTransactions.add(new Transactions(false, "10/10/2020", "shoes", 500));
        originalTransactions.add(new Transactions(true, "08/08/2020", "freelance", 10000));
        originalTransactions.add(new Transactions(false, "07/07/2020", "jacket", 700));

    }

    @Test
    void listOfTransactionsSavedToBinaryFile() {

        List<Transactions> expected = new ArrayList<>();
        List<Transactions> result = new ArrayList<>();
        expected = originalTransactions;

        unitTestBinary.saveBinary(originalTransactions, "Resources/UnitTestData");


        assertEquals(expected,result);
    }

    @Test
    void listOfTransactionsReadFromBinaryFile() {
        readTransactions = (List<Transactions>) unitTestBinary.readBinary("Resources/UnitTestData");
    }

}