package PrintAllNodesAtKFromGivenNode;

public class PrintAllNodesAtKFromGivenNode {

	public void printAllNodes(Node root, int node, int distance) {
		int pl = Pathlength(root, node) - 1;
		Path(root, node, pl, distance);
	}

	public void print(Node root, int node, Node prev, int k,
			boolean searchingDown) {
		if (root != null) {
			if (k == 0 && root.data != node) {
				System.out.print(" " + root.data);
			}
			if (searchingDown) {
				print(root.left, node, prev, --k, searchingDown);
				print(root.right, node, prev, k, searchingDown);
			} else {
				if (root.left != prev) {
					print(root.left, node, prev, --k, searchingDown);
				}
				if (root.right != prev) {
					print(root.right, node, prev, --k, searchingDown);
				}
			}
		}
	}

	public Node Path(Node root, int dest, int k, int n) {
		if (root == null)
			return null;
		Node x = null;
		if (root.data == dest || (x = Path(root.left, dest, k - 1, n)) != null
				|| (x = Path(root.right, dest, k - 1, n)) != null) {
			if (k == 0) {
				print(root, dest, x, n - k, true);
			} else {
				print(root, dest, x, n - k, false);
			}

			return root;
		}
		return null;
	}

	public int Pathlength(Node root, int n1) {
		if (root != null) {
			int x = 0;
			if ((root.data == n1) || (x = Pathlength(root.left, n1)) > 0
					|| (x = Pathlength(root.right, n1)) > 0) {
				return x + 1;
			}
			return 0;
		}
		return 0;
	}

	public static void main(String[] args) throws java.lang.Exception {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.left.left = new Node(9);
		root.left.right = new Node(5);
		root.left.right.left = new Node(6);
		root.left.right.right = new Node(7);
		root.left.right.right.right = new Node(10);
		root.left.right.right.right.left = new Node(11);
		root.right.right = new Node(8);
		PrintAllNodesAtKFromGivenNode i = new PrintAllNodesAtKFromGivenNode();
		System.out.print("Nodes at distance '3' from Node '5' are : ");
		i.printAllNodes(root, 5, 3);
	}
}

class Node {
	int data;
	Node left;
	Node right;

	public Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
