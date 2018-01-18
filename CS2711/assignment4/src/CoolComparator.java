import java.util.Comparator;

/**
 * Created by Brandon on 2017-02-24. Student I.D.: 201238730
 * Used for creating comparators for priority queues.
 */
public class CoolComparator<E> implements Comparator<E> {

    /**
     * Compares two values to return which comes before the other
     * @param a - first value
     * @param b - second value
     * @return negative, zero, or positive integer to denote whether a is less than, equal to, or greater than b.
     */
    public int compare(E a, E b) {
        return((Comparable<E>) a).compareTo(b);
    }
}
