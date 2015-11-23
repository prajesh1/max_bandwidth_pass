package cse;

import java.util.ArrayList;
import java.util.List;

public class MaxBandwidthKruskals {
	Edge[] nextEdge;
	Graph maximumSpanningTree;

	public MaxBandwidthKruskals(Graph G,int source,int destination)
	{
		HeapSort heapSort = new HeapSort();
		for(Edge e:G.allEdges())
			heapSort.insert(e);
		WeightedUnionFind wuf = new WeightedUnionFind(G.V);
		nextEdge = new Edge[G.V];
		maximumSpanningTree = new Graph();
		while(!heapSort.isEmpty())
		{
			Edge maxEdge = heapSort.delMax();
			if(!wuf.isConnected(maxEdge.getFromVertex(),maxEdge.getToVertex()))
			{
				nextEdge[maxEdge.getFromVertex()]=maxEdge;
				System.out.println("T"+maxEdge.getFromVertex()+" "+maxEdge.getToVertex());
				wuf.union(maxEdge.getFromVertex(),maxEdge.getToVertex());
			}
			
		}
		double maxWeight=0;
		while(true)
		{
			if(maxWeight<nextEdge[source].getWeight())
				maxWeight=nextEdge[source].getWeight();
			System.out.print(nextEdge[source].getToVertex()+" ");
			if(nextEdge[source].getToVertex()==destination)
				{
					System.out.println("Max Width = "+ maxWeight);
					return;
				}
			else
				source =nextEdge[source].getToVertex();
		}
				
				
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph G1 = new Graph();
		G1.SparseGraph(10, 3);

		 MaxBandwidthKruskals kk = new MaxBandwidthKruskals(G1,0,4);

	}

}
