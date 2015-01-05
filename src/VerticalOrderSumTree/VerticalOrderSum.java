package VerticalOrderSumTree;

import java.util.Set;
import java.util.TreeMap;

public class VerticalOrderSum {
	public static TreeMap<Integer, Integer> ht = new TreeMap<>();;
	public static int level;

	public Node vertical(Node root, int level) {
		if (root == null) {
			return null;
		}
		Node x = vertical(root.left, --level);
		if (x == null) {
			level++;
		}
		if (ht.get(level) != null) {
			int y = ht.get(level);
			ht.put(level, root.data + y);
		} else {
			ht.put(level, root.data);
		}
		return vertical(root.right, ++level);
	}

	public void printResult(TreeMap ht) {
		// Iterator it = ht.keySet().iterator();
		Set<Integer> i = ht.keySet();
		for (int keys : i) {
			System.out.println("Level " + keys + " Sum : " + ht.get(keys));
		}
	}

	public static void main(String args[]) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		VerticalOrderSum p = new VerticalOrderSum();
		p.vertical(root, 0);
		p.printResult(ht);
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
