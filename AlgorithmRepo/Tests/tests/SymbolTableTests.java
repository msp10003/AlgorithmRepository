package tests;

import org.junit.Test;

import java.util.Random;

import algorithms.BinarySearchTree;
import algorithms.HashTableSeparateChain;
import algorithms.RedBlackBST;

public class SymbolTableTests {

	@Test
	public void BSTReturnsCorrectValues()
	{
		BinarySearchTree<Character, Integer> bst = new BinarySearchTree<Character, Integer>();
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
		/*
		System.out.println(bst.size());
		
		bst.deleteMin();
		System.out.println(bst.size());
		System.out.println(bst.min().toString());
		bst.delete('S');
		System.out.println(bst.get('S'));
		System.out.println(bst.get('Q'));
		bst.delete('J');
		System.out.println(bst.get('Z'));
		System.out.println(bst.size());*/
	}
	
	
	@Test
	public void RedBlackBSTReturnsCorrectValues()
	{
		RedBlackBST<Character, Integer> bst = new RedBlackBST<Character, Integer>();
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
		/*
		System.out.println(bst.size());
		System.out.println(bst.min().toString());
		System.out.println(bst.get('S'));
		System.out.println(bst.get('Q'));
		System.out.println(bst.get('Z'));*/
	}
	
	@Test
	public void HashTableReturnsCorrectValue()
	{
		HashTableSeparateChain<String, HashTestClass> htable = new HashTableSeparateChain<String, HashTestClass>(100);
		HashTestClass hc = new HashTestClass("sample", 89, 43, true, new Double[]{3.2,4.9,5.6});
		htable.put(hc.getName(), hc);
		hc = new HashTestClass("test", 31, 77, false, new Double[]{9.2,4.0,0.4});
		htable.put(hc.getName(), hc);
		hc = new HashTestClass("source", 99, 1, false, new Double[]{9.7,1.0,11.98});
		htable.put(hc.getName(), hc);
		
		HashTestClass result = htable.get("test");
		System.out.println(result.getName()+" "+result.getValue());
		
		hc = new HashTestClass("sample", 104, 11, true, new Double[]{99.0,4.2,7.9});
		htable.put(hc.getName(), hc);
		
		result = htable.get("sample");
		System.out.println(result.getName()+" "+result.getValue());	
	}
	
	
}
