package findLoopInLinkedList;
//Find the Loop
//Take two pointers, both starts from head
//move one pointer with normal speed and another with double speed
//if both pointers meets at some point, we have found the loop
//Now find the loop length
//at the point where both pointers have met, stop one pointer and keep moving the nother one
//when another pointer meets the first pointer, stop. 
//keep counting number of hops, that will your loop length
//Now To break the loop
//move one pointer by the loop length
//now move both pointers with normal speed.
//when secondpointer.next = first pointer, set secondpinter.next=null.
public class FindLoopInLinkedList
{	public LinkedListLoop a;
	public int loopLength;

	public void createLoop(){
		a = new LinkedListLoop();
		a.addAtEnd(10);
		a.addAtEnd(20);
		a.addAtEnd(30);
		a.addAtEnd(40);
		a.addAtEnd(50);
		a.addAtEnd(60);
		a.insertLoop(2);
		a.displayLoop();
	}
	public void findLoop(){
		Node ptrOne =a.head;
		Node ptrTwo =a.head.next.next;
		while(ptrOne!=null){
			if(ptrOne!=ptrTwo){
				ptrOne = ptrOne.next;
				ptrTwo = ptrTwo.next.next;
			}
			else{
				System.out.println("");
				System.out.println("Loop Found--starts at " + ptrOne.data);
				findLoopLength(ptrOne, ptrTwo);
				breakLoop(ptrOne, ptrTwo);
				break;
			}
		}
	}
	public void findLoopLength(Node one, Node two){
		one = one.next;
		loopLength = 1;
		while(one!=two){
			one = one.next;
			loopLength++;
		}
		System.out.println("Loop length is " + loopLength);
	}
	public void breakLoop(Node one, Node two){
		one = one.next;
		while(one.next!=two){
			one = one.next;
		}
		one.next = null;
		System.out.println("Loop breaks");
		a.display();
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		FindLoopInLinkedList  i = new FindLoopInLinkedList();
		i.createLoop();
		i.findLoop();
		
	
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
class LinkedListLoop{
	public Node head;
	public LinkedListLoop(){
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
	public void insertLoop(int index){
		Node endNode = head;
			while(endNode.next!=null){
				//System.out.print("---->" + currNode.data);
				endNode = endNode.next;
			}
		Node indexNode = head;
		while(index!=0){
			indexNode = indexNode.next;
			index--;
		}
		endNode.next = indexNode;
	}
	public void displayLoop(){
		System.out.println("");
		Node currNode = head;
		int cnt = 15;
		while(cnt!=0){
			System.out.print("->" + currNode.data);
			currNode=currNode.next;
			cnt--;
		}
	}
	public void display(){
		System.out.println("");
		Node currNode = head;
		while(currNode!=null){
			System.out.print("->" + currNode.data);
			currNode=currNode.next;
		}
	}
}
