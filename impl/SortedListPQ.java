package impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


/**
 * PQ implementation using sorted list
 * @param <T>
 */
public class SortedListPQ<T> extends AbstractPriorityQueue<T> {

    /**
     * List to hold the elements
     */
    private final ArrayList<T> list;

    /**
     * comparator to sort the PQ in ascending/descending
     */
    private Comparator<T> comparator;

    /**
     * Default constructor that initialises the list
     */
    public SortedListPQ() {
        super();
        this.list = new ArrayList<>();
    }

    /**
     * This constructor takes the comparator as a parameter and sets the value
     * @param comparator Comparator object to sort the PQ in Ascending/Descending order
     */
    public SortedListPQ(Comparator<T> comparator) {
        this.list = new ArrayList<>();
        this.comparator = comparator;
    }

    /**
     * This method returns the size of the PQ
     * @return size of the PQ
     */
    @Override
    public int size() {
        return list.size();
    }

    /**
     * This method returns a boolean indicating whether the PQ is empty or not
     * @return true/false
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * This method adds the element to PQ. If element is null it throws a NPE exception
     * @param element element to be added to the PQ
     * @return true if insert was success
     */
    @Override
    public boolean insert(T element) {
        if(element == null) throw new NullPointerException("Element cannot be null");
        int index = Collections.binarySearch(list, element, comparator);
        if(index < 0) {
            index = -(index + 1);
        }
        list.add(index, element);
        return true;
    }

    /**
     * Returns the current top element in the PQ
     * @return current top element in the PQ
     */
    @Override
    public T peek() {
        if(list.isEmpty()) {
            throw new IllegalStateException("Priority queue is empty");
        }
       return list.get(0);
    }

    /**
     * This method removes the current top element from the PQ and returns the value
     * @return current top element in the PQ
     */
    @Override
    public T poll() {
        if (list.isEmpty()) {
            throw new IllegalStateException("Priority queue is empty");
        }
        return list.remove(0);
    }
}
