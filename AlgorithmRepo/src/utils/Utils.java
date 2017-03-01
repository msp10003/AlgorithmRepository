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
	
	public static Comparable[] resizeArray(Comparable[] a, int elems){
		if(elems >= a.length/2){
			Comparable[] t = new Comparable[a.length*2];
			for(int i = 0; i< elems; i++){
				t[i] = a[i];
			}
			a = t;
		}
		else if(elems <= a.length/4){
			Comparable[] t = new Comparable[a.length/2];
			for(int i = 0; i< elems; i++){
				t[i] = a[i];
			}
			a = t;
		}
		return a;
	}
	
	public static void printArray(Object[] a){
		System.out.println("");
		for (int i = 0; i < a.length; i++)
		{
			System.out.print(a[i]+" ");
		}
		System.out.println("");
	}

}
