package PrintNodesAtKDistance;

public class PrintNodesAtKDistance {
	public void print(Node root, int k) {
		if (root != null) {
			if (k == 0) {
				System.out.print(" " + root.data);
			}
			print(root.left, --k);			
			print(root.right, k);
		}
	}

	public static void main(String[] args) throws java.lang.Exception {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.right.left = new Node(6);
		root.left.right.right = new Node(7);
		root.right.right = new Node(8);
		root.right.right.right = new Node(9);
		PrintNodesAtKDistance i = new PrintNodesAtKDistance();
		System.out.println("Nodes at 3 distance from root : ");
		i.print(root, 3);
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
