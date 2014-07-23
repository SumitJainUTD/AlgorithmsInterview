package interviewQuestion;
//WithOut Recursion
//create a new node say result
//navigate through both the linked lists at the same time, starting from head
//compare the first node values of both the linked lists
//which ever is smaller, add it to the result node
//move the head pointer of the linked list whose value was smaller
//again compare the node values
//keep doing until one list gets over
//copy the rest of the nodes of unfinished list to the result 
public class MergeTwoLinkList {	
	private LinkedListT a;
	private LinkedListT b;	
	
	public MergeTwoLinkList(LinkedListT a, LinkedListT b){
		this.a=a;
		this.b=b;
	}
	public LinkedListT mergeWithOutRecur(){
		LinkedListT result = new LinkedListT();
		while(a.head!=null && b.head!=null){
//			System.out.println(a.head.data + " " + b.head.data);
			if(a.head.data<b.head.data){
				result.addAtEnd(a.head.data);
				a.head = a.head.next;
			}
			else{
				result.addAtEnd(b.head.data);
				b.head = b.head.next;
			}
		}
		while(a.head!=null){
			result.addAtEnd(a.head.data);
			a.head = a.head.next;
		}
		while(b.head!=null){
			result.addAtEnd(b.head.data);
			b.head = b.head.next;
		}
		return result;
	}
	public Node recurrsionMerge(Node nA, Node nB){
		//base case
		Node result = null;
		if(nA==null) return nB;
		else if(nB==null) return nA;
		if(nA.data<nB.data){
			result = nA;			
			result.next = recurrsionMerge(nA.next, nB);
		}
		else{
			result = nB;
			result.next = recurrsionMerge(nA, nB.next);
		}
		return result;
	}
	public void display(Node head) {
		System.out.println("");
		Node currNode = head;
		while (currNode != null) {
			System.out.print("->" + currNode.data);
			currNode = currNode.next;
		}
		System.out.println("");
	}
	public static void main(String [] args){
		System.out.println("Method : with Recurrsion");
		LinkedListT a = new LinkedListT();
		a.addAtBegin(8);a.addAtBegin(6);a.addAtBegin(5);
		LinkedListT b = new LinkedListT();
		b.addAtBegin(9);b.addAtBegin(7);b.addAtBegin(3);b.addAtBegin(1);
		MergeTwoLinkList m = new MergeTwoLinkList(a, b);
		m.display(a.head);m.display(b.head);
		Node result;
		
		result = m.recurrsionMerge(a.head, b.head);
		m.display(result);
		//method 2	
		System.out.println("Method : without Recurrsion");
		LinkedListT a1 = new LinkedListT();
		a1.addAtBegin(18);a1.addAtBegin(6);a1.addAtBegin(2);
		LinkedListT b1 = new LinkedListT();
		b1.addAtBegin(19);b1.addAtBegin(17);b1.addAtBegin(3);b1.addAtBegin(1);
		MergeTwoLinkList m1 = new MergeTwoLinkList(a1, b1);
		m1.display(a1.head);m1.display(b1.head);
		
		LinkedListT res = m1.mergeWithOutRecur();
		m1.display(res.head);
	}
}
