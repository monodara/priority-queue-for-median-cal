package util;

import impl.SortedListPQ;

public class MedianFinderUsingSortedList<T> extends AbstractMedianFinder<T> {

    public MedianFinderUsingSortedList() {
        super();
        maxHeap = new SortedListPQ<>((a, b) -> b.compareTo(a));
        minHeap = new SortedListPQ<>((a, b) -> a.compareTo(b));
    }

}
