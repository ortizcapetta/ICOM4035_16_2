package testerClasses;

import java.util.ArrayList;
import java.util.Map;

import strategiesClasses.BubbleSort;
import strategiesClasses.HeapSort;
import strategiesClasses.SequentialFD;

public class BubbleSortTester1 {

	public static void main(String[] args) {
		
		ArrayList<Integer> data = TestingUtils.generateListOfIntegers(500); 
		
		TestingUtils.displayListElements("Original Data", data);
		
		BubbleSort<Integer> sorter = new BubbleSort<>(new IntegerComparator2()); 
		//EXERCISE 1: If changed to comparator 2, the results are ordered from smallest to largest
		//this is simply due to the fact that isntead of o1 - o2 it is o2 - o1 
		 

		sorter.sortList(data);
		
		TestingUtils.displayListElements("Sorted", data);
	}

}
