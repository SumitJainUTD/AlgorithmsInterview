package PrintPathRootToNode;

import java.util.ArrayList;
import java.util.Collections;

public class PrintPathRootToNode {

	public static ArrayList path;
	public Boolean printPath(Node root, Node dest){
		if(root==null) return false;
		if(root==dest||printPath(root.left,dest)||printPath(root.right,dest)){
			//System.out.print("  " + root.data);
			path.add(root.data);
			return true;
		}
		return false;
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		Node root = new Node(1);
		root.left = new Node (2);
		root.right = new Node (3);
		Node n1 = new Node (4);
		root.left.left = n1;
		root.left.right = new Node (5);
		Node n2 = new Node (8);
		root.left.right.right = n2;
		root.left.right.left = new Node (7);
		
		PrintPathRootToNode i = new PrintPathRootToNode();
		path = new ArrayList();
		i.printPath(root,n2);
		Collections.reverse(path);
		System.out.println(" Path " + path);
	}
}

class Node{
	int data;
	Node left;
	Node right;
	public Node (int data){
		this.data = data;
		left = null;
		right = null;
	}
}