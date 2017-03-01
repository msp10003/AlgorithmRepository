package algorithms;

import utils.Utils;

public class MaxPriorityQueue<Key extends Comparable<Key>>{
	private Key[] pq;
	int N;
	
	public MaxPriorityQueue(){
		N = 0;
		pq = (Key[]) new Comparable[2];
	}
	
	public MaxPriorityQueue(int max){
		
	}
	
	public void insert(Key v)
	{
		N++;
		pq = (Key[]) Utils.resizeArray(pq, N+1);
		pq[N] = v;
		swim(N);
	}
	
	public Key max()
	{
		return pq[1];
	}
	
	public Key delMax()
	{
		Key max = pq[1];
		pq[1]= pq[N];
		pq[N] = null;
		N--;
		sink();
		pq = (Key[]) Utils.resizeArray(pq, N+1);
		return max;
	}
	
	public boolean isEmpty()
	{
		return N == 0;
	}
	
	public int size()
	{
		return N;
	}
	
	private void sink()
	{
		int k = 1;
		
		while(2*k <= N){
			int j = 2*k;
			//if j was >= N, it's the last key, so don't look for sibling
			if (j <N && less(j, j+1)) j++;
			//if k ain't less than j, just stop
			if (!less(k, j)) break;
			exch(k, j);
			k = j;
		}
	}
	
	private void swim(int k)
	{
		while(k > 1 && less(k/2, k)){
			exch(k/2, k);
			k = k/2;
		}
	}
	
	/*alternative way to do this a swim uses recursion*/
	private void swim_r(int k)
	{
		//base cases
		if(k/2 == 1) return;
		else if (!less(k/2, k)) return;
		
		exch(k/2, k);
		swim(k/2);
	}
	
	
	private boolean less(int i, int j)
	{
		return pq[i].compareTo(pq[j]) < 0;
	}
	
	private void exch(int i, int j)
	{
		Key temp = pq[i];
		pq[i] = pq[j];
		pq[j] = temp;
	}
}
