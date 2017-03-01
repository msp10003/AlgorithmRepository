package tests;

import org.junit.Before;
import org.junit.Test;

import utils.Utils;

public class UtilsTests {

	final boolean print = true;
	Comparable[] arr;
	
	@Before
	public void setup(){
		arr = new Comparable[4];
		arr[0] = 4;
		arr[1] = 2;
		arr[2] = 9;
	}
	
	@Test
	public void resizeArrayTest()
	{
		Comparable[] array = Utils.resizeArray(arr, 3);
		
		if(print){
			Utils.printArray(array);
			System.out.println(array.length);
		}
	}
	
	
}
