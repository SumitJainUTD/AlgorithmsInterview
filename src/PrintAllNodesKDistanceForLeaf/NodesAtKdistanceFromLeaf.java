package PrintAllNodesKDistanceForLeaf;

public class NodesAtKdistanceFromLeaf {

	public void printPaths(Node root, int[] path, int pathLen,
			boolean [] pathVisited, int distance) {
		if (root == null) {
			return;
		}
		path[pathLen] = root.data;
		pathVisited[pathLen] = false;
		pathLen++;
		if (root.left == null && root.right == null) {
			int nodeAtDistance = pathLen - distance - 1;
			if (nodeAtDistance >= 0 && pathVisited[nodeAtDistance] == false) {
				System.out.print("  " + path[nodeAtDistance]);
				pathVisited[nodeAtDistance] = true;
			}
		} else {
			printPaths(root.left, path, pathLen,pathVisited, distance);
			printPaths(root.right, path, pathLen,pathVisited, distance);
		}
	}
	public static void main(String[] arg) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.left.left = new Node(7);
		root.right.left = new Node(6);
		root.right.left.left = new Node(8);
		root.right.left.right = new Node(9);
		int[] path = new int[100];
		boolean[] pathVisited = new boolean[100];
		NodesAtKdistanceFromLeaf p = new NodesAtKdistanceFromLeaf();
		System.out.print("Nodes at distance by 2 :");
		p.printPaths(root, path, 0, pathVisited, 2);
		System.out.print("\nNodes at distance by 1 :");
		p.printPaths(root, path, 0, pathVisited, 1);
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