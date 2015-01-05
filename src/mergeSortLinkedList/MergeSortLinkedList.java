package mergeSortLinkedList;

public class MergeSortLinkedList {
	public Node MergeList(Node a, Node b) {
		Node result = null;
		if (a == null)
			return b;
		if (b == null)
			return a;
		if (a.data > b.data) {
			result = b;
			result.next = MergeList(a, b.next);
		} else {
			result = a;
			result.next = MergeList(a.next, b);
		}
		return result;
	}

	public int getLength(Node a) {
		int count = 0;
		Node h = a;
		while (h != null) {
			count++;
			h = h.next;
		}
		return count;
	}

	public Node mergeSort(Node a) {
		Node oldHead = a;
		// find the length of the linkedlist
		int mid = getLength(a) / 2;
		if (a.next == null)
			return a;
		// set one pointer to the beginning of the list and another at the next
		// element after mid
		while (mid - 1 > 0) {
			oldHead = oldHead.next;
			mid--;
		}
		Node newHead = oldHead.next;// make newHead points to the beginning of
									// the second half of the list
		oldHead.next = null;// break the list
		oldHead = a;// make one pointer points at the beginning of the first
					// half of the list
		Node t1 = mergeSort(oldHead);//make recursive calls 
		Node t2 = mergeSort(newHead);
		return MergeList(t1, t2); // merge the sorted lists
	}
	public void display(Node head) {
		Node currNode = head;
		while (currNode != null) {
			System.out.print("->" + currNode.data);
			currNode = currNode.next;
		}
	}

	public static void main(String args[]) {
		Node a = new Node(9);
		a.next = new Node(3);
		a.next.next = new Node(4);
		a.next.next.next = new Node(2);
		a.next.next.next.next = new Node(5);
		a.next.next.next.next.next = new Node(1);
		MergeSortLinkedList m = new MergeSortLinkedList();
		m.display(a);
		Node x = m.mergeSort(a);
		System.out.println("\n Sorted List: ");
		m.display(x);
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


