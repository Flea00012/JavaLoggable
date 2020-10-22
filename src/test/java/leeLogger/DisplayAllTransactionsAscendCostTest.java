package leeLogger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class DisplayAllTransactionsAscendCostTest extends DisplayAllTransactionsAscendCost {


    Transactions test1 = null;
    Transactions test2 = null;
    Transactions test3 = null;

    @BeforeEach
    void makeTranscationObjects() {
        test1 = new Transactions(true, "30/12/2020","freelance", 20000.0);
        test2 = new Transactions(false, "01/12/2020","jeans", 1000.0);
        test3 = new Transactions(false, "01/12/2020","jeans", 1000.0);
    }

    @Test
    public void shouldEvaluateToZeroWhenCompareTwoSameTransactions() {
        int result = test2.compareTo(test3);
        int expected = 0;
        assertEquals(expected,result);
    }
    @Test
    public void shouldEvaluateToFalseWhenCompareTwoDifferentTransactionTitles() {
        int result = test1.getTitle().compareTo(test2.getTitle());
        int expected = 0;
        System.out.println("value is :" + result);
        assertNotEquals(expected,result);
    }

    @Test
    public void shouldEvaluateToTrueWhenCompareTwoSimilarTransactionTitles() {
        int result = test2.getTitle().compareTo(test3.getTitle());
        int expected = 0;
        assertEquals(expected,result);
    }

    @Test
    public void shouldEvaluateToTrueWhenCompareTwoSimilarTransactionDates() {
        int result = test2.getDateOfTransaction().compareTo(test3.getDateOfTransaction());
        int expected = 0;
        assertEquals(expected,result);
    }
    @Test
    public void shouldEvaluateToFalseWhenCompareTwoDifferentTransactionDates() {
        int result = test1.getDateOfTransaction().compareTo(test3.getDateOfTransaction());
        int expected = 0;
        assertNotEquals(expected,result);
    }

}