package RemoveDuplicatesFromLL;

import java.util.Hashtable;

public class RemoveDuplicates {

	public Node removeDup(Node head){
		Hashtable<Integer, Integer> ht = new Hashtable<>();
		if(head==null){
			return null;
		}		
		Node currNode = head.next;
		Node prevNode = head;
		int count =0;
		while(currNode!=null){
			int data = currNode.data;
			if(ht.contains(data)){
				prevNode.next = currNode.next;
				currNode = currNode.next;
			}else{
				ht.put(count, data);
				count++;
				prevNode = currNode;
				currNode = currNode.next;
			}
		} return head;
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
		n.next.next = new Node(2);
		n.next.next.next = new Node(3);
		n.next.next.next.next = new Node(4);
		n.next.next.next.next.next = new Node(4);
		n.next.next.next.next.next.next = new Node(2);
		System.out.print("Original List : ");
		RemoveDuplicates rm = new RemoveDuplicates();
		rm.display(n);		
		System.out.print("\n Updated List: ");
		Node x =rm.removeDup(n);
		rm.display(x);		
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
