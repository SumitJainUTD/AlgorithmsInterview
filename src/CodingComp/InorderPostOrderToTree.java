package CodingComp;

import java.util.LinkedList;
import java.util.Queue;

public class InorderPostOrderToTree {

	public static int pIndex = 0;

	public Node makeBTree(int[] inOrder, int[] postOrder, int iStart, int iEnd,
			int postStart, int postEnd) {
		if (iStart > iEnd || postEnd > postEnd) {
			return null;
		}

		int rootValue = postOrder[postEnd];
		Node root = new Node(rootValue);
		pIndex++;

		if (iStart == iEnd) {
			return root;
		}
		int index = getInorderIndex(inOrder, iStart, iEnd, root.data);
		root.left = makeBTree(inOrder, postOrder, iStart, index - 1, postStart,
				postStart + index - (iStart + 1));
		root.right = makeBTree(inOrder, postOrder, index + 1, iEnd, postStart
				+ index - iStart, postEnd - 1);
		// }
		return root;
	}

	public int getInorderIndex(int[] inOrder, int start, int end, int data) {
		for (int i = start; i <= end; i++) {
			if (inOrder[i] == data) {
				return i;
			}
		}
		return -1;
	}

	public void printINORDER(Node root) {
		if (root != null) {
			printINORDER(root.left);
			System.out.print("  " + root.data);
			printINORDER(root.right);
		}
	}

	public static void main(String[] args) throws java.lang.Exception {
		int[] inOrder = { 4, 2, 5, 1, 6, 3, 7 };
		int[] postOrder = { 4, 5, 2, 6, 7, 3, 1 };
		InorderPostOrderToTree i = new InorderPostOrderToTree();
		Node x = i.makeBTree(inOrder, postOrder, 0, inOrder.length - 1, 0,
				postOrder.length - 1);
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