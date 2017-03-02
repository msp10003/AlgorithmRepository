package algorithms;

public class BinarySearchTree<Key extends Comparable<Key>, Value>
{
	private Node root;
	
	public void put(Key key, Value val)
	{
		root = put(root, key, val);
	}
	
	private Node put(Node node, Key key, Value val)
	{
		if(node == null){
			return new Node(key, val);
		}
		int cmp = key.compareTo(node.key);
		if(cmp > 0){
			node.right = put(node.right, key, val);
		}
		else if(cmp > 0){
			node.left = put(node.left, key, val);
		}
		else{
			node.val = val;
		}
		node.setSize(size(node.left)+size(node.right)+1);
		return node;
	}
	
	/**
	 * Will return null if the key does not exist
	 * @param key
	 * @return
	 */
	public Value get(Key key)
	{
		return get(root, key);
	}
	
	private Value get(Node node, Key key)
	{
		if(node == null){
			return null;
		}
		int cmp = key.compareTo(node.key);
		if(cmp > 0){
			return get(node.right, key);
		}
		else if(cmp > 0){
			return get(node.left, key);
		}
		else{
			return node.val;
		}
	}
	
	public void delete(Key key)
	{
		
	}
	
	/**
	 * Lazy implementation that just sets the key's value
	 * to null
	 * @param key
	 */
	public void deleteLazy(Key key)
	{
		put(key, null);
	}
	
	public boolean contains(Key key)
	{
		return get(key) != null;
	}
	
	public boolean isEmpty()
	{
		return size() == 0;
	}
	
	public int size()
	{
		return size(root);
	}
	
	public int size(Node node)
	{
		if(node == null){
			return 0;
		}
		return node.getSize();
	}
	
	/*
	public Iterable<Key> keys()
	{
		
	}
	*/
	private class Node
	{
		private Key key;
		private Value val;
		private Node left, right;
		private int N;
		
		public Node(Key key, Value val)
		{
			this.key = key;
			this.val = val;
			N = 1;
		}
		
		public void setSize(int n)
		{
			this.N = n;
		}
		
		public int getSize()
		{
			return N;
		}
	}
}
