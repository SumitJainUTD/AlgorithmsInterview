package AVLTree;

public class AVLTree {
	public int getBalance(Node n) {
		if (n != null) {
			return (getHeight(n.left) - getHeight(n.right));
		}
		return 0;
	}

	public int getHeight(Node n) {
		if (n != null) {
			return n.height;
		}
		return 0;
	}

	public Node rightRotate(Node y) {
		Node x = y.left;
		Node T2 = x.right;

		// Rotation
		x.right = y;
		y.left = T2;

		// update their heights
		x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
		y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;

		return x;
	}

	public Node leftRotate(Node x) {
		Node y = x.right;
		Node T2 = y.left;

		// Rotation
		y.left = x;
		x.right = T2;

		// update their heights
		x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
		y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;

		return y;
	}

	public Node insert(Node node, int data) {
		if (node == null) {
			return (new Node(data));
		}
		if (node.data > data) {
			node.left = insert(node.left, data);
		} else {
			node.right = insert(node.right, data);
		}
		// update the node height
		node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;

		int balDiff = getBalance(node);

		// Left Rotate
		if (balDiff > 1 && data < node.left.data) {
			return rightRotate(node);
		}

		// Right Rotate
		if (balDiff < -1 && data > node.right.data) {
			return leftRotate(node);
		}

		// Left Right Rotate
		if (balDiff > 1 && data > node.left.data) {
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}

		// Right Left Rotate
		if (balDiff < -1 && data < node.right.data) {
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}

		return node;
	}

	public void inorder(Node root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(" " + root.data);
			inorder(root.right);
		}
	}

	public static void main(String args[]) {
		Node root = null;
		AVLTree i = new AVLTree();
		root = i.insert(root, 4);
		root = i.insert(root, 2);
		root = i.insert(root, 1);
		root = i.insert(root, 5);
		root = i.insert(root, 6);
		root = i.insert(root, 9);
		root = i.insert(root, 14);
		root = i.insert(root, 11);
		root = i.insert(root, 10);
		root = i.insert(root, 20);
		System.out.print("Inorder Traversal of Constructed AVL Tree :");
		i.inorder(root);
		System.out.print("\n New Root of AVL Tree is : " + root.data);
	}
}

class Node {
	int data;
	Node left;
	Node right;
	int height;

	public Node(int data) {
		this.data = data;
		height = 1;
	}
}
