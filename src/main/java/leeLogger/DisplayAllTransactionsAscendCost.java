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
     * @param o1
     * @param o2
     * @return int
     */
    @Override
    public int compare(leeLogger.Transactions o1, leeLogger.Transactions o2) {
        return (int) (o1.getMonetaryValue() - o2.getMonetaryValue());
    }
}
