package cse;

public class MedianMaxBandWidth {

		Edge[] nextEdge;
		Graph maximumSpanningTree;
		Boolean[] visited;
		boolean maxPassfound=false;

		public MedianMaxBandWidth(Graph G,int source,int destination)
		{
			G.allEdges();
		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Graph G1 = new Graph(6,2,true);
			

			MedianMaxBandWidth kk = new MedianMaxBandWidth(G1,0,4);

		}

	}
