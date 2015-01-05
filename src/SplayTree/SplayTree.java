package SplayTree;

public class SplayTree {
	public Node rightRotate(Node y) {
		Node x = y.left;
		Node T2 = x.right;

		x.right = y;
		y.left = T2;

		return x;
	}

	public Node leftRotate(Node x) {
		Node y = x.right;
		Node T2 = y.left;

		y.left = x;
		x.right = T2;

		return y;
	}

	public Node search(Node root, int x) {
		Node n;
		if ((n = splay(root, x)) != null) {
			return n;
		}
		return n;
	}
	public Node insert(Node root, int x){
		placeNode(root, x);
		return splay(root, x);
	}

	public Node placeNode(Node root, int x) {
		if (root != null) {
			Node Parent = root;
			if (root.data >= x) {
				if(placeNode(root.left, x)==null){
					Parent.left = new Node(x);
				}
			} else {
				if(placeNode(root.right, x)==null){
					Parent.right = new Node(x);
				}
			}
			return root;
		}
		return null;
	}

	public Node splay(Node root, int data) {
		if (root == null || root.data == data) {
			return root;
		}
		// if data is in left of root
		if (root.data > data) {
			if (root.left == null) {
				return root;
			}
			// check if data is at the root.left.left, Zig-zig case
			if (root.left.data > data) {
				// first bring the node you r searching at root.left.left ,
				// recursively
				if (root.left.left != null) {
					root.left.left = splay(root.left.left, data);
				}

				// now bring the node to the root's left by doing right
				// rotation, One zig is done here
				root = rightRotate(root);
				// Now one right rotation is remaining.

				// check if data is at the root.left.right, Zig-zag case
			} else if (root.left.data < data) {
				// first bring the node you r searching at root.left.right ,
				// recursively
				if (root.left.right != null) {
					root.left.right = splay(root.left.right, data);
				}

				// now bring the node to the root's left by doing left rotation,
				// One zag is done here
				if(root.left!=null)
				root.left = leftRotate(root.left);
				// Now one right rotation is remaining.
			}

			// If we are here that means node which we were searching is on the
			// left of root,
			// do right rotate
			if(root.left!=null) return rightRotate(root);
			return root;
		}

		// if data is in right of root
		else if (root.data < data) {
			// first bring the node you r searching at root.right.right ,
			// recursively
			if (root.right.right != null) {
				root.right.right = splay(root.right.right, data);
			}

			// now bring the node to the root's right by doing left rotation,
			// One zig is done here
			root = leftRotate(root);
			// Now one left rotation is remaining.

			// check if data is at the root.right.left, Zig-zag case
		} else if (root.right.data > data) {
			// first bring the node you r searching at root.right.left ,
			// recursively
			if (root.right.left != null) {
				root.right.left = splay(root.right.left, data);
			}

			// now bring the node to the root's right by doing right rotation,
			// One zag is done here
			root.right = rightRotate(root.right);
			// Now one right rotation is remaining.
		}

		// If we are here that means node which we were searching is on the
		// right of root,
		// do right rotate
		if(root.right!=null)return leftRotate(root);
		return root;
	}

	public void inorder(Node root) {
		if (root != null) {
			inorder(root.left);
			System.out.print("  " + root.data);
			inorder(root.right);
		}
	}

	public static void main(String args[]) {
		
		SplayTree s = new SplayTree();		 
		Node root = new Node(10); 
		root = s.insert(root, 5);
		root = s.insert(root, 15);
		root = s.insert(root, 25);
		root = s.insert(root, 35);
		root = s.insert(root, 20);
		root = s.insert(root, 1);
		root = s.insert(root, 8);
		root = s.insert(root, 12);
		System.out.println("new root: " + root.data);
		s.inorder(root);
		root = s.search(root, 1);
		System.out.println("\n new root: " + root.data);
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
