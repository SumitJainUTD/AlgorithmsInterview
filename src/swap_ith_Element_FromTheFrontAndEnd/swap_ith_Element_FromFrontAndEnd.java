package swap_ith_Element_FromTheFrontAndEnd;

public class swap_ith_Element_FromFrontAndEnd {
	public int len;
	public Node head;

	public swap_ith_Element_FromFrontAndEnd() {
		head = null;
	}

	public static void main(String[] args) throws java.lang.Exception {
		swap_ith_Element_FromFrontAndEnd a = new swap_ith_Element_FromFrontAndEnd();
		a.addAtEnd(10);
		a.addAtEnd(20);
		a.addAtEnd(30);
		a.addAtEnd(40);
		a.addAtEnd(50);
		a.addAtEnd(60);
		a.addAtEnd(70);
		a.display();

		for (int x = 1; x < 9; x++) {

			a.swapNode(x);
			a.display();
		}

	}

	public Node swapNode(int i) {
		len = getLength(head);
		if (i > len) {
			System.out
					.println("\n INVALID NUMBER, No Swapping, k>length of list");
			return null;
		}
		if (2 * i - 1 == len) {
			System.out
					.println("\nk = " + i + ", Nodes are same from front and at the end, no swapping");
			return null; // both are same, No need for swaping
		}
		System.out.println("\nSwapping " + i
				+ " Node from the Front and from the End");
		Node left = head;// move from left i nodes, in case i=1=>left_prev=NULL
		Node left_prev = null;
		int j = i;
		while (j > 1) {
			left_prev = left;
			left = left.next;
			j--;
		}
		// System.out.println("\nleft pointing at " + left.data);

		Node right = head;// move j=(len-i+1) from the start, which means i
							// nodes from the end
		Node right_prev = null;// in case i=len=> right will the first node =>
								// right_prev=NULL
		j = len - i + 1;
		while (j > 1) {
			right_prev = right;
			right = right.next;
			j--;
		}
		// System.out.println("right pointing at " + right.data);
		if (left_prev != null) {// if left_prev!=NUll=>left node is not the
								// first node, so left_prev will point to right
								// node
			left_prev.next = right;
		}

		if (right_prev != null) {// if right_prev!=NUll=>right node is not the
									// first node, so right_prev will point to
									// left node
			right_prev.next = left;
		}

		Node temp = left.next;// now just swap the left.next and right.next to
								// complete
		left.next = right.next;
		right.next = temp;

		if (i == 1)// change the head in case of i=1 or i=len.
			head = right;
		if (i == len)
			head = left;

		return head;

	}

	public int getLength(Node head) {
		Node n = head;
		int count = 0;
		while (n != null) {
			n = n.next;
			count++;
		}
		return count;
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

	public void display() {
		// System.out.println("");
		Node currNode = head;
		while (currNode != null) {
			System.out.print("->" + currNode.data);
			currNode = currNode.next;
		}
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

}
