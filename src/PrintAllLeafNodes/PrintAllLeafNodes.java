package PrintAllLeafNodes;

public class PrintAllLeafNodes {

	public void printOnlyLeaves(Node root){
		if(root!=null){
			printOnlyLeaves(root.left);
			if((root.left==null) && (root.right==null)){
				System.out.print(" " + root.data);
			}
			printOnlyLeaves(root.right);
		}
		
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		Node root = new Node(5);
		root.left = new Node(10);
		root.right = new Node(15);
		root.left.left = new Node(20);
		root.left.right = new Node(25);
		root.right.left = new Node(30);
		root.right.right = new Node(35);
		root.left.right.right = new Node(45);
		
		PrintAllLeafNodes i  = new PrintAllLeafNodes();
		System.out.print("Leaf Nodes are :");
		i.printOnlyLeaves(root);
	}
}
class Node{
	int data;
	Node left;
	Node right;
	public Node(int data){
		this.data = data;
		this.left = null;
		this.right =null;
	}
}