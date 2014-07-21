package interviewQuestion;

public class LinkListImplementation {
	public static void main(String[] args) throws java.lang.Exception {
		LinkedListT a = new LinkedListT();
//		a.addAtBegin(5);
//		// a.display();
//		a.addAtBegin(10);
//		// a.display();
//		a.addAtBegin(15);
		a.addAtEnd(20);
//		a.addAtEnd(200);
//		a.display();
//		a.deleteAtBegin();
//		a.display();
//		a.deleteAtEnd();
		a.display();
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

	public void addAtBegin(int data) {
		Node n = new Node(data);
		n.next = head;
		head = n;
	}

	public int deleteAtBegin() {
		int tmp = head.data;
		head = head.next;
		return tmp;
	}

	public void deleteAtEnd() {
		Node currNode = head;
		if (head.next == null) {
			head = null;
		} else {
			while (currNode.next.next != null) {
				currNode = currNode.next;
			}
			int temp = currNode.next.data;
			currNode.next = null;
		}
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
		System.out.println("");
		Node currNode = head;
		while (currNode != null) {
			System.out.print("->" + currNode.data);
			currNode = currNode.next;
		}
	}
}
