package reverseLinkedList2;

public class reverseLinkedList2 {
	public static Node head=null;
	public Node reverseRecur2(Node current){
		if(current==null){
			return null;
		}
		if(current.next==null){
			head = current;
			return null;
		}
		reverseRecur2(current.next);
		current.next.next = current;
		current.next = null;
		return head;
	}
	public void display(Node head){
		//
		Node currNode = head;
		while(currNode!=null){
			System.out.print("->" + currNode.data);
			currNode=currNode.next;
		}		
	}
	public static void main(String args[]){
		head = new Node(10);
		head.next = new Node(8);
		head.next.next = new Node(6);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(2);
		System.out.println("Original List :");
		reverseLinkedList2 r= new reverseLinkedList2();
		r.display(head);
		System.out.println("\nReversed List :");
		Node x =  r.reverseRecur2(head);
		r.display(x);		
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
