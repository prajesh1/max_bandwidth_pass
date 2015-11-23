package cse;

public class Heap
{
	public int position=0;
	int MAX_SIZE=10; //start MAX_SIZE with 10
	 Vertex[] heap = new Vertex[MAX_SIZE];
	
	public void insert(Vertex e)
	{
		position = position+1;
		if(position>=MAX_SIZE-1)
			resize(2*MAX_SIZE);
		heap[position]=e;
	//	System.out.println("insterted at "+position+"value "+value);
		heapify(position);
	}
	public void showHeap() // Just to view the array structure of heap
	{
		for(int i=1;i<position;i++)
			System.out.print(heap[i]+"  ");
		System.out.println("  ");
	}
	public Vertex MAX()
	{
		return heap[1]; //root node
	}
	
	public Vertex delMax()
	{
		//System.out.println("position ius "+position);
		//System.out.println("pos+1="+heap[position+1]);
		Vertex max = this.MAX();
		this.delete(1);
		
	return max;
	}
	public void delete(int index) //deletion at index
	{
		if(index>this.position+1)
		{
			System.out.println("Index out of bounds");
			return; //index outof bounds
		}
		//	System.out.println(position+"Going to delete "+heap[index]+ heap[position]);
		heap[index]= heap[position]; //value at index is lost
		heap[position]=null;
		position = position -1;
		if(position < MAX_SIZE/4)
			resize(MAX_SIZE/2); //Reduce the size of array into one-fourth
		heapify(index);
	}
	public void resize(int newSize)
	{
		MAX_SIZE = newSize;
		Vertex[] newArray = new Vertex[newSize];
		for(int i=0;i<=position&&i<=newSize;i++)
			newArray[i]=heap[i];
		heap = newArray;
		
	}
	public void heapify(int index)
	{
		int parent = index/2;
		int leftChild = 2*index;
		int rightChild = leftChild+1;
		int largest = index;
		if(parent>0&&heap[parent].getWeight()<heap[index].getWeight())
			{
			swap(parent,index);
			heapify(parent);
			}
		
		if(rightChild<=this.position&&heap[largest].getWeight()<heap[rightChild].getWeight())
			largest = rightChild;
		
		if(leftChild<=this.position&&heap[largest].getWeight()<heap[leftChild].getWeight())
			largest = leftChild;
		
		if(largest!=index)
		{
			swap(largest,index);
			heapify(largest);
		}
		
	}
	private void swap(int i, int j)
	{
		Vertex temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}
	
	
	
	Boolean isHeap()
	{
		Vertex[] arr = heap;
		int n = position;
	    // Start from root and go till the last internal
	    // node
	    for (int i=1; i<=(n-2)/2; i++)
	    {
	        // If left child is greater, return false
	        if (arr[2*i].getWeight() > arr[i].getWeight())
	                return false;
	 
	        // If right child is greater, return false
	        if (arr[2*i+1].getWeight() > arr[i].getWeight())
	                return false;
	    }
	    return true;
	}
	public boolean isEmpty()
	{
		if(position==0)
			return true;
		else return false;
	}
	
	public void update_or_insert(int Vertex,double capacity) {
		for(int i=1;i<=this.position;i++)
			if(heap[i].getVertex()==Vertex)
				{
					if(heap[i].getWeight()<capacity)
					heap[i].setWeight((int)capacity);
					return;
				}
		Vertex v = new Vertex(capacity,Vertex);
		this.insert(v);
		
	}

	public static final void main(String[] args)
	{
		Heap h = new Heap();
		for(int i=1;i<100;i++)
			{
			Vertex e = new Vertex(i+200,i);
			h.insert(e); //System.out.println(i);
			}
		
	h.showHeap();
	if(h.isHeap())
		System.out.println("Is heap");
	
Vertex max = h.delMax();
System.out.println(max.getWeight());
	//h.showHeap();
	 max = h.delMax();
	 System.out.println(max.getWeight());
//	h.showHeap();
 max = h.delMax();
 System.out.println(max.getWeight());
//	h.showHeap();
 Vertex x = new Vertex(300,4);
	h.insert(x);
	if(h.isHeap())
		System.out.println("Is heap");
	System.out.println(h.delMax().getWeight());
//	h.showHeap();
	if(h.isHeap())
		System.out.println("Is heap");
	
	
	}

	
}
