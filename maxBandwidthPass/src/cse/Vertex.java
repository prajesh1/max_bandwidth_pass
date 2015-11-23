package cse;


public class Vertex{
	private int weight;
	private int Vertex;

	public Vertex(int weight, int fromVertex) {
		super();
		this.weight = weight;
		this.Vertex = Vertex;
		
	}
	public Vertex(double d, int source) {
		this.weight = (int)d;
		this.Vertex = source;
	}
	public int getWeight() {
		return weight;
	}
	public int getVertex() {
		return Vertex;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}

}
