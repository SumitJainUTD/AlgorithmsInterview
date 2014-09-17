package LinkedListAddtionForwardOrder;

public class LinkedListAddtionForwardOrder {
	public int carry=0;
	public Node newHead = null;
	public Node add(Node h1, Node h2){
		//first we will make sure that both the Linked list has same no of nodes
		// to ensure that we will append 0 in front of shorter list
		int h1Len = getLength(h1);
		int h2Len = getLength(h2);
		if(h1Len>h2Len){
			int diff = h1Len-h2Len;
			while(diff>0){
				Node n = new Node(0);
				n.next = h2;
				h2=n;
				diff--;
			}
		}
		if(h1Len<h2Len){
			int diff = h2Len-h1Len;
			while(diff>0){
				Node n = new Node(0);
				n.next = h1;
				h1=n;
				diff--;
			}
		}
		
		return addBackRecursion(h1, h2);
	}
	public Node addBackRecursion(Node h1, Node h2){
		if(h1==null && h2==null){
			return null;
		}
		addBackRecursion(h1.next, h2.next);
		int a = h1.data + h2.data + carry;
		carry=0;
		//System.out.println(a);
		if(a>=10){
			carry =1;
			a = a%10;
		}
		Node n = new Node(a);
		if(newHead==null){
			newHead =n;
		}else{
			n.next = newHead;
			newHead = n;
		}
		//carry=0;
		return newHead;
	}
	public int getLength(Node head){
		int len=0;
		while(head!=null){
			len++;
			head = head.next;
		}
		return len;
	}
	public void display(Node head){
		Node currNode = head;
		while(currNode!=null){
			System.out.print("->" + currNode.data);
			currNode=currNode.next;
		}		
	}
	public static void main(String args[]){
		LinkedListAddtionForwardOrder l = new LinkedListAddtionForwardOrder();
		Node h1 = new Node(1);
		h1.next= new Node(0);
		h1.next.next = new Node(0);
		h1.next.next.next = new Node(7);
		System.out.print("First Number : ");
		l.display(h1);
		Node h2 = new Node(9);
		h2.next= new Node(3);
		System.out.print("\n Second Number : ");
		l.display(h2);
		Node x = l.add(h1, h2);		
		System.out.print("\n Addition : ");
		l.display(x);
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
