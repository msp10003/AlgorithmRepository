package algorithms;

public class BreadthFirstPaths
{
	private int[] edgeTo;
	private int[] distTo;
	private boolean[] marked;
	Graph G;
	int s;
	
	public BreadthFirstPaths(Graph G, int s)
	{
		this.G = G;
		this.s = s;
		bfs();
	}
	
	private void bfs()
	{
		java.util.LinkedList<Integer> vertexQueue = new java.util.LinkedList<Integer>();
		vertexQueue.add(s);
		marked[s] = true;
		int k = 0;
		distTo[s] = k;
		while(!vertexQueue.isEmpty()){
			k++;
			int v = vertexQueue.removeFirst();
			for(int w : G.adj(v)){
				if(!marked[w]){
					vertexQueue.add(w);
					edgeTo[w] = v;
					marked[w] = true;
					distTo[w] = k;
				}
			}
		}
	}
}
