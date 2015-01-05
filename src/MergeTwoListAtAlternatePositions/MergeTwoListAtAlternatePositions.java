package MergeTwoListAtAlternatePositions;

public class MergeTwoListAtAlternatePositions {
	public static void main(String[] args) throws java.lang.Exception {
		Node a = new Node(5);
		a.next = new Node(10);
		a.next.next = new Node(15);
		a.next.next.next = new Node(20);
		a.next.next.next.next = new Node(25);
		MergeTwoListAtAlternatePositions i = new MergeTwoListAtAlternatePositions();
		i.display(a);
		System.out.println("");
		Node b = new Node(3);
		b.next = new Node(6);
		b.next.next = new Node(9);
		b.next.next.next = new Node(12);
		b.next.next.next.next = new Node(15);
		b.next.next.next.next.next = new Node(18);
		i.display(b);
		i.alterMerge(a, b);
	}

	public void display(Node head) {
		Node currNode = head;
		while (currNode != null) {
			System.out.print("->" + currNode.data);
			currNode = currNode.next;
		}
	}

	public void alterMerge(Node a, Node b) {
		Node temp = a;// it will be needed to get the head of the new list
		while (a != null && b != null) {
			Node a1 = a.next;
			Node b1 = b.next;
			a.next = b;
			b.next = a1;
			a = a1;
			b = b1;
		}
		System.out.println("\nAlternate Mergred List");
		display(temp);
		System.out.println("\nRemaining Second List");
		display(b);// b will be pointing to the ahead of the remaining list

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
