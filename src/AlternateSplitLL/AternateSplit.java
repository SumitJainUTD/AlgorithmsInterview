package AlternateSplitLL;

public class AternateSplit {

	public static Node head = null;
	public static Node headA = null;
	public static Node headB = null;

	public void Altersplit() {
		Node currNode = head;
		if (currNode == null || currNode.next == null) {
			return; // we have nothing to split, return
		}
		headA = currNode;
		headB = currNode.next;
		while (currNode != null && currNode.next != null) {

			Node t = currNode.next;
			currNode.next = t.next;
			if (currNode.next != null && currNode.next.next != null) {
				t.next = currNode.next.next;
			} else {
				t.next = null;
				return;
			}
			currNode = currNode.next;
		}

	}

	public void print(Node x) {
		System.out.println("");
		Node curr = x;
		while (curr != null) {
			System.out.print("->" + curr.data);
			curr = curr.next;
		}
	}

	public static void main(String[] args) throws java.lang.Exception {
		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(1);
		head.next.next.next = new Node(2);
		head.next.next.next.next = new Node(1);
		head.next.next.next.next.next = new Node(2);

		AternateSplit i = new AternateSplit();
		i.print(head);
		i.Altersplit();
		i.print(headA);
		i.print(headB);

	}
}

class Node {
	int data;
	Node next;

	public Node(int data) {
		this.data = data;
		next = null;
	}
}