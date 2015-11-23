package cse;

public class WeightedUnionFind {
	private int[] data;
	public void getData() {
		for(int i=0;i<data.length;i++)
		{
			System.out.println("i = "+data[i]);
		}
	}


	private int[] size;
	public WeightedUnionFind(int N) {
		data = new int[N];
		size = new int[N];
		for(int i=0;i<N;i++)
		{
			data[i]=i;
			size[i]=1;
		}
	}
	
	public Boolean isConnected(int i, int j)
	{
		return root(i)==root(j);
	}
	
	private int root(int i)
	{
		while(data[i]!=i)
			i=data[i];
		return i;
	}
	public void union(int i, int j)
	{
		int rootI=root(i);
		int rootJ=root(j);
		if(size[rootI]>size[rootJ])
		{
			data[rootI]=rootJ;
			size[rootJ]=size[rootI]+size[rootJ];			
		}
		else
		{
			data[rootJ]=rootI;
			size[rootI]=size[rootI]+size[rootJ];
			
		}
	}

}
