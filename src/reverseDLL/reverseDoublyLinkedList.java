package reverseDLL;

public class reverseDoublyLinkedList {
	public static Node head=null; 
	public static Node tail = null;
	public static int size = 0;

	public Node reverseDLL(){
		Node current = head;
		Node temp = null;
		while(current!=null){
			temp = current.prev;
			current.prev = current.next;
			current.next = temp;
			current = current.prev;
		}
		return temp.prev;
	}
	public void print(Node head){
		Node current = head;
		while(current!=null){
			System.out.print("  " + current.data);
			
			current = current.next;
		}
	}
	
	public void add(int data){
		Node n = new Node(data);
		if(head==null){
			head = n;
			tail = n;
		}else{
			head.prev = n;
			n.next = head;
			head = n;
		}
		size++;
	}
	public static void main(String args[]){
		reverseDoublyLinkedList r = new reverseDoublyLinkedList();
		r.add(1);r.add(2);r.add(3);r.add(4);
		r.print(head);
		Node x = r.reverseDLL();
		System.out.println("");
		r.print(x);
	}
}

class Node{
	int data;
	Node next;
	Node prev;
	public Node(int data){
		this.data =data;
		this.next = null;
		this.prev = null;
	}
}