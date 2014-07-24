package swap_ith_Element_FromTheFrontAndEnd;


public class swap_ith_Element_FromFrontAndEnd
{
	public int len;
	public Node head;
	public swap_ith_Element_FromFrontAndEnd(){
		head=null;
	}
	public static void main (String[] args) throws java.lang.Exception	{
		swap_ith_Element_FromFrontAndEnd a = new swap_ith_Element_FromFrontAndEnd();
		a.addAtEnd(10);
		a.addAtEnd(20);
		a.addAtEnd(30);
		a.addAtEnd(40);
		a.addAtEnd(50);
		a.addAtEnd(60);
		a.addAtEnd(70);
		a.display();
		
		for(int x = 1;x<9;x++){
			
			a.swapNode(x);
			a.display();
		 }
		
	}
	
	public Node swapNode(int i){
		len = getLength(head);
		if(i>len){
			System.out.println("\n INVALID NUMBER, No Swapping");
			return null;
		}
		if(2*i-1==len){
			System.out.println("\nNodes are same from front and at the end, no swapping");
			return null ; // both are same, No need for swaping
		}
		System.out.println("\nSwapping "+ i + " Node from the Front and from the End");
		Node left=head;
		Node left_prev = null;
		int j=i;
		while(j>1){
			left_prev = left;
			left = left.next;
			j--;
		}
		//System.out.println("\nleft pointing at " + left.data);
		
		Node right=head;
		Node right_prev = null;
		j= len-i+1;
		while(j>1){
			right_prev = right;
			
			
			right = right.next;
			j--;
		}
		//System.out.println("right pointing at " + right.data);
		
		if(left_prev!=null){
			left_prev.next=right;
		}
		
			if(right_prev!=null){
			right_prev.next=left;
		}
		
		Node temp = left.next;
		left.next = right.next;
		right.next = temp;
		
		if(i==1)
			head = right;
		if(i==len)
			head = left;
			
			
			return head;
		
	}
	
	public int getLength(Node head){
		Node n = head;
		int count=0;
		while(n!=null){
			n= n.next;
			count++;
		}
		return count;
	}
	public void addAtEnd(int data){
		Node n = new Node(data);
		
		if (head==null){
			n.next = head;
			head = n;
		}
		else{
			Node currNode = head;
			while(currNode.next!=null){
				//System.out.print("---->" + currNode.data);
				currNode = currNode.next;
			}
			currNode.next = n;
		}
	}
	public void display(){
		//System.out.println("");
		Node currNode = head;
		while(currNode!=null){
			System.out.print("->" + currNode.data);
			currNode=currNode.next;
		}
	}
}
class Node{
	public int data;
	public Node next;
	public Node(int data){
		this.data = data;
		this.next = null;
	}
}
class LinkedListT{
	
	
}
