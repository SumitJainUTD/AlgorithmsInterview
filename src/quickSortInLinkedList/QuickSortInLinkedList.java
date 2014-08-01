package quickSortInLinkedList;


public class QuickSortInLinkedList {
	public Node getEndNode(Node head){
		Node h = head;
		while(h.next!=null){
			h = h.next;	
		} 
		return h;
	}
	public Node quickSort(Node head, Node tail){
		//System.out.println("coming head" + head.data + " coming tail " + tail.data);
		new LinkedListT().display(head);
		Node pivot = tail; //making last node as 
		Node start = head;
		Node pivot_prev = null;
		Node newHead = null;
		Node start_prev = null;
		Node Temp = null;
		if(head.next == null) return head;
		 while(start.next!=pivot){
		 		start = start.next;
		 }
		pivot_prev = start;
		start = head;
		while(start!=pivot){			
			if(start.data>pivot.data){
				if(start_prev!=null){
					start_prev.next = start.next;
				}
				Temp = start;
				start = start.next;
				head = start;
				Temp.next = pivot.next;
				pivot.next = Temp;
			}else{
				if(newHead==null)newHead = start;
				start_prev = start;
				start = start.next;
			}
		}
		if(newHead!=null)
		System.out.println("New Head" +  newHead.data );
		if(start_prev!=null)
		start_prev.next = null;
		Node rightHead = pivot.next;
		
		// start_prev.next = null;
		// Node pivot_prev = quickSort(head,getEndNode(head));
		// pivot_prev.next = pivot;
		// pivot.next = quickSort(pivot.next,getEndNode(pivot.next));
//			 System.out.println(start_prev.data);
//			 //Ideone i = new Ideone();
			 System.out.println("XXX" +  pivot.data ); 
			Node tmp = quickSort(newHead,start_prev);
			
			while(tmp.next!=null){
				tmp=tmp.next;
			}
			tmp.next = pivot;
			
			pivot.next = quickSort(rightHead,getEndNode(rightHead));
			new LinkedListT().display(newHead);
		return newHead;
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		LinkedListT a = new LinkedListT();
		a.addAtEnd(3);a.addAtEnd(6);a.addAtEnd(17);a.addAtEnd(7);
		a.addAtEnd(4);a.addAtEnd(11);a.addAtEnd(1);a.addAtEnd(2);
		a.addAtEnd(15);a.addAtEnd(10);a.addAtEnd(8);a.addAtEnd(9);//a.addAtEnd(100);
		a.display(a.head);
		QuickSortInLinkedList i = new QuickSortInLinkedList();
		Node x = i.quickSort(a.head, i.getEndNode(a.head));
		a.display(x);
		//  System.out.println("XXX");
		// Node x = null;
		// a.test(x);
		//  System.out.println(x.data);
		
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
	public void test(Node n){
		n = new Node(5) ;
		System.out.println(n.data);
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
