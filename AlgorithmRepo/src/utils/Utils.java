package utils;

public class Utils {

	public static void exchange(Comparable[] array, int i, int j){
		Comparable original = array[i];
		array[i] = array[j];
		array[j] = original;
	}
	
	public static boolean less(Comparable a, Comparable b)
	{
		return a.compareTo(b) < 0;
	}

}
