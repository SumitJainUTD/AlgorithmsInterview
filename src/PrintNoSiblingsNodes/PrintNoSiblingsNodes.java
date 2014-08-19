package PrintNoSiblingsNodes;

public class PrintNoSiblingsNodes {

	public void printOnlyLeaves(Node root){
		if(root!=null){
			printOnlyLeaves(root.left);
			if((root.left==null) && (root.right!=null)){
				System.out.print(" " + root.right.data);
			}
			if((root.left!=null) && (root.right==null)){
				System.out.print(" " + root.left.data);
			}
			printOnlyLeaves(root.right);
		}
		
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.right = new Node(4);
		root.right.left = new Node(5);
		root.right.left.left = new Node(6);
		
		PrintNoSiblingsNodes i  = new PrintNoSiblingsNodes();
		System.out.print("Nodes with No Siblings: ");
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