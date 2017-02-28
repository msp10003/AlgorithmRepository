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
	
	public static void resizeArray(Object[] a, int elems){
		if(elems >= a.length/2){
			Object[] t = new Object[a.length*2];
			for(int i = 0; i< elems; i++){
				t[i] = a[i];
			}
		}
		else if(elems <= a.length/4){
			Object[] t = new Object[a.length/2];
			for(int i = 0; i< elems; i++){
				t[i] = a[i];
			}
		}
	}

}
