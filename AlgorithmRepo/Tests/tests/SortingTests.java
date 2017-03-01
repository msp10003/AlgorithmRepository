package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import algorithms.*;
import utils.Utils;

public class SortingTests {
	
	final boolean print = true;
	
	@Test
	public void mergeSortReturnsSortedArray()
	{
		Comparable[] array;
		array = new Comparable[]{'M','E','R','G','E','S','O','R','T','E','X','A','M','P','L','E'};
		MergeSort.sort(array);
		assert isSorted(array);
		
		if(print){
			System.out.print("TEST: mergeSortReturnsSortedArray");
			System.out.println("Sorted Array");
			Utils.printArray(array);
		}
	}
	
	@Test
	public void quickSortReturnsSortedArray()
	{
		Comparable[] array;
		array = new Comparable[]{'Q','U','I','C','K','S','O','R','T','E','X','A','M','P','L','E'};
		QuickSort.sort(array);
		assert isSorted(array);
		
		if(print){
			System.out.println("\nTEST: quickSortReturnsArray");
			System.out.println("\nSorted Array");
			Utils.printArray(array);
		}
	}
	
	@Test
	public void priorityQueueMaintainsHeapOrder()
	{
		MaxPriorityQueue<Character> pq = new MaxPriorityQueue<Character>();
		pq.insert('A');
		pq.insert('H');
		pq.insert('Q');
		pq.insert('X');
		pq.insert('C');
		pq.insert('E');
		pq.insert('Z');
		pq.insert('B');
		System.out.println(pq.max());
		pq.delMax();
		System.out.println(pq.max());
		pq.delMax();
		System.out.println(pq.max());
		pq.delMax();
		System.out.println(pq.max());
		pq.delMax();
		System.out.println(pq.max());
		pq.delMax();
		System.out.println(pq.max());
		pq.delMax();
		System.out.println(pq.max());
		pq.delMax();
		
		
		if(print){
			System.out.println("\nTEST: priorityQueueMaintainsHeapOrder");
			System.out.println(pq.max());	
		}
	}
	
	@Test
	public void priorityQueueReturnsMax()
	{
		
	}
	
	private boolean isSorted(Comparable[] a)
	{
		if (a.length <= 1)
		{
			return true;
		}
		for (int i = 1; i <= a.length - 1; i++){
			if(Utils.less(a[i], a[i - 1]))
			{
				return false;
			}
		}
		return true;
	}
	

}
