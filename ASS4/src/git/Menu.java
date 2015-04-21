package git;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu 
{
	 private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 private static int checkString = 0;
	 private static MinHeap MH= new MinHeap(100);

	 public static void main(String args[]) throws IOException
	 {
		 boolean done = false;
		 do
		 {
			 System.out.println("Select from the following menu: "
					 + "\n1. Check if MinHeap is empty."
					 + "\n2. Insert key in MinHeap."
					 + "\n3. Delete min key from MinHeap."
					 + "\n4. Decrease key in MinHeap."
					 + "\n5. Display items in MinHeap in array order."
					 + "\n6. Exit program.");
			 System.out.println("Make your menu selection now: ");
			 
			 checkString = Integer.parseInt(br.readLine());
			 System.out.println(checkString);
			 switch (checkString)
			 {
			 case 1:
			 if(MH.isEmpty()==true)
				 System.out.println("Heap is empty");
			
			 else 
				 System.out.println("Heap is not empty");
				 
			 break;
			 case 2:
				 System.out.println("input Node to insert:");
				 System.out.println("What is the key of the Node?");
				 int v = Integer.parseInt(br.readLine());
				 System.out.println("What is the weight of the Node?");
				 int w = Integer.parseInt(br.readLine());	 
				 MH.insert(new Node (v,w));
					 
				 break;
			 case 3:
				 Node n = (Node) MH.deleteMin();
				 System.out.println("You have removed " + n.toString());
				 break;
			 case 4:
				 System.out.println("What is the index of the Node?");
				 int in = Integer.parseInt(br.readLine());
				 System.out.println("What is the new key of the Node?");
				 int nw = Integer.parseInt(br.readLine());
				 Node node = MH.decreaseKey(in,nw);
				 System.out.println(node.toString());
				 break;
			 case 5:
				 System.out.println(MH.DisplayArray());
				 break;
			 case 6: 
				 done = true;
				 
			 }//end switch
			 
		 }
		 while(done != true);
	 }
}	




