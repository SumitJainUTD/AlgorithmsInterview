package LowestCommonAncestorBT;

public class LowestCommonAncestorBT {
	
	public Node getLCA(Node root, Node n1, Node n2){
		if(root==null){
			return null;
		}else{
				if(root.data==n1.data||root.data==n2.data){
				return root;
			}
			Node left = getLCA(root.left,n1,n2);
			Node right = getLCA(root.right,n1,n2);
			
			if(left!=null && right!=null){
				return root;
			}
			if(left!=null){
				return left;
			}else if(right!=null){
				return right;
			}
			return null;
		}
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		Node root  = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		Node n3 = new Node(5);
		root.left.right = n3;
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		Node n1 = new Node(8);
		root.left.left.left = n1;
		root.left.left.right = new Node(9);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(20);
		
		root.left.right.left.left = new Node(11);
		Node n2 = new Node(12);
		root.left.right.left.right = n2 ;
		
		LowestCommonAncestorBT i = new LowestCommonAncestorBT();
		Node x = i.getLCA(root,n1,n2);
		System.out.println("LCA is " + x.data);
		x = i.getLCA(root,n2,n3);
		System.out.println("LCA is " + x.data);
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