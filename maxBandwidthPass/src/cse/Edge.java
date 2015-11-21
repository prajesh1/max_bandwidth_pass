package cse;


public class Edge implements Comparable<Edge>{
	private int weight;
	private int fromVertex;
	private int toVertex;
	public Edge(int weight, int fromVertex, int toVertex) {
		super();
		this.weight = weight;
		this.fromVertex = fromVertex;
		this.toVertex = toVertex;
	}
	public int getWeight() {
		return weight;
	}
	public int getFromVertex() {
		return fromVertex;
	}
	public int getToVertex() {
		return toVertex;
	}
	public int compareTo(Edge that) {
		return this.weight-that.weight;
	}

}
