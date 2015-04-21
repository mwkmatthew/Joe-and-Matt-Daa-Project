package git;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class MST 
{

	 protected static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 private static String checkString = "";
	 private static MinHeap mh;
	 private static AdjacencyList AL;
	 private static Node[] solution;
	 public static void main(String args[])throws IOException
	{
		readInput();
		System.out.println(AL.toString());
		
	}
	//this method reads in the input to form an adjacency list of all the vertices
	//this includes the weights of the edges that form in between the two vertices
	private static void readInput() throws IOException
	{
		
		int numVerticies;
		int numEdges;
		int vertexOne;
		int vertexTwo;
		int weight;
		System.out.println("What is the number of verticies in the graph?");
		checkString = br.readLine();
		numVerticies = Integer.parseInt(checkString);
		System.out.println("What is the number of edges in this graph?");
		checkString = br.readLine();
		AL = new AdjacencyList(numVerticies);
	    mh= new MinHeap(numVerticies);
	    solution = new Node[numVerticies];
		numEdges = Integer.parseInt(checkString);
		
		for(int i = numEdges;i > 0 ; i--)
		{
			vertexOne = Integer.parseInt(br.readLine());
			vertexTwo = Integer.parseInt(br.readLine());
			weight = Integer.parseInt(br.readLine());
			AL.addVertex(vertexOne, vertexTwo, weight);
			
		}
	
	for ( int i = 0;i <numVerticies;i++)
	{
		mh.insert(AL.getVertexatIndex(i));
		AL.getVertexatIndex(i).setWeight(Integer.MAX_VALUE);
	}
	run();
	
	}
private static void run()
{
	while (!mh.isEmpty())
	{
		Node n = (Node) mh.deleteMin();
		System.out.println(" solution order :"+ n.getKey());
		Node j = AL.getVertexatIndex(n.getKey());
		
		
		while (j.getNextNode() !=null)
		{ j= j.getNextNode();
		 
		 if (j.getWeight()<AL.getVertexatIndex(j.getKey()).getWeight())
		 {
			 AL.getVertexatIndex(j.getKey()).setWeight(j.getWeight());
			 mh.BubbleAll();
		 }
			
		}
		
	}
}
	
	
	
	
}
