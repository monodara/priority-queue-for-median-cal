package impl;

import java.util.PriorityQueue;

public interface PQInterface<T> {
	// Return the number of elements in the queue
	int size();
	
	// Return if there is no element in the queue
	boolean isEmpty();
	
	// Return true if e is not null
	boolean insert(T e);
	
	// Return the first element in the queue
	T peek();
	
	// Remove the first element in the queue and return it
	T poll();
}
