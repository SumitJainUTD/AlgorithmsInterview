package DiameterOfTree;

public class DiameterOfTree {
	public int getHeight(Node root) {
		if (root != null) {
			return 1 + Math.max(getHeight(root.left), getHeight(root.right));
		}
		return 0;
	}

	public int Diameter(Node root) {
		if (root != null) {
			int leftH = getHeight(root.left);
			int rightH = getHeight(root.right);

			int left_Diameter = Diameter(root.left);
			int right_Diameter = Diameter(root.right);

			return Math.max(leftH + rightH + 1,
					Math.max(left_Diameter, right_Diameter));
		}
		return 0;
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
		root.right.right.right.right = new Node(10);
		root.right.right.right.right.left = new Node(11);
		root.right.right.right.right.right = new Node(12);
		DiameterOfTree i = new DiameterOfTree();
		System.out.println("Diameter of Tree : " + (i.Diameter(root)));
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
