package PrintTopViewofBT;

import java.util.ArrayList;
import java.util.TreeMap;

public class PrintTopViewofBT {
	public static TreeMap<Integer, Integer> ht = new TreeMap<>();;

	public Node topView(Node root, int level) {
		if (root == null)
			return null;
		// System.out.println(level);
		if (ht.containsKey(level)) {

		} else {
			System.out.print(root.data + "   ");
			ht.put(level, root.data);
		}

		Node x = topView(root.left, --level);
		if (x == null) {
			level++;
		}
		return topView(root.right, ++level);

	}

	public static void main(String args[]) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.left.left = new Node(8);
		root.left.left.right = new Node(9);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		PrintTopViewofBT p = new PrintTopViewofBT();
		p.topView(root, 0);
		// p.printResult(ht);

	}
}

class Node {
	int data;
	Node left;
	Node right;

	public Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}