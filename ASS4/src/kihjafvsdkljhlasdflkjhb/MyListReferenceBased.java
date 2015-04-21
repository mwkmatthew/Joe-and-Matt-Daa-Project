package kihjafvsdkljhlasdflkjhb;
import git.Node;

/*
 * Purpose: Data Structure and Algorithms Lab 3 Problem 1
 * Status:Complete
 * Last update: 09/16/14
 * Submitted:  09/22/14
 * Comment:
 * @author: Yusef Cardona
 * @version: 2014.09.16
 */
public class MyListReferenceBased implements ListInterface
{

    private Node head;


    public MyListReferenceBased()
    {
        head = null;
    }//end default constructor


    //will run method to run through the list to find if it is emtpty or not
    public boolean isEmpty()
    {
        return this.size() == 0;
    }//end isEmpty

    // goes through the entire list to find the total size of the list
    public int size()
    {
        int size = 0;
        if(head == null)
        {
            return size;
        }
        Node curNode = head;
        for(size = 1; curNode.getNext() != null; size++)
        {
            curNode = curNode.getNext();
        }
        return size;
    }//end size

    //same method as the ListReferenceBased class
    private Node find(int index)
    {
        Node curr = head;
        for(int skip = 0; skip < index; skip++)
        {
            curr = curr.getNext();
        }//end for
        return curr;
    }//end find


    //same method as the ListReferenceBased class
    public Object get(int index) throws ListIndexOutOfBoundsException
    {
        if (index >= 0 && index < this.size())
        {
            // get reference to node, then data in node
            Node curr = find(index);
            Object dataItem = curr.getItem();
            return dataItem;
        }
        else
        {
            throw new ListIndexOutOfBoundsException("List index out of bounds exception on get");
        } // end if
    } // end get

    public void add(int index, Object item) throws ListIndexOutOfBoundsException
    {
        if (index >= 0 && index < this.size() + 1)
        {
            if (index == 0)
            {
                // insert the new node containing item at
                // beginning of list
                Node newNode = new Node(item, head);
                head = newNode;
            }
            else
            {
                Node prev = find(index - 1);
                Node newNode = new Node(item, prev.getNext());
                prev.setNext(newNode);
            }//end inner if
        }//end outer if
        else
        {
            throw new ListIndexOutOfBoundsException("List index out of bounds exception on add");
        }//end else
    }//end add

    public void remove(int index)
    {
        if (index >= 0 && index < this.size())
        {
            if (index == 0)
            {
                // delete the first node from the list
                head = head.getNext();
            }
            else
            {
                Node prev = find(index-1);
                // delete the node after the node that prev
                // references, save reference to node
                Node curr = prev.getNext();
                prev.setNext(curr.getNext());
            } // end if
        } // end if
        else
        {
            throw new ListIndexOutOfBoundsException("List index out of bounds exception on remove");
        } // end if
    }   // end remove

    public void removeAll()
    {
        head = null;
    }//end removeAll

    public String toString()
    {
        int size = this.size();
        Node currItem = head;
        String returnValue = "";
        for(int skip = 0; skip < size ; skip++)
        {

            returnValue += ", " + currItem.getItem();
            currItem = currItem.getNext();

        }//end for
        returnValue += "\nSize of list: " + size;
        return returnValue;
    }//end toString;
}
