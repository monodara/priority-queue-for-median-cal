package util;

import impl.HeapPQ;

public class MedianFinderUsingHeap<T> extends AbstractMedianFinder<T>{

	public MedianFinderUsingHeap() {
		super();
		maxHeap = new HeapPQ<>((a,b) -> b.compareTo(a));
		minHeap = new HeapPQ<>((a,b) -> a.compareTo(b));
	}
	
}
