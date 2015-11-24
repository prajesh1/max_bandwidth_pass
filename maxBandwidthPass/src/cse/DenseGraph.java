package cse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;


public class DenseGraph {
	
	private double[][] adjacencyMatrix ;
	public int V; // Number of vertices
	public DenseGraph(int V)
	{
		this.V= V;
		adjacencyMatrix = new double[this.V][this.V];
		for(int i=0;i<this.V;i++)
		{
			for(int j=0;j<this.V;j++)
				adjacencyMatrix[i][j]=-1;
		}
	
	}


public  DenseGraph(int V, int degree) // Create a graph with V vertices no edges
//This code can create parallel paths 
	{

		this(V);
		
		List<Integer> vertices = new ArrayList<Integer>();//Holds list of integers for random generation
		for(int i=0;i<degree;i++) //Runs degree times
		{
			for(int j=0;j<V;j++)
			vertices.add(j);
			
			while(!vertices.isEmpty())	//This while is written here to avoid self loops
			{
				Random r = new Random();
				int random1 = r.nextInt(vertices.size()); //0 to size-1
				int random2 = r.nextInt(vertices.size());
				
				int u = vertices.get(random1);
				int v = vertices.get(random2);
				
				if(u!=v) // Is this required?? again for self loop
				{
					//System.out.println(u+" and "+v);
					Random w = new Random();
					int weight = w.nextInt(100); // 0 to 99
					addEdge(v,u,weight);
					addEdge(u,v,weight);
					vertices.remove((Integer)u);
					vertices.remove((Integer)v);
				}
			}
			
		}
	}
	
	public void addEdge(int u, int v,int weight)
	{
		adjacencyMatrix[u][v]=weight;
	}
	
	public void showGraph()
	{
		for(int i=0;i<this.V;i++)
		{
			for(int j=0;j<this.V;j++)
			System.out.print(" ");
		}
			
	}
	
	public List<Edge> adjacentEdges(int source)
	{
		List<Edge> edges = new ArrayList<Edge>();
		Edge e;
		for(int i=0;i<this.V;i++)
			if(this.adjacencyMatrix[source][i]!=-1)
				{
				e = new Edge((int)this.adjacencyMatrix[source][i],source,i);
				edges.add(e);
				}
		return edges;
				
	}
	

	
	public List<Edge> allEdges()
	{
		List<Edge> edges = new ArrayList<Edge>();
		Edge e;
		for(int i=0;i<this.V;i++)
			for(int j=0;j<this.V;j++)
			if(this.adjacencyMatrix[i][j]!=-1)
				{
				e = new Edge((int)this.adjacencyMatrix[i][j],i,j);
				edges.add(e);
				}
		return edges;
	}

	public static void main(String[] args) 
	{
		
        DenseGraph G2 = new DenseGraph(5000,1000);
        
        int x=G2.V;
        System.out.println("vertexis"+x);
        
        
  

	}

}

