package git;


public class Node
{
	private int key;
	private int weight;
	private int value;
	private Node nextNode;
	
	public Node(int key,int weight)
	{
		this.key = key;
		this.weight = weight;
		nextNode = null;
	}
	public Node(int key,int weight,int value)
	{
		this.key = key;
		this.weight = weight;
		this.value = value;
		nextNode = null;
	}

	
	public int getKey() {
		return key;
	}


	public void setKey(int key) {
		this.key = key;
	}


	public int getWeight() {
		return weight;
	}


	public void setWeight(int weight) {
		this.weight = weight;
	}


	public int getValue() {
		return value;
	}


	public void setValue(int value) {
		this.value = value;
	}


	public Node getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}
	
	public String toString()
	{
		String result;
		result = "Vertex: " + key + " Weight: " + weight;
		return result;
	}
	
}
