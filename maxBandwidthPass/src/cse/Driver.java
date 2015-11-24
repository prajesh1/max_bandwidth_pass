package cse;

import java.util.Random;

public class Driver {
	
	public static void connectAllVertices(Graph G,int source, int destination)
	{
		Random w = new Random(); //Connects all the vertices
		
		for(int i=0;i<G.V-1;i++)
		{
			int weight = w.nextInt(10000); 
			G.addEdge(i, i+1, weight);
			G.addEdge(i+1, i, weight);
		}
	}

	public static void main(String[] args)
	{
		int num_of_vertices = 5000;
		int degree = 1000;
		boolean adjacencyList = false;
		Graph G1 = new Graph(num_of_vertices,degree,adjacencyList);
		G1.showGraph();
		
		Random r = new Random();
		int source = r.nextInt(num_of_vertices);
		int destination = r.nextInt(num_of_vertices);
		

		connectAllVertices(G1,source,destination);
		
		long startTime;
		long stopTime;
		long elapsedTime;
		
		
		
		System.out.println("Dijkstras");
		
		startTime = System.currentTimeMillis();
		DijkstrasMaxBandWidth f = new DijkstrasMaxBandWidth(G1,source,destination);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("Time taken = "+elapsedTime);
	    
		System.out.println("HeapDijkstras");
		 
		startTime = System.currentTimeMillis();
		HeapDijkstras d = new HeapDijkstras(G1,source,destination);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("Time taken = "+elapsedTime);
		
		System.out.println("Krushkals");
		
		startTime = System.currentTimeMillis();
		MaxBandwidthKruskals dff = new MaxBandwidthKruskals(G1,source,destination);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("Time taken = "+elapsedTime);
		 
	    
	      


	}

}
