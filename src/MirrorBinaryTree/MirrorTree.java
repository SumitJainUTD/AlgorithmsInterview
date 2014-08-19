package MirrorBinaryTree;

public class MirrorTree {
	public void mirror(Node root){
		print(root);
		Node x = mirrorTree(root);
		System.out.print("\n Mirror Image ");
		print(x);
	}
	public Node mirrorTree(Node root){
		if(root!=null){
			Node t = root.left;
			root.left = root.right;
			root.right = t;
			mirrorTree(root.right);
			mirrorTree(root.left);
		}
		return root;
	}
	public void print(Node root){
		if(root!=null){
			print(root.left);
			System.out.print(" " + root.data);
			print(root.right);
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
		
		MirrorTree i  = new MirrorTree();
		i.mirror(root);
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