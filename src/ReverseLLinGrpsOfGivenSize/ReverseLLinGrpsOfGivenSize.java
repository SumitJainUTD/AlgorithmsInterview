package ReverseLLinGrpsOfGivenSize;

public class ReverseLLinGrpsOfGivenSize {

	public Node reverse(Node head, int k){
		int x = k;
		Node head_next=null;
		Node h = head;
		Node head_prev = null;
		while(h!=null && x>0){
			head_next = h.next;
			h.next = head_prev;
			head_prev = h;
			h = head_next;
			x--;
		}
		if(head_next!=null){
			//System.out.println("\n->" + head_next.data + "   "+ head.data );
			head.next = reverse(head_next,k);
		}
		return head_prev;
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		LinkedListT a = new LinkedListT();
		a.addAtEnd(1);
		a.addAtEnd(2);
		a.addAtEnd(3);
		a.addAtEnd(4);
		a.addAtEnd(5);
		a.addAtEnd(6);
		a.addAtEnd(7);
		a.addAtEnd(8);
		a.addAtEnd(9);
		a.addAtEnd(10);
		a.display(a.head);
		ReverseLLinGrpsOfGivenSize i = new ReverseLLinGrpsOfGivenSize();
		Node n = i.reverse(a.head, 4);
		a.display(n);
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
		System.out.println("");
		Node currNode = head;
		while(currNode!=null){
			System.out.print("->" + currNode.data);
			currNode=currNode.next;
		}
	}
}
