package algorithms;

import edu.princeton.cs.algs4.*;
import utils.*;

public class QuickSort {

	public static void sort(Comparable[] array)
	{
		StdRandom.shuffle(array);
		sort(array, 0, array.length - 1);
	}
	
	private static void sort(Comparable[] a, int lo, int hi)
	{
		if(hi <= lo)	return;
		int j = partition(a, lo, hi);
		sort(a, lo, j - 1);
		sort(a, j + 1, hi);
	}
	
	private static int partition(Comparable[] a, int lo, int hi)
	{
		int i = lo;
		int j = hi + 1;
		
		while(true)
		{
			while(Utils.less(a[++i],a[lo]))	//increase i ptr as long as i is less than partitioning elem
			{
				if(i == hi)	break;
			}
			while(Utils.less(a[lo], a[--j]))	//decrease j ptr as long as j is greater than partitioning elem
			{
				if(j == lo)	break;
			}
			if(i >= j)	break;			//if the ptrs crossed, then we're done
			Utils.exchange(a, i, j);	//if not, exchange the elems at the ptrs
		}
		
		Utils.exchange(a, lo, j);	//swap the partitioning elem with the elem at j (place it in right place)
		return j;					//return new index of the partitioning elem
	}
	
}
