package cse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;


public class Graph {
	

	int V; // Number of vertices
	boolean isSparseGraph;
	SparseGraph sparseGraph;
	DenseGraph denseGraph;
	public Graph(int V,boolean isSparseGraph)
	{
		this.V = V;
		this.isSparseGraph = isSparseGraph;
		if(isSparseGraph)
			sparseGraph = new SparseGraph(V);
		else
			denseGraph = new DenseGraph(V);
	}
	
	public Graph()
	{
		
	}

	public  Graph(int V, int degree,boolean isSparseGraph) // Create a graph with V vertices no edges
//This code can create parallel paths 
	{
		this.V = V;
		this.isSparseGraph = isSparseGraph;
		if(isSparseGraph)
			sparseGraph = new SparseGraph(V,degree);
		else
			denseGraph = new DenseGraph(V,degree);
		
	}
	
	public void addEdge(int u, int v,int weight)
	{
		if(this.isSparseGraph)
			sparseGraph.addEdge(u, v, weight);
		else
			denseGraph.addEdge(u, v, weight);
	}
	
	public void showGraph()
	{
		if(isSparseGraph)
			sparseGraph.showGraph();
		else
			denseGraph.showGraph();
		
	}
	
	public List<Edge> allEdges()
	{
		if(this.isSparseGraph)
			return sparseGraph.allEdges();
			else
				return denseGraph.allEdges();
	}
	
	public List<Edge> adjacentEdges(int source)
	{
		if(this.isSparseGraph)
		return sparseGraph.adjacentEdges(source);
		else
			return denseGraph.adjacentEdges(source);
	}

	public static void main(String[] args) 
	{
		
        Graph G1 = new Graph(1000,5,true);
        
        G1.showGraph();
  

	}

}

