package KthToLastElementofLL;

public class KthToLastElementofLL {

	public int kthByRecursion(Node head, int k){
		if(head==null){
			return 0;
		}
		int i =  kthByRecursion(head.next, k)+1;
		if(i==k){
			System.out.println(head.data);
		}
		return i;
	}
	public int kthByIteration(Node head, int k){
		if(head==null){
			return 0;
		}
		Node curr = head;
		while(k>0){
			curr=curr.next;
			k--;
		}
		Node sec = head;
		while(curr!=null){
			curr = curr.next;
			sec = sec.next;
		}
		int i  = sec.data;
		return i;
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
		n.next.next.next.next = new Node(7);
		n.next.next.next.next.next = new Node(0);
		n.next.next.next.next.next.next = new Node(4);
		System.out.print("Original List : ");
		KthToLastElementofLL rm = new KthToLastElementofLL();
		rm.display(n);		
		System.out.print("\n Recursion::3rd Element from the end is : ");
		rm.kthByRecursion(n, 3);
		System.out.print("\n Iteration::5th Element from the end is : " + rm.kthByIteration(n, 5));
				
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

