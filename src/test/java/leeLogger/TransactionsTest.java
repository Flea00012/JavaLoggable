package leeLogger;

//import  Transactions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransactionsTest {

    Transactions test1 = null;
    Transactions test2 = null;
    @BeforeEach
    void makeTranscationObject() {
        test1 = new Transactions(true, "22/12/2020","shirt", 1000.0);
        test2 = new Transactions(true, "22/12/2020","shirt", 2000.0);
    }
    @Test
    void transactionsGetDateOfTransaction() {
        assertEquals("22/12/2020", test1.getDateOfTransaction());
    }
    @Test
    void transactionsGetMonetaryValue() {
        assertEquals(1000.0, test1.getMonetaryValue());
    }
    @Test
    void transactionsGetTitle() {
        assertEquals("shirt", test1.getTitle());
    }
    void shouldEvaluateToFalseWhenSimilarTransactionsHaveDifferentCost(){
//        int result = test1.getMonetaryValue()
//        int expected = 0;
//        assertNotEquals(expected,result);
//        assertNotEquals();
    }


}