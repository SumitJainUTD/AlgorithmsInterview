package isBST;

public class isBST {
	public static Node prevNode = null;
	//method 1: do inOrder and check if it is in ascending order
	
	public boolean isBST1(Node root){
		if(root!=null){
			if(!isBST1(root.left)) return false;
			if(prevNode!=null &&  prevNode.data>=root.data){				
				return false;
			}
			prevNode = root;
			return isBST1(root.right);	
			}		
		return true;
	}
	
//	//method 2
	public boolean isBST2(Node root, int min, int max){
		if(root!=null){
			if(root.data>max || root.data<=min){
				return false;
			}
			if(isBST2(root.left, min, root.data)==false||isBST2(root.right, root.data,max)==false){
				return false;
			}
			return true;
		}else{
			return true;
		}		
	}
	public void inorder(Node root){
		if(root!=null){
		inorder(root.left);
		System.out.print("  " + root.data);
		inorder(root.right);
		}
	}
	public static void main(String args[]){
		isBST i = new isBST();
		Node root = new Node(20);
		root.left = new Node(10);
		root.right = new Node(30);
		root.left.left = new Node(5);
		root.left.right = new Node(15);		
		root.right.left = new Node(25);
		root.right.right = new Node(35);		
		System.out.println("Tree is " );
		i.inorder(root);
		System.out.println();
		System.out.println("is Tree BST ?? METHOD 1 : " + i.isBST1(root));
		System.out.println("is Tree BST ?? METHOD 2 : " + i.isBST2(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
		root.left.right.right = new Node(40);
		System.out.println("Tree is " );
		i.inorder(root);
		System.out.println();
		System.out.println("is Tree BST ?? METHOD 1 : " + i.isBST1(root));
		System.out.println("is Tree BST ?? METHOD 2 : " + i.isBST2(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
		
	}
	
}

class Node{
	int data;
	Node left;
	Node right;	
	public Node(int data){
		this.data = data;
		left = null;
		right = null;
	}
}
