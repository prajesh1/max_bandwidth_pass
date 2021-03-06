package cse;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HeapDijkstras {

	Heap Queue = new Heap();
	int[] edgeTo;
	double[] capacity;
	public HeapDijkstras(Graph G,int source, int destination) 
	{
		edgeTo = new int[G.V];
		capacity= new double[G.V];
		
		for(int i=0;i<G.V;i++)
		{
			capacity[i]=Double.NEGATIVE_INFINITY;
			edgeTo[i]= i;
		}
		
		capacity[source] = Double.POSITIVE_INFINITY; // Start with infinite capacity
		Vertex v = new Vertex(capacity[source],source);
		System.out.println("Vertex is "+capacity[source]+source);
		Queue.insert(v);
		while(!Queue.isEmpty())
			relax(G,Queue.delMax());
		
	/*	for(int i =0;i<G.V;i++)
		{
			System.out.println(i+" = "+edgeTo[i]);
		}
		for(int i =0;i<G.V;i++)
		{
			System.out.println(i+" = "+capacity[i]);
		}*/
	System.out.println("Max Capacity between nodes "+source+" and "+destination+" is "+capacity[destination]);
		
		
	}
	

	private void relax(Graph G,Vertex s)
	{
		//System.out.println("inside relax "+s);
		int tt = s.getVertex();
		for(Edge e : G.adjacentEdges(tt))
		{
			
			if(capacity[e.getToVertex()] < min(capacity[s.getVertex()],e.getWeight()))
			{
				
				capacity[e.getToVertex()] = min( capacity[s.getVertex()],e.getWeight());
				//System.out.println("Edge e=" +e.getToVertex()+ " and new capacity = "+capacity[e.getToVertex()]);
				edgeTo[e.getToVertex()] = s.getVertex();
				Queue.update_or_insert(e.getToVertex(),capacity[e.getToVertex()] );
				
			}
		}
	}

	private double min(double a, int b)
	{
		if(a<b)
			return a;
		else return b;
	}

	public static void main(String[] args) 
	{
		}

}

