package impl;

public abstract class AbstractPriorityQueue<T> implements PQInterface<T>{
	// isEmpty() methods in all implementations are same
	@Override
	public boolean isEmpty() { return size() == 0; }
}
