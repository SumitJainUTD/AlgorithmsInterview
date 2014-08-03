package MergeTwoListAtAlternatePositions;

public class MergeTwoListAtAlternatePositions {
	public static void main (String[] args) throws java.lang.Exception
	{
		LinkedListT a = new LinkedListT();
		a.addAtEnd(5);a.addAtEnd(10);a.addAtEnd(15);
		a.addAtEnd(20);a.addAtEnd(25);
		a.display();
		LinkedListT b = new LinkedListT();
		b.addAtEnd(3);b.addAtEnd(6);b.addAtEnd(9);
		b.addAtEnd(12);b.addAtEnd(15);b.addAtEnd(18);b.addAtEnd(21);b.addAtEnd(24);
		System.out.println("");
		b.display();
		MergeTwoListAtAlternatePositions i = new MergeTwoListAtAlternatePositions();
		i.alterMerge(a,b);
		System.out.println("\nAlternate Mergred List");
		a.display();
		System.out.println("\nRemaining Second List");
		b.display();
	}
	public void alterMerge(LinkedListT a, LinkedListT b){
		Node a_head = a.head;
		Node b_head = b.head;
		
		while(a_head!=null && b_head!=null){
			Node tmpA = a_head.next; //Save the  pointer to next node
			Node tmpB = b_head;      // save the head of list two
			a_head.next = tmpB;     // let the head of list onw points to head of list two
			b_head = b_head.next;   // let the head of list two points to its next element
			tmpB.next = tmpA;      //  let the prev head of list two points to the inter to next node of list one (A->B->A)
			a_head = tmpA;  //let the head of list two points to its next element A->B->A(now head)
		}
		 b.head = b_head;
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
