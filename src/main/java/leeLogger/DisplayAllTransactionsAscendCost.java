package leeLogger;

import java.util.Comparator;


/**
 * Class is used to display all transactions
 * in ascending order of cost.
 *
 * Class {@code DisplayAllTransactionsAscendCost} implements Comparator to override the compare method and
 * sort the transactions in ascending order of cost
 *
 * @author leefowler
 */
public class DisplayAllTransactionsAscendCost implements Comparator<leeLogger.Transactions>
{
    /**
     * Sorts Transactions in Ascending order of cost
     * @param o1 Transaction this is the first transaction to compare
     * @param o2 Transaction this is the second transaction to compare
     * @return int this is the value used to order the two transactions in descending order
     */
    @Override
    public int compare(Transactions o1, Transactions o2) {
        return (int) (o1.getMonetaryValue() - o2.getMonetaryValue());
    }
}
