package cse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;


public class SparseGraph {
	
	HashMap<Integer,List<Edge>> adjacencyList ;
	int V; // Number of vertices
	public SparseGraph(int V)
	{
		this.V= V;
		adjacencyList = new HashMap<Integer,List<Edge>>();
		for(int i=0;i<V;i++)
			adjacencyList.put(i, new ArrayList<Edge>());
		
	}



public  SparseGraph(int V, int degree) // Create a graph with V vertices no edges
//This code can create parallel paths 
	{

		this.V = V;
		adjacencyList = new HashMap<Integer,List<Edge>>();
		for(int i=0;i<V;i++)
			adjacencyList.put(i, new ArrayList<Edge>());
		
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
		//.add(v);

		Edge edge = new Edge(weight,u,v);// weight,from,to
		adjacencyList.get(u).add(edge);
		
	}
	
	public void showGraph()
	{
		for(int i=0;i<this.V;i++)
		{
			System.out.print("Vertex "+i+" : ");
			for(Edge e: adjacencyList.get(i))
				System.out.print("("+e.getToVertex()+","+e.getWeight()+")");
			System.out.println("");
		}
	}
	
	public List<Edge> allEdges()
	{
		List<Edge> alledges = new ArrayList<Edge>();
		
		for(int i=0;i<this.V;i++)
			alledges.addAll(adjacencyList.get(i));
		return alledges;
	}
	
	public List<Edge> adjacentEdges(int source)
	{
		List<Edge> edges = new ArrayList<Edge>();
		for(Edge e: adjacencyList.get(source))
			edges.add(e);
		return edges;
	}

	public static void main(String[] args) 
	{
		
        Graph G1 = new Graph();
       // G1.SparseGraph(5000,6);
        G1.showGraph();
  

	}

}

