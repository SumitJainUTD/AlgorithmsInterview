package InorderDFStoTree;

public class InorderDFStoTree {
	int indexDFS=0;
	public Node makeBTree(int[] inorder, int[] DFS, int iStart, int iEnd) {
		if (iStart > iEnd) {
			return null;
		}
		int rootVal = DFS[indexDFS];
		Node root = new Node(rootVal);
		indexDFS++;
		if (iStart == iEnd) {
			return root;
		}
		int index = findIndex(inorder, rootVal, iStart, iEnd);
		root.left = makeBTree(inorder, DFS, iStart, index - 1);
		root.right = makeBTree(inorder, DFS, index + 1, iEnd);

		return root;
	}
	public int findIndex(int[] inorder, int value, int iStart, int iEnd) {
		int x = -1;
		for (int i = iStart; i <= iEnd; i++) {
			if (value == inorder[i]) {
				x = i;
			}
		}
		return x;
	}

	public void printINORDER(Node root) {
		if (root != null) {
			printINORDER(root.left);
			System.out.print("  " + root.data);
			printINORDER(root.right);
		}
	}

	public static void main(String args[]) {
		int[] inOrder = { 8, 4, 2, 5, 1, 6, 3, 7, 9 };
		int[] DFS = { 1, 2, 4, 8, 5, 3, 6, 7, 9 };
		InorderDFStoTree i = new InorderDFStoTree();
		Node x = i.makeBTree(inOrder, DFS, 0, inOrder.length - 1);
		System.out.println("inorder traversal of constructed tree : ");
		i.printINORDER(x);
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
