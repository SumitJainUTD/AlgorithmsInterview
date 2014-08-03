package swapAlternateElementsOfALinkedList;


public class swapAlternateElementsOfALinkedList {
	public void swapValues(Node x, Node y){
		int tmp = x.data;
		x.data = y.data;
		y.data = tmp;
	}
	
	public void swapIterative(LinkedListT a){
		Node head = a.head;
		
		while(head!=null && head.next!=null ){
			swapValues(head,head.next);
			head=head.next.next;
		}
	}
	public void swapRecursive(Node head){
		if(head!=null && head.next!=null){
			swapValues(head,head.next);
			swapRecursive(head.next.next);
		}
	}

		
	
	public static void main (String[] args) throws java.lang.Exception
	{
		LinkedListT a = new LinkedListT();
		a.addAtEnd(5);a.addAtEnd(10);a.addAtEnd(15);
		a.addAtEnd(20);a.addAtEnd(25);
		a.display();
		swapAlternateElementsOfALinkedList i = new swapAlternateElementsOfALinkedList();
		i.swapIterative(a);
		System.out.println("\n Swapping using Iterative method");
		a.display();
		System.out.println("\n Swapping it again using Recursive method");
		i.swapRecursive(a.head);
		a.display();
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
	public void display(){
		//System.out.println("");
		Node currNode = head;
		while(currNode!=null){
			System.out.print("->" + currNode.data);
			currNode=currNode.next;
		}
	}
}
