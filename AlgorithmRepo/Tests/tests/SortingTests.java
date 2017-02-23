package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import algorithms.*;

public class SortingTests {
	
	@Test
	public void mergeSortReturnsSortedArray()
	{
		Comparable[] array;
		array = new Comparable[]{'M','E','R','G','E','S','O','R','T','E','X','A','M','P','L','E'};
		MergeSort.sort(array);
		assert isSorted(array);
		System.out.println("Sorted Array\n");
		printArray(array);
	}
	
	@Test
	public void quickSortReturnsSortedArray()
	{
		Comparable[] array;
		array = new Comparable[]{'Q','U','I','C','K','S','O','R','T','E','X','A','M','P','L','E'};
		QuickSort.sort(array);
		assert isSorted(array);
		System.out.println("\nSorted Array");
		printArray(array);
	}
	
	private boolean isSorted(Comparable[] a)
	{
		if (a.length <= 1)
		{
			return true;
		}
		for (int i = 1; i <= a.length - 1; i++){
			if(less(a[i], a[i - 1]))
			{
				return false;
			}
		}
		return true;
	}
	
	private void printArray(Object[] a){
		for (int i = 0; i < a.length; i++)
		{
			System.out.print(a[i]+" ");
		}
	}
	
	private static boolean less(Comparable a, Comparable b)
	{
		boolean result = a.compareTo(b) < 0;
		return result;
	}

}
