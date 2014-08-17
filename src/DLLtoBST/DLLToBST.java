package DLLtoBST;

import reverseDLL.reverseDoublyLinkedList;

public class DLLToBST {
	public static Node head = null;
	public static Node tail = null;
	public static int size = 0;
	public Node root;

	public void add(int data) {
		Node n = new Node(data);
		if (head == null) {
			head = n;
			tail = n;
		} else {
			head.prev = n;
			n.next = head;
			head = n;
		}
		size++;
	}

	public Node dLLtoBST(Node h, int size) {
		root=null;
		if (h != null && size > 0) {
			int mid = size / 2;
			Node current = h;
			while (mid > 0) {
				current = current.next;
				mid--;
			}
			root = current;
			if(root.prev != null){
				root.prev = dLLtoBST(h, size / 2);
			}			
			if (current.next != null) {
				root.next = dLLtoBST(current.next, size / 2);
			} else {
				root.next = null;
			}

		}else{
			return h;
		}
		return root;
	}

	public void inOrder(Node root) {
		if (root != null) {
			inOrder(root.prev);
			System.out.print("  " + root.data);
			inOrder(root.next);
		}
	}

	public void printDLL(Node head) {
		Node curr = head;
		while (curr != null) {
			System.out.print("  " + curr.data);
			curr = curr.next;
		}
		System.out.println();
	}

	public static void main(String args[]) {
		DLLToBST r = new DLLToBST();
//		r.add(9);
//		r.add(8);
//		r.add(7);
//		r.add(6);
//		r.add(5);
//		r.add(4);
		r.add(3);
		r.add(2);
		r.add(1);
		Node h = head;
		r.printDLL(h);
		Node x = r.dLLtoBST(h, size);
		r.inOrder(x);
	}
}

class Node {
	int data;
	Node next;
	Node prev;

	public Node(int data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}
}
