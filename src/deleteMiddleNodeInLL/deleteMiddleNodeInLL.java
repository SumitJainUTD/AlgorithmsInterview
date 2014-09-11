package deleteMiddleNodeInLL;

public class deleteMiddleNodeInLL {
	
	public void deleteMiddle(Node mid){
		if(mid.next==null){
			return;   // we cant delete the node if it is the last node in the linked list
		}
		Node curr = mid;
		curr.data = curr.next.data;
		curr.next = curr.next.next;		
	}
	public void display(Node head){
		Node n=head;
		while(n!=null){
			System.out.print("->" + n.data);
			n=n.next;
		}
	}
	public static void main(String args[]){
		Node n = new Node(1);
		n.next = new Node(2);
		n.next.next = new Node(8);
		n.next.next.next = new Node(3);
		Node mid = new Node(7);
		n.next.next.next.next = mid; 
		n.next.next.next.next.next = new Node(0);
		n.next.next.next.next.next.next = new Node(4);
		System.out.print("Original List : ");
		deleteMiddleNodeInLL rm = new deleteMiddleNodeInLL();
		rm.display(n);		
		System.out.print("\n Aftter Deleting the mid node (say 7) : ");
		rm.deleteMiddle(mid);
		rm.display(n);
	}
}
class Node{
	int data;
	Node next;
	public Node(int data){
		this.data = data;
		next = null;
	}
}

