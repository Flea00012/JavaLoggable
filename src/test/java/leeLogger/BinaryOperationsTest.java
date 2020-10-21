package leeLogger;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryOperationsTest {


    List<Transactions> originalTransactions;
    List<Transactions> readTransactions = new ArrayList<>();

    BinaryOperations unitTestBinary = new BinaryOperations();

    @BeforeEach
    void shouldCreateDataToSaveToFileForTestingBinaryOperations() {

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


        unitTestBinary.saveBinary(originalTransactions, "resources/UnitTestData");

        assertEquals(expected,result);

    }

    @Test
    void listOfTransactionsReadFromBinaryFile() {
        readTransactions = (List<Transactions>) unitTestBinary.readBinary("resources/UnitTestData");
    }
    @Test
    void mustThrowExceptionWhenReadingFromFile() {

    }

    @Test
    public void testForExceptionWhenSavingAFile() {

//        try {
//            unitTestBinary.saveBinary(originalTransactions, "resources/UnitTestData").throwIOException;
//            fail("expected IOException");
//        }catch(IOException e){
//
//        }



//        try {
//            myUnit.throwIllegalArgumentException();
//
//            fail("expected IllegalArgumentException");
//
//        } catch (IllegalArgumentException e) {
//            //ignore, this exception is expected.
//        }
    }

//    @Test(expected = IllegalArgumentException.class)
//    public void testForExceptions1() {
//        BinaryOperations myUnit1 = new BinaryOperations();
//
//        myUnit1.throw IOException();
//    }

    @Test
    public void shouldSaveAndRead() throws IOException {
       BinaryOperations unit = new BinaryOperations();

        byte[] data = "123,456,789,123,456,789".getBytes();

        InputStream input = new ByteArrayInputStream(data);

        unit.saveBinary(input, "resources/UnitTestData");

        assertEquals("123,456,789,123,456,789", unit.readBinary("resources/UnitTestData"));

    }


    @TempDir
    File anotherTempDir;

@Test
void givenFieldWithTempDirectoryFile_whenWriteToFile_thenContentIsCorrect() throws IOException {
    assertTrue("Should be a directory ", this.anotherTempDir.isDirectory());

    File letters = new File(anotherTempDir, "letters.txt");
    List<String> lines = Arrays.asList("x", "y", "z");

    Files.write(letters.toPath(), lines);

    assertAll(
      () -> assertTrue("File should exist", Files.exists(letters.toPath())),
      () -> assertLinesMatch(lines, Files.readAllLines(letters.toPath())));
}
     */

}