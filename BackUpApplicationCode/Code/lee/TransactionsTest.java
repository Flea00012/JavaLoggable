package com.lee;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionsTest {


    @Test
    void getDateOfTransaction() {
        Transactions test = new Transactions(true, "22/12/2020","jeans", 1000.0);
        assertEquals("22/12/2020", test.getDateOfTransaction());
    }

    @Test
    void getMonetaryValue() {
        Transactions test = new Transactions(true, "22/12/2020","shirt", 1000.0);
        assertEquals(1000.0, test.getMonetaryValue());

    }
}