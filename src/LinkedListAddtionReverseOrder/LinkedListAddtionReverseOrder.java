package LinkedListAddtionReverseOrder;

public class LinkedListAddtionReverseOrder {
	public Node add(Node h1, Node h2){
		int carry = 0;
		Node newHead = null;
		Node curr=null;
		while(h1!=null && h2!=null){
			int a = h1.data;
			int b = h2.data;
			int total = a+b+carry;
			if(total>=10){
				carry = 1;
				total = total-10;
			}
			if(newHead==null){
				newHead = new Node(total);
				curr = newHead;
			}else{
				Node n = new Node(total);
				curr.next = n;
				curr = curr.next;				
			}
			h1=h1.next;
			h2=h2.next;
		}
		while(h1!=null){
			int x= h1.data + carry;
			Node n = new Node(x);
			curr.next = n;
			curr = curr.next;
			h1=h1.next;
			carry=0;
		}
		while(h2!=null){
			int x= h2.data + carry;
			Node n = new Node(x);
			curr.next = n;
			curr = curr.next;
			h2=h2.next;
			carry=0;
		}
		if(carry>0){
			Node n = new Node(1);
			curr.next = n;
			curr = curr.next;
		}
		return newHead;
	}
	public void display(Node head){
		Node currNode = head;
		while(currNode!=null){
			System.out.print("" + currNode.data);
			currNode=currNode.next;
		}
	}
	public void displayReverse(Node head){
		Node currNode = head;
		if(head==null){
			return;
		}
		display(head.next);
		System.out.print(head.data);
	}
	public static void main(String args[]){
		LinkedListAddtionReverseOrder l = new LinkedListAddtionReverseOrder();
		Node h1 = new Node(5);
		h1.next= new Node(9);
		h1.next.next = new Node(5);
		h1.next.next.next = new Node(7);
		System.out.print("First Number in REVERSE order: ");
		l.display(h1);
		Node h2 = new Node(5);
		h2.next= new Node(9);
		System.out.print("\n Second Number in REVERSE order : ");
		l.display(h2);
		Node x = l.add(h2, h1);		
		System.out.print("\n Addition in REVERSE order : ");
		l.display(x);
		System.out.print("\n Actual Result in FORWARD ORDER  : ");
		l.displayReverse(x);
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
