package leeLogger;

//import  Transactions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransactionsTest {

    Transactions test = null;
    @BeforeEach
    void makeTranscationObject() {
        test = new Transactions(true, "22/12/2020","shirt", 1000.0);
    }
    @Test
    void transactionsGetDateOfTransaction() {
        assertEquals("22/12/2020", test.getDateOfTransaction());
    }
    @Test
    void transactionsGetMonetaryValue() {
        assertEquals(1000.0, test.getMonetaryValue());
    }
    @Test
    void transactionsGetTitle() {
        assertEquals("shirt", test.getTitle());
    }


}