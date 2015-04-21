package git;

public class MinHeap
{
	private Node[] minHeap;
    private int numItems;
 
    public void minHeap()
    {
        for (int pos = (numItems / 2); pos >= 1 ; pos--)
        {
            trickleDown(pos);
        }
    }
    
    public MinHeap(int maxsize)
    {
        numItems = 0;
        minHeap = new Node[maxsize + 1];
    }
 //=========================================================
    private int parent(int pos)
    {
        return pos / 2;
    }
 
    private int leftChild(int pos)
    {
        return (2 * pos);
    }
 
    private int rightChild(int pos)
    {
        return (2 * pos) + 1;
    }

    private boolean isLeaf(int pos)
    {
        if (pos >=  (numItems / 2)  &&  pos <= numItems)
        { 
            return true;
        }
        return false;
    }
  //=========================================================
    
    private int swap(int first, int second)
    {
        Node swap;
        swap = minHeap[first];
        minHeap[first] = minHeap[second];
        minHeap[second] = swap;
        return second;
    }//returns the index that the item was placed into
 
    private void trickleDown(int index)
    {
        if (!isLeaf(index))
        { 
            if ( minHeap[index].getWeight() > minHeap[leftChild(index)].getWeight()  
            		|| minHeap[index].getWeight() > minHeap[rightChild(index)].getWeight())
            {
                if (minHeap[leftChild(index)].getWeight() < minHeap[rightChild(index)].getWeight())
                {
                    swap(index, leftChild(index));
                    trickleDown(leftChild(index));
                }else
                {
                    swap(index, rightChild(index));
                    trickleDown(rightChild(index));
                }
            }
        }
    }
 
    public void insert(Node item) 
    {
        minHeap[numItems] = item;
        int current = numItems;
        if(!isEmpty())
        {
        	numItems++;
        	while (minHeap[current].getWeight() < minHeap[parent(current)].getWeight())
        	{
        		swap(current,parent(current));
        		current = parent(current);
        		
        	}
        }
        else
        {
        	minHeap[0] = item;
        	numItems++;
        }
        
    } 
     
     
    public Object deleteMin() throws HeapException
    {// swap the last node in the heap for the first, deleting the first. set the last node to 0, to avoid copying it. decrement size. trickle down.
    	Object item = (Object) minHeap[0];
    	minHeap[0] =minHeap[numItems];
    	minHeap[numItems] = null;
    	
    	numItems--;
    	trickleDown(0);
    	
    	return item;
    }
    private int bubbleUp(int index)
    {
    	while(index>1 && this.minHeap[index].getWeight() < minHeap[parent(index)].getWeight())
    	{
    		swap(index,parent(index));
    		index = parent(index);
    	}
    	return index;
    }
    public void BubbleAll()
    {
    	for (int i = 0;i<numItems;i++)
    	{
    	   bubbleUp(i);
    	}
    }
    
    public Node decreaseKey(int index, int weight) 
    {
    	Node result = null;
    	Node temp = minHeap[index];
    	temp.setWeight(weight);
    	result = minHeap[bubbleUp(index)];
    	return result;
    }//decreases to value the priority of the item in the specified index
    //and returns the index in the array where the item ended up
    
    public boolean isEmpty()
    {
    	if (numItems==0)
    		return true;
    	return false;
    }
    
    public int getValue(int vertex)
    {
    	return minHeap[vertex].getValue();
    }
    
    
	public String DisplayArray()
	{ 
		String rString= "The Array Contains:";
		for (int i=0;i<this.numItems;i++)
		{
			rString =(rString +" "+ minHeap[i] );
		}
		return rString;
	}
	
}
