package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {
	public static void main(String[] args) {
		String county = "Sligo";

		// using heap
		AbstractMedianFinder<Double> mf = new MedianFinderUsingHeap<Double>();
		AbstractMedianFinder<Double> slPQ = new MedianFinderUsingSortedList<>();
		List<String> incomes = readData("incomedataset.csv", county);
		for (int n = 10; n <= 100000; n *= 10) { // iterate over different dataset sizes
			long heapStartTime = System.nanoTime(); // start timer
			for (int i = 0; i < n; i++) { // add n elements
				mf.addElement(Double.parseDouble(incomes.get(i % incomes.size())));
			}
			long heapEndTime = System.nanoTime(); // end timer
			long heapDuration = heapEndTime - heapStartTime; // calculate duration in nanoseconds
			System.out.println("[Heap] The median income of County " + county + " is " + mf.findMedian());
			System.out.println("[Heap]Dataset size: " + n + ", Heap size: " + mf.getMaxHeap().size() + ", Time taken: " + heapDuration + " ns");
		}

		System.out.println();
			// using sorted list
			for (int j = 10; j <= 100000; j *= 10) { // iterate over different dataset sizes
				long listStartTime = System.nanoTime(); // start timer
				for (int i = 0; i < j; i++) {
					slPQ.addElement(Double.parseDouble(incomes.get(i % incomes.size())));
				}
				long listEndTime = System.nanoTime(); // end timer
				long listDuration = listEndTime - listStartTime; // calculate duration in nanoseconds
				System.out.println("[Sorted Array List] The median income of County " + county + " is " + slPQ.findMedian());
				System.out.println("[Sorted Array List]Dataset size: " + j + ", Time taken: " + listDuration + " ns");
			}
			
	}


	//Read the dataset and get a list of incomes of a county
	private static List<String> readData(String fileName, String countyName) {
		String line = "";
		String splitBy = ",";
		List<String> res = new ArrayList<>();
		try {
			//parsing a CSV file into BufferedReader class constructor
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			while ((line = br.readLine()) != null) {   //returns a Boolean value
				String[] workers = line.split(splitBy);    // use comma as separator
				if(workers[5].substring(1, workers[5].length()-1).equals(countyName))
					res.add(workers[7].substring(1, workers[7].length()-1));
			}
		}
		catch (IOException e){
			e.printStackTrace();
		}
		return res;
	}
}
