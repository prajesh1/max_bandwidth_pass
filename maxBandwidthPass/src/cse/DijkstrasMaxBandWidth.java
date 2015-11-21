package cse;

import java.util.ArrayList;
import java.util.List;


public class DijkstrasMaxBandWidth {
	List<Integer> Queue;
	double[] edgeTo;
	double[] capacity;
	public DijkstrasMaxBandWidth(Graph G,int source, int destination) 
	{
		edgeTo = new double[G.V];
		capacity= new double[G.V];
		
		for(int i=0;i<G.V;i++)
		{
			capacity[i]=Double.NEGATIVE_INFINITY;
			edgeTo[i]= (double)i;
		}
		
		capacity[source] = Double.POSITIVE_INFINITY; // Start with infinite capacity
		Queue = new ArrayList<Integer>();
		Queue.add(source);
		while(!Queue.isEmpty())
			relax(G,max());
		
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
	
	private Integer max()
	{	
		double weight=capacity[Queue.get(0)]; //First element
		int vertex=-1;
		for(int s:Queue)
			if(weight<=capacity[s])
				{weight= capacity[s];
				vertex=s;}
		//System.out.println("removed vertex="+vertex);
		int index = Queue.indexOf(vertex);
		Queue.remove(index);
		return vertex;
	}
	
	private void relax(Graph G,Integer s)
	{
		//System.out.println("inside relax "+s);
		for(Edge e : G.adjacencyList.get(s))
		{
			
			if(capacity[e.getToVertex()] < min(capacity[s],e.getWeight()))
			{
				
				capacity[e.getToVertex()] = min( capacity[s],e.getWeight());
				//System.out.println("Edge e=" +e.getToVertex()+ " and new capacity = "+capacity[e.getToVertex()]);
				edgeTo[e.getToVertex()] = s;
				if(!present(e.getToVertex()))
					Queue.add(e.getToVertex());
			}
		}
	}
	private boolean present(int s)
	{
		for(int a:Queue)
			if(a==s)return true;
		//System.out.println(s+" not present");	
		return false;
	}
	private double min(double a, int b)
	{
		if(a<b)
			return a;
		else return b;
	}

	public static void main(String[] args) 
	{
		Graph G1 = new Graph();
		G1.SparseGraph(18000, 6);
		//G1.showGraph();
		 long startTime = System.currentTimeMillis();

	    
	     
		DijkstrasMaxBandWidth d = new DijkstrasMaxBandWidth(G1,0,1);
		
	      long stopTime = System.currentTimeMillis();
	      long elapsedTime = stopTime - startTime;
	      System.out.println("Time taken = "+elapsedTime);
	}

}

