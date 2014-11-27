package BSTtoGreaterTree;
public class BSTtoGreaterTree {
	public static int sum = 0;
	public void greaterTree(Node root){
		if(root!=null){
			greaterTree(root.right);
			sum = sum + root.data;
			root.data = sum-root.data;
			greaterTree(root.left);			
		}else return;
	}
	public void inorder(Node root){
		if(root!=null){
			inorder(root.left);
			System.out.print("  " + root.data);
			inorder(root.right);
		}
	}
	public static void main(String args[]){
		Node root = new Node(11);
		root.left = new Node(2);
		root.right = new Node(29);
		root.left.left = new Node(1);
		root.left.right = new Node(7);
		root.right.left = new Node(15);
		root.right.right = new Node(40);
		root.right.right.left = new Node(35);
		root.right.right.right = new Node(50);
//		
		BSTtoGreaterTree b = new BSTtoGreaterTree();
		b.inorder(root);
		System.out.println("");
		b.greaterTree(root);
		b.inorder(root);
		
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

