package cse;

public class MaxBandwidthKruskals {
	Edge[] nextEdge;
	Graph maximumSpanningTree;
	Boolean[] visited;
	boolean maxPassfound=false;

	public MaxBandwidthKruskals(Graph G,int source,int destination)
	{
		HeapSort heapSort = new HeapSort();
		for(Edge e:G.allEdges())
			heapSort.insert(e);
		WeightedUnionFind wuf = new WeightedUnionFind(G.V);
		nextEdge = new Edge[G.V];
		maximumSpanningTree = new Graph(G.V);
		while(!heapSort.isEmpty())
		{
			Edge maxEdge = heapSort.delMax();
			if(!wuf.isConnected(maxEdge.getFromVertex(),maxEdge.getToVertex()))
			{
				maximumSpanningTree.addEdge(maxEdge.getFromVertex(),maxEdge.getToVertex(),maxEdge.getWeight());
				maximumSpanningTree.addEdge(maxEdge.getToVertex(),maxEdge.getFromVertex(),maxEdge.getWeight());
			//	System.out.println("T"+maxEdge.getFromVertex()+" "+maxEdge.getToVertex());
				wuf.union(maxEdge.getFromVertex(),maxEdge.getToVertex());
			}
			
		}
		//maximumSpanningTree.showGraph();
		
		if(wuf.isConnected(source,destination))
			calcMaxPath(maximumSpanningTree,source,destination);
		else
			System.out.println("No connected");
				
	}
	
	public void calcMaxPath(Graph mst,int source,int destination)
	{
		visited = new Boolean[mst.V];
		for(int i=0;i<mst.V;i++)
			visited[i]=Boolean.FALSE;
		
			dfsMaxBandWidth(source,destination,Double.POSITIVE_INFINITY);
		
	}
	
	public void dfsMaxBandWidth(int source,int destination, double weight)
	{
		visited[source]=true;
		for(Edge e:maximumSpanningTree.adjacentEdges(source))
			{ //System.out.println("Edges are"+e.getFromVertex()+" and "+e.getToVertex());
			if(!visited[e.getToVertex()]&&!maxPassfound)
			
			{
				
				if(e.getToVertex()==destination)
				{
					System.out.println("Max distance is "+min(weight,e.getWeight()));
					maxPassfound=true;
					return;
				}
				dfsMaxBandWidth(e.getToVertex(),destination,min(weight,e.getWeight()));
			}
			}
				
	}
	
	private double min(double a,double b)
	{
		if(a<b)
			return a;
		else return b;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph G1 = new Graph();
		G1.SparseGraph(6, 2);

		 MaxBandwidthKruskals kk = new MaxBandwidthKruskals(G1,0,4);

	}

}
