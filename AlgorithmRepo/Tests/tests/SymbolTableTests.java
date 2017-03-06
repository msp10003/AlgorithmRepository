package tests;

import org.junit.Test;

import java.util.Random;

import algorithms.BinarySearchTree;
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
		
		System.out.println(bst.size());
		System.out.println(bst.min().toString());
		System.out.println(bst.get('S'));
		System.out.println(bst.get('Q'));
		System.out.println(bst.get('Z'));
	}
	
}
