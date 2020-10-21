package leeLogger;

import java.util.Comparator;

/**
 * Class is used to display all transactions
 * in descending order of cost.
 *
 * Class {@code DisplayAllTransactionsDescendCost} implements Comparator to override the compare method and
 * sort the transactions in descending order of cost
 *
 * @author leefowler
 */

public class DisplayAllTransactionsDescendCost implements Comparator<Transactions>
{

    /**
     * Sorts Transactions in Descending order of cost
     *
     * @param o1 Transaction this is the first transaction to compare
     * @param o2 Transaction this is the second transaction to compare
     * @return int this is the value used to order the two transactions in descending order
     */
    @Override
    public int compare(Transactions o1, Transactions o2) {
        return (int) (o2.getMonetaryValue() - o1.getMonetaryValue());
    }
}


