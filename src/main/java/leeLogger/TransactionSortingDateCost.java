package leeLogger;

import java.util.Comparator;


/**
 * Class is used to display all transactions
 * in natural order based on date and title for
 * the recorded transaction.
 *
 * Class {@code TransactionsSortingDateCost} implements Comparator to override the compare method and
 * sort the transactions in descending order of cost
 *
 * @author leefowler
 */
public class TransactionSortingDateCost implements Comparator< Transactions> {

    /**
     * Method reads transactions a list of and compares these
     * for the purpose of sorting the items in natural order.
     * The order is based on the date and the title for the transaction
     * object.
     *
     * @param transaction1
     * @param transaction2
     * @return
     */
    @Override
    public int compare( Transactions transaction1,  Transactions transaction2) {

        int dateCompare = transaction1.getDateOfTransaction().compareTo(transaction2.getDateOfTransaction());
        int titleCompare = transaction1.getTitle().compareTo(transaction2.getTitle());

        if (dateCompare == 0) {
            return ((titleCompare == 0) ? dateCompare : titleCompare);
        } else {
            return dateCompare;
        }
    }
}
