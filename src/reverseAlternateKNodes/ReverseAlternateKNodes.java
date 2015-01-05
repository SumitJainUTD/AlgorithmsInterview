package reverseAlternateKNodes;

public class ReverseAlternateKNodes {
	public static void main (String[] args) throws java.lang.Exception
	{
		LinkedListT a = new LinkedListT();
		a.addAtEnd(1);a.addAtEnd(2);a.addAtEnd(3);
		a.addAtEnd(4);a.addAtEnd(5);a.addAtEnd(6);
		a.addAtEnd(7);a.addAtEnd(8);a.addAtEnd(9);
		a.addAtEnd(10);a.addAtEnd(11);a.addAtEnd(12);
		System.out.print("Original Link List 1 : ");
		a.display(a.head);
		int k = 2;
		System.out.println("\n Recursion with 2k nodes where k = 2");
		Node n = a.reverseAlter2KNodes(a.head, 2);
		a.display(n);
		LinkedListT b = new LinkedListT();
		b.addAtEnd(2);b.addAtEnd(4);b.addAtEnd(6);
		b.addAtEnd(8);b.addAtEnd(10);b.addAtEnd(12);
		b.addAtEnd(14);b.addAtEnd(16);b.addAtEnd(18);
		b.addAtEnd(20);b.addAtEnd(22);b.addAtEnd(24);
		System.out.print("\nOriginal Link List 2 : ");
		b.display(b.head);
		System.out.println("\n Recursion with k nodes where k=3");
		n = b.reverseAlterKNodes(b.head, 3, true);		
		b.display(n);
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
	public Node head;
	public LinkedListT(){
		head=null;
	}
	public Node reverseAlterKNodes(Node head, int k, Boolean even){
		int x = k;
		Node moving = head;
		Node head_prev = null;
		Node head_next = null;
		if(even){
			while(x>0 && moving!=null){
				head_next = moving.next;
				moving.next = head_prev;
				head_prev = moving;
				moving = head_next;
				x--;
			}
			if(head!=null)
				head.next = reverseAlterKNodes(moving, k, false);
			return head_prev;			
		}
		else{
			Node prev = moving;
			while(x>1 && moving!=null){				
				moving = moving.next;
				x--;
			}
			if(moving!=null){				
				moving.next = reverseAlterKNodes(moving.next, k, true);				
			}
			return prev;
		}
		
	}
	public Node reverseAlter2KNodes(Node head, int k){
		//process 2K nodes at a time
		//reverse till k nodes and set the the pointer to k+1
		int x = k;
		Node moving = head;
		Node head_prev = null;		
		Node head_next = null;
		while(x>0 && moving!=null){
			head_next = moving.next;
			moving.next = head_prev;
			head_prev = moving;
			moving = head_next;
			x--;
		}
		if(head!=null)
		head.next = moving;
		x =k;
		while(x>1 && moving!=null){
			moving = moving.next;
			x--;
		}
		if(moving!=null){
			moving.next = reverseAlter2KNodes(moving.next,k);
		}
		
		return head_prev;		
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
	public void display(Node head){
		Node currNode = head;
		while(currNode!=null){
			System.out.print("->" + currNode.data);
			currNode=currNode.next;
		}		
	}
}

