package main.java.leeLogger;

import java.util.Comparator;

/**
 * Class is used to display all transactions
 * in descending order of cost.
 *
 * Class implements Comparator to override the compare method and
 * sort the transactions in descending order of cost
 *
 * @author leefowler
 */

public class DisplayAllTransactionsDescendCost implements Comparator<Transactions>
{

    /**
     * Sorts Transactions in Descending order of cost
     *
     * @param o1
     * @param o2
     * @return int
     */
    @Override
    public int compare(Transactions o1, Transactions o2) {
        return (int) (o2.getMonetaryValue() - o1.getMonetaryValue());
    }
}


