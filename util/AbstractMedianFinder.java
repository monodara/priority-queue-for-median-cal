package util;

import impl.AbstractPriorityQueue;

import java.util.Collection;

public class AbstractMedianFinder<T> {
	AbstractPriorityQueue<Double> maxHeap; //store elements in descending order
	AbstractPriorityQueue<Double> minHeap; //store elements in ascending order
    
    public void addElement(Double element) {
      //if no element in the maxHeap
      //or if the new element is "smaller" than the first element in maxHeap
      if(maxHeap.isEmpty() || maxHeap.peek().compareTo(element) >= 0){ 
        maxHeap.insert(element);
      }else{ //if the new element is "greater" than the first element in maxHeap
        minHeap.insert(element);
      }
      //balance the two heaps
      //ensure maxHeap has 0/1 more element than minHeap
      if(maxHeap.size() > minHeap.size() + 1){
        minHeap.insert(maxHeap.poll());
      }
      if(minHeap.size() > maxHeap.size()){
        maxHeap.insert(minHeap.poll());
      }
    }
    
    public double findMedian() {
      if(minHeap.size() == maxHeap.size()){
        return (minHeap.peek() + maxHeap.peek()) / 2; 
      }
      return maxHeap.peek();
    }

    public AbstractPriorityQueue<Double> getMaxHeap() {
        return maxHeap;
    }
}
