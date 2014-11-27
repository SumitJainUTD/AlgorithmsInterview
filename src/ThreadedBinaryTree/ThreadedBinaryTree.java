package ThreadedBinaryTree;

public class ThreadedBinaryTree {

	public static Node root;
	public static boolean directionLeft;
	public static boolean directionRight;

	public ThreadedBinaryTree() {
		root = new Node(Integer.MAX_VALUE);
		root.lBit = 0;
		root.rBit = 1;
		root.left = root.right = root;
	}

	public void insert(int data) {
		Node n = new Node(data);
		if (root == root.left && root.right == root) {
			n.left = root;
			root.left = n;
			n.lBit = root.lBit;
			root.lBit = 1;
			n.right = root;
		} else {
			Node current = root.left;
			while (true) {
				if (current.data > n.data) {
					if (current.lBit == 0) {
						directionLeft = true;
						directionRight = false;
						break;
					} else {
						current = current.left;
					}
				} else {
					if (current.rBit == 0) {
						directionLeft = false;
						directionRight = true;
						break;
					} else {
						current = current.right;
					}
				}
			}
			if (directionLeft) {
				n.left = current.left;
				current.left = n;
				n.lBit = current.lBit;
				current.lBit = 1;
				n.right = current;
			} else if (directionRight) {
				n.right = current.right;
				current.right = n;
				n.rBit = current.rBit;
				current.rBit = 1;
				n.left = current;
			}
		}
	}

	public void inorder() {
		Node current = root.left;
		while (current.lBit == 1) {
			current = current.left;
		}
		while (current != root) {
			System.out.print("  " + current.data);
			current = findNextInorder(current);
		}
	}

	public Node findNextInorder(Node current) {
		if (current.rBit == 0) {
			return current.right;
		}
		current = current.right;
		while (current.lBit != 0) {
			current = current.left;
		}
		return current;
	}
	public static void main(String args[]){
		ThreadedBinaryTree i = new ThreadedBinaryTree();
		i.insert(10);
		i.insert(12);
		i.insert(15);
		i.insert(2);
		i.insert(13);
		i.insert(1);
		i.insert(4);
		i.inorder();
	}
}

class Node {
	int data;
	int lBit;
	int rBit;
	Node left;
	Node right;

	public Node(int data) {
		this.data = data;
	}
}
