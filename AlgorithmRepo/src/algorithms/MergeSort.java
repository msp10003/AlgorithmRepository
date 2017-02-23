package algorithms;
import edu.princeton.cs.algs4.StdIn;

public class MergeSort {
	
	public static void sort(Comparable[] a)
	{
		Comparable[] aux = new Comparable[a.length];
		sort(a, aux, 0, a.length - 1);
	}
	
	private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi)
	{
		if (hi <= lo)	return;		//if the hi ptr is < lo, we don't want to sort
		
		int mid = lo + (hi - lo) / 2;		//calculate the middle ptr for merge
		sort(a, aux, lo, mid);			//sort the left side
		sort(a, aux, mid + 1, hi);		//sort the right side
		merge(a, aux, lo, mid, hi);		//merge the sorted arrays together
	}
	
	private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi)
	{
		//first need to copy the contents to an auxilary array
		for(int k = lo; k <= hi; k++)
		{
			aux[k] = a[k];
		}
		
		//initialize our pointers
		int i = lo;
		int j = mid + 1;
		
		//loop through the array and merge into the original array 'a'
		for(int k = lo; k <= hi; k++)
		{
			if (i > mid)	//if our low pointer is greater than mid, we've exhausted the left half of the array
			{
				a[k] = aux[j++];	//since we've exhausted the left, take the right
			}
			else if (j > hi)		//if the high pointer is greater than max, we've exhausted the right half of the array
			{
				a[k] = aux[i++];	//since we've exhausted the right, take the left
			}
			else if (less(aux[j], aux[i]))	//the array at j is less than i
			{
				a[k] = aux[j++];
			}
			else
			{
				a[k] = aux[i++];
			}
		}	
	}
	
	private static boolean less(Comparable a, Comparable b)
	{
		return a.compareTo(b) < 0;
	}
	
}
