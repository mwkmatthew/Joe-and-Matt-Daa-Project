package git;
/*
 * this class just adds the basic functionality of an adjacency list that we would
 * need to make Prim's algorithm of making a Minimum spanning tree work
 * each Vertex in the AL is called by a node that holds the vertex that the index is connected to
 * i.e. index 0 refers to vertex 0 and when adding a new node to the list, we would use the value
 * 1 to refer to it within the node.
 */

public class AdjacencyList
{
	private List[] AL;	
	
	public AdjacencyList(int numVerticies)
	{
		AL = new List[numVerticies];
		fillList();
	}
	
	private void fillList()
	{
		
		for(int i = 0;i< AL.length;i++)
		{
			AL[i] = new List(new Node(i,0));
		}
	}
	public List[] getAdList()
	{
		return AL;
	}
	public Node getVertexatIndex(int index)
	{
		return AL[index].getHead();
	}
	public void addVertex(int index, int value, int weight)
	{
		Node temp = AL[index].getHead();
		while(temp.getNextNode() != null)
		{
			temp = temp.getNextNode();
		}
		Node newNode = new Node(value,weight);
		temp.setNextNode(newNode);
	}
	
	public String toString()
	{
		String result = "";
		Node temp = null;
		for(int i = 0;i < AL.length;i++)
		{
			temp = getVertexatIndex(i);
			while(temp != null)
			{
				result += "V1: " + i + " V2: " + temp.getValue() + " Weight: " + temp.getWeight() + "\n";
				temp = temp.getNextNode();
			}
		}
		return result;
	}
}
