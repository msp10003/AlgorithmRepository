package algorithms;

public class RedBlackBST<Key extends Comparable<Key>, Value>
{
	private Node root;
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	
	public void put(Key key, Value val)
	{
		root = put(root, key, val);
		root.color = BLACK;
	}
	
	private Node put(Node node, Key key, Value val)
	{
		//search for the right spot
		if(node == null){
			return new Node(key, val, RED);
		}
		//if we aren't there, go right or left
		int cmp = key.compareTo(node.key);
		if(cmp > 0){
			node.right = put(node.right, key, val);
		}
		else if(cmp < 0){
			node.left = put(node.left, key, val);
		}
		else{
			node.val = val;
		}
		
		//handle the transformation cases
		if(!isRed(node.left) && isRed(node.right)){ node = rotateLeft(node);}
		if(isRed(node.left) && isRed(node.left.left)){ node = rotateRight(node);}
		if(isRed(node.left) && isRed(node.right)){ flipColors(node);}
		
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
		else if(cmp < 0){
			return get(node.left, key);
		}
		else{
			return node.val;
		}
	}

	/**
	 * Hibbard Deletion
	 * @param key
	 */
	public void delete(Key key)
	{
		root = delete(root, key);
	}

	private Node delete(Node node, Key key)
	{
		if(node == null){
			return null;
		}
		//search for the key
		int cmp = key.compareTo(node.key);
		if(cmp > 0){ node.right = delete(node.right, key);}
		else if(cmp < 0){ node.left = delete(node.left, key);}
		//we found the key
		else{
			//case 1: no right child
			if(node.right == null){ return node.left;}
			//case 2: no left child
			if(node.left == null){ return node.right;}
			
			//case 3: two children
			Node t = node;
			node = min(t.right);
			node.right = deleteMin(t.right);
			node.left = t.left;
		}
		//update subtree size
		node.setSize(size(node.left) + size(node.right)+1);
		return node;
	}
	
	public void deleteMin()
	{
		root = deleteMin(root);
	}
	
	private Node deleteMin(Node node)
	{
		if(node.left == null){
			return node.right;
		}
		node.left = deleteMin(node.left);
		node.setSize(size(node.left) + size(node.right)+1);
		return node;
	}
	
	public Key min()
	{
		return min(root).key;
	}
	
	private Node min(Node node)
	{
		if(node.left == null){
			return node;
		}
		return min(node.left);
	}
	
	public Key max()
	{
		return max(root).key;
	}
	
	private Node max(Node node)
	{
		if(node.right == null){
			return node;
		}
		return max(node.right);
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
	
	public boolean isRed(Node node)
	{
		if(node == null){
			return false;
		}
		return node.color == RED;
	}
	
	private Node rotateLeft(Node h)
	{
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		x.color = h.color;
		h.color = RED;
        h.N = size(h.left) + size(h.right) + 1;
		return x;
	}
	
	private Node rotateRight(Node h)
	{
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = h.color;
		h.color = RED;
		h.setSize(size(h.left) + size(h.right)+1);
		return x;
	}
	
	/**
	 * splits temporary 4-node
	 * @param h
	 */
	private void flipColors(Node h)
	{
		h.color = RED;
		h.left.color = BLACK;
		h.right.color = BLACK;
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
		boolean color;
		
		public Node(Key key, Value val)
		{
			this.key = key;
			this.val = val;
			N = 1;
		}
		
		public Node(Key key, Value val, boolean color)
		{
			this.key = key;
			this.val = val;
			N = 1;
			this.color = color;
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
