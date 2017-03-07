package algorithms;

public class DepthFirstPaths 
{
	private int s;
	private boolean[] marked;
	private int[] edgeTo;
	
	public DepthFirstPaths(Graph G, int s)
	{
		this.marked = new boolean[G.V()];
		this.edgeTo = new int[G.V()];
		this.s = s;
		dfs(G, this.s);
	}
	
	public void dfs(Graph G, int v)
	{
		marked[v] = true;
		for(int w : G.adj(v))
		{
			if(marked[w]==false){
				dfs(G, w);
				edgeTo[w] = v;
			}
		}
	}
	
	private boolean hasPath(int v)
	{
		return marked[v];
	}
	
	public Iterable<Integer> pathTo(int v)
	{
		if(!hasPath(v)) return null;
		
	}
}
