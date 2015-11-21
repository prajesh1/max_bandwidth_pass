package cse;

public class Heap
{
	public int position=0;
	int MAX_SIZE=10; //start MAX_SIZE with 10
	 int[] heap = new int[MAX_SIZE];
	
	public void insert(int value)
	{
		position = position+1;
		if(position==MAX_SIZE)
			resize(2*MAX_SIZE);
		heap[position]=value;
	//	System.out.println("insterted at "+position+"value "+value);
		heapify(position);
	}
	public void showHeap() // Just to view the array structure of heap
	{
		for(int i=1;i<position;i++)
			System.out.print(heap[i]+"  ");
		System.out.println("  ");
	}
	public int MAX()
	{
		return heap[1]; //root node
	}
	
	public int delMax()
	{
		//System.out.println("position ius "+position);
		//System.out.println("pos+1="+heap[position+1]);
		int max = this.MAX();
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
		position = position -1;
		if(position < MAX_SIZE/4)
			resize(MAX_SIZE/2); //Reduce the size of array into one-fourth
		heapify(index);
	}
	public void resize(int newSize)
	{
		MAX_SIZE = newSize;
		int[] newArray = new int[newSize];
		for(int i=0;i<position&&i<=newSize;i++)
			newArray[i]=heap[i];
		heap = newArray;
		
	}
	public void heapify(int index)
	{
		int parent = index/2;
		int leftChild = 2*index;
		int rightChild = leftChild+1;
		int largest = index;
		if(heap[parent]<heap[index]&&parent>0)
			{
			swap(parent,index);
			heapify(parent);
			}
		else if(rightChild<=this.position&&heap[index]<heap[rightChild])
		{
			swap(rightChild,index);
			heapify(rightChild);
		}
		else if(leftChild<=this.position&&heap[index]<heap[leftChild])
		{
			swap(leftChild,index);
			heapify(leftChild);
		}
	}
	private void swap(int i, int j)
	{
		int temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}
	
	
	
	Boolean isHeap()
	{
		int[] arr = heap;
		int n = position;
	    // Start from root and go till the last internal
	    // node
	    for (int i=1; i<=(n-2)/2; i++)
	    {
	        // If left child is greater, return false
	        if (arr[2*i] > arr[i])
	                return false;
	 
	        // If right child is greater, return false
	        if (arr[2*i+1] > arr[i])
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
		Heap h = new Heap();
		for(int i=1;i<100;i++)
			{
			h.insert(i+200); //System.out.println(i);
			}
		
	h.showHeap();
	if(h.isHeap())
		System.out.println("Is heap");
	
int max = h.delMax();
System.out.println(max);
	//h.showHeap();
	 max = h.delMax();
	System.out.println(max);
//	h.showHeap();
 max = h.delMax();
	System.out.println(max);
//	h.showHeap();
	h.insert(200);
	System.out.println(h.delMax());
//	h.showHeap();
	
	
	}
	
}
