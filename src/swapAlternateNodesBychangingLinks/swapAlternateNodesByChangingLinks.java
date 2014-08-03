package swapAlternateNodesBychangingLinks;

public class swapAlternateNodesByChangingLinks {
	public void swapNodeIterative(LinkedListT a){
		Node head = a.head;
		Node ptrOne_prev = null;
		Node baseHead = null;
		while(head!=null && head.next!=null ){
			Node ptrOne = head;
			Node ptrTwo = head.next;
			Node ptrTwoNext = ptrTwo.next;
			ptrOne.next = ptrTwoNext;
			if(ptrOne_prev!=null){
				ptrOne_prev.next = ptrTwo;
			}
			else{
				baseHead = ptrTwo;
			}
			ptrTwo.next = head;
			ptrOne_prev = ptrOne;
			head = ptrTwoNext;
		}
			a.head =baseHead;
	}
	public Node swapNodeRecursive(Node head){
		if(head==null || head.next==null){
			return head;
		}
			Node ptrOne = head;
			Node ptrTwo = head.next;
			Node ptrTwoNext = ptrTwo.next;
			ptrTwo.next = head;
			Node newhead = ptrTwo;
			ptrOne.next = swapNodeRecursive(ptrTwoNext);
			return newhead;
	}	
	
	public static void main (String[] args) throws java.lang.Exception
	{
		LinkedListT a = new LinkedListT();
		a.addAtEnd(1);a.addAtEnd(2);a.addAtEnd(3);
		a.addAtEnd(4);a.addAtEnd(5);a.addAtEnd(6);a.addAtEnd(7);
		a.display(a.head);
		swapAlternateNodesByChangingLinks i = new swapAlternateNodesByChangingLinks();
		i.swapNodeIterative(a);
		System.out.println("\n Swapping Nodes using Iterative method");
		a.display(a.head);
		System.out.println("\n Swapping again using Recursive method");
		Node n = i.swapNodeRecursive(a.head);
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
		//System.out.println("");
		Node currNode = head;
		while(currNode!=null){
			System.out.print("->" + currNode.data);
			currNode=currNode.next;
		}
	}
}