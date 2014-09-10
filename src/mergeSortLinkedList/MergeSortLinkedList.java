package mergeSortLinkedList;

public class MergeSortLinkedList {
	public Node MergeList(Node a, Node b){
		Node result = null;
		if(a==null)return b;
		if(b==null)return a;
		if(a.data > b.data){
			result = b;
			result.next = MergeList(a, b.next);			
		}else{
			result=a;
			result.next = MergeList(a.next, b);
		}
		return result;
	}
	public int getLength(Node a){
		int count =0;
		Node h = a;
		while(h!=null){
			count++;
			h=h.next;
		}
		return count;
	}
	public Node mergeSort(Node a){
		Node oldHead = a;
		int mid = getLength(a)/2;
		if(a.next==null)return a;
		while(mid-1>0){
			oldHead = oldHead.next;
			mid--;
		}
		Node newHead = oldHead.next;
		oldHead.next = null;
		oldHead = a;		
//		System.out.println(oldHead.data + "   " + newHead.data);
		Node t1 = mergeSort(oldHead);
		Node t2 = mergeSort(newHead);
		return MergeList(t1, t2);
	}
	public static void main(String args[]){
		LinkedListT a = new LinkedListT();
		a.addAtEnd(9);a.addAtEnd(4);a.addAtEnd(2);
		a.addAtEnd(5);a.addAtEnd(1);a.addAtEnd(3);
		MergeSortLinkedList m = new MergeSortLinkedList();
		Node x = m.mergeSort(a.head);
		a.display(x);
	}

}


class Node {
	public int data;
	public Node next;

	public Node(int data) {
		this.data = data;
		this.next = null;
	}
}

class LinkedListT {
	public Node head;

	public LinkedListT() {
		head = null;
	}

	public void addAtEnd(int data) {
		Node n = new Node(data);

		if (head == null) {
			n.next = head;
			head = n;
		} else {
			Node currNode = head;
			while (currNode.next != null) {
				// System.out.print("---->" + currNode.data);
				currNode = currNode.next;
			}
			currNode.next = n;
		}
	}

	public void display(Node head) {
		System.out.println("");
		Node currNode = head;
		while (currNode != null) {
			System.out.print("->" + currNode.data);
			currNode = currNode.next;
		}
	}
}
