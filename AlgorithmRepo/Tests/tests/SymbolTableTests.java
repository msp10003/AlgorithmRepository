package tests;

import org.junit.Test;
import java.util.Random;
import algorithms.BinarySearchTree;

public class SymbolTableTests {

	@Test
	public void BSTReturnsCorrectValues()
	{
		BinarySearchTree<Character, Integer> bst = new BinarySearchTree<Character, Integer>();
		Random rand = new Random();
		bst.put('S', 68);
		bst.put('R', 21);
		bst.put('A', 94);
		bst.put('C', 207);
		bst.put('G', 0);
		bst.put('G', 11);
		bst.put('J', 52);
		bst.put('Z', 76);
		bst.put('P', 30);
		bst.put('E', 108);
		bst.put('N', 1);
		bst.put('I', 7);
		bst.put('Q', 32);
		bst.put('Y', 9);
		
		System.out.println(bst.get('G'));
	}
	
}
