package impl;

import java.util.ArrayList;
import java.util.Comparator;

public class HeapPQ<T> extends AbstractPriorityQueue<T>{
	private ArrayList<T> heap; //an ArrayList to represent the heap;
	private Comparator<T> comparator;
	//constructor
	public HeapPQ() {
		super();
		heap = new ArrayList<>();
	}
	public HeapPQ(Comparator<T> comparator){
		this();
		this.comparator = comparator;
	}
	//setters and getters
	public ArrayList<T> getHeap() {
		return heap;
	}

	public void setHeap(ArrayList<T> heap) {
		this.heap = heap;
	}

	@Override
	public int size() {
		return heap.size();
	}

	@Override
	public boolean insert(T element) {
		if(element == null) throw new NullPointerException();
		heap.add(element); // put the new element add the end of the list
		upHeap(heap.size() - 1);  // upheap the newly added element / find the correct position for it
	    return true;
	}

	@Override
	public T peek() {
		if (heap.isEmpty()) return null;
	    return heap.get(0);
	}

	@Override
	public T poll() {
		if (heap.isEmpty()) return null;
	    T firstEle = heap.get(0);
	    swap(0, heap.size() - 1);              // put the minimum element at the end of the list
	    heap.remove(heap.size() - 1);          // remove it from the list;
	    downHeap(0);                           // then fix new root
	    return firstEle;
	}
	
	//Swap the elements in two positions
	public void swap(int pos1, int pos2) {
		T temp = heap.get(pos1);
	    heap.set(pos1, heap.get(pos2));
	    heap.set(pos2, temp);
	}
	//move the element in a specific position higher if it's greater
	public void downHeap(int position) {
		while(!isLeaf(position)) {//if the element has children
			int leftIndex = leftChild(position);
			int rightIndex = rightChild(position);
			int minIndex = leftIndex;
			if(rightIndex < size() && comparator.compare(heap.get(leftIndex), heap.get(rightIndex)) > 0) {
				minIndex = rightIndex;
			}
			if(comparator.compare(heap.get(minIndex), heap.get(position)) < 0) {
				swap(position, minIndex);
				position = minIndex;
			}else break;
		}
	}
	//move the element in a specific position higher if it's smaller
	public void upHeap(int position) {
		while (position > 0) {   // iterate until reaching root
		      int parentPos = parent(position);
		      if(comparator.compare(heap.get(position), heap.get(parentPos)) > 0) break; // if child's value is greater than parent's value
		      swap(position, parentPos);
		      position = parentPos;  // continue from the parent's position
		    }
	}
	//get the position of the parent of current element
	private int parent(int pos) {
		return (pos - 1) / 2;
	}
	//get the position of the left child of current element
	private int leftChild(int pos) {
		return 2 * pos + 1;
	}
	//get the position of the right child of current element
	private int rightChild(int pos) {
		return 2 * pos + 2;
	}

	private boolean isLeaf(int pos) {
		return pos > size() / 2 - 1;
	}


}
