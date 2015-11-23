package cse;

public class HeapSort
{
	public int position=0;
	int MAX_SIZE=10; //start MAX_SIZE with 10
	 Edge[] heap = new Edge[MAX_SIZE];
	
	public void insert(Edge e)
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
	public Edge MAX()
	{
		return heap[1]; //root node
	}
	
	public Edge delMax()
	{
		//System.out.println("position ius "+position);
		//System.out.println("pos+1="+heap[position+1]);
		Edge max = this.MAX();
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
		Edge[] newArray = new Edge[newSize];
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
		Edge temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}
	
	
	
	Boolean isHeap()
	{
		Edge[] arr = heap;
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
	


	public static final void main(String[] args)
	{
		HeapSort h = new HeapSort();
		for(int i=1;i<100;i++)
			{
			Edge e = new Edge(i+200,i,i);
			h.insert(e); //System.out.println(i);
			}
		

	
	
	}

	
}
