package swapEverykthNodes;

public class SwapEveryKthNode {	
	public static void main (String[] args) throws java.lang.Exception
	{
		LinkedListT a = new LinkedListT();
		a.addAtBegin(10);
		a.addAtBegin(9);
		a.addAtBegin(8);
		a.addAtBegin(7);
		a.addAtBegin(6);
		a.addAtBegin(5);
		a.addAtBegin(4);
		a.addAtBegin(3);
		a.addAtBegin(2);
		a.addAtBegin(1);
		System.out.print("Original Link List 1 : ");
		a.display(a.head);
		int k = 4;
		Node n = a.reverseNodes(a.head, k);
		System.out.println("\n Swap Every " + k + "th Node : ");
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
	public Node reverseNodes(Node head, int k){
		int x =k;
		Node ptrOne = head;
		Node ptrTwo_prev = head;
		Node ptrTwo = null;
		if(k<2)return head;
		if(ptrOne!=null){
			 ptrTwo = head.next;
		}else return null;
		while((x-2)>0){
			if(ptrTwo!=null){
				ptrTwo_prev = ptrTwo;
				ptrTwo = ptrTwo.next;
				x--;
			}else{
				return head;
			}			
		}
		Node newHead = ptrTwo.next;
		ptrTwo_prev.next=ptrOne;
		ptrTwo.next = ptrOne.next;
		ptrOne.next = reverseNodes(newHead, k);
		return ptrTwo;
	}
	
	public void addAtBegin(int data){
		Node n = new Node(data);
		n.next = head;
		head = n;
	}	
	public void display(Node head){
		Node currNode = head;
		while(currNode!=null){
			System.out.print("->" + currNode.data);
			currNode=currNode.next;
		}		
	}
}

