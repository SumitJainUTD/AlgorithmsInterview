package findIntersectionOfLinkedLists;
//find the length of both the linked lists say : a_len and b_len
//find the lenDiff = (a_len ~ b_len)
//traverse the longer linked list by lenDiff
//Now traverse both the lists at the same time
//check whether nodes are same, if yes then we have found the intersection point
//if we reach the end of the link lists then there is no intersection point.
public class FindIntersectionOfLinkedLists {

	public LinkedListIntersection a;
	public LinkedListIntersection b;
	public void createLists(){
		a = new LinkedListIntersection();
			a.addAtEnd(1);
			a.addAtEnd(10);
			a.addAtEnd(20);
			Node tmp = a.addAtEnd(30);
			a.addAtEnd(40);
			a.addAtEnd(50);
			a.addAtEnd(60);
			System.out.print("List A : ");
			a.display();
		b = new LinkedListIntersection();
			b.addAtEnd(5);
			b.addAtEnd(15);
			b.createIntersection(a,tmp);
			System.out.print("List B : ");
			b.display();
	}
	public void findIntersectionByLength(){
		int a_len=0;
		int b_len=0;
		int lenDiff=0;
		boolean intsctFound = false;
		Node an = a.head;
		Node bn = b.head;
		while(an!=null){
			an=an.next;
			a_len++;
		}
		while(bn!=null){
			bn=bn.next;
			b_len++;
		}
		
		an = a.head;
		bn = b.head;
		if(a_len>b_len){
			lenDiff = a_len-b_len;
		//	System.out.print("length diff " +lenDiff );
			while(lenDiff!=0){
				an = an.next;
				lenDiff--;
			}
		}else{
				lenDiff = b_len-a_len;
			while(lenDiff!=0){
				bn = bn.next;
				lenDiff--;
			}
		}
		while(an!=null && bn!=null){
			//System.out.print(an.data + " " + bn.data);
			if(an==bn) {
				System.out.print("Intersection found at " + an.data);
				intsctFound = true;
				break;
			}
			else{
				an = an.next;	
				bn = bn.next;
			}
		}
		if(intsctFound!=true){
			System.out.print("Intersection Not Found");
		}
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		FindIntersectionOfLinkedLists i = new FindIntersectionOfLinkedLists();
		i.createLists();
		i.findIntersectionByLength();
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
class LinkedListIntersection{
	public Node head;
	public LinkedListIntersection(){
		head=null;
	}
	
	public Node addAtEnd(int data){
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
		return n;
	}
	public void createIntersection(LinkedListIntersection a, Node nd){
		Node hd = a.head; // this is the list to whcih another list will intersect, n our example its list a
		while(hd!=nd){
			hd = hd.next;
		}
		Node currNode = head;// this is for the list which will connect, in our example its list b
			while(currNode.next!=null){
				currNode = currNode.next;
			}
			currNode.next = hd; ;
	}
	public void display(){
		System.out.println("");
		Node currNode = head;
		while(currNode!=null){
			System.out.print("->" + currNode.data);
			currNode=currNode.next;
		}
		System.out.println("");
	}
}