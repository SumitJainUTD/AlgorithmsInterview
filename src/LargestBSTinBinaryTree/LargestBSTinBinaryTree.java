package LargestBSTinBinaryTree;

public class LargestBSTinBinaryTree {
	public static int maxLen =0;
	public static Node bstRoot = null;
	public int largestBST(Node root, int min, int max, int currLen){
		if(root==null){
			return 0;
		}
		int x = largestBST(root.left, min, root.data,currLen);
		currLen = x + 1;
		if(currLen>maxLen){
			maxLen = currLen;
			bstRoot = root;
		}
		x = largestBST(root.right,root.data, max, currLen);
		currLen = x + 1;
		if(currLen>maxLen){
			maxLen = currLen;
			bstRoot = root;
		}
		if(root.data<max || root.data>=min){			
			return currLen;
		}else{
			return 0;
		}
	}
	public static void main(String args[]){
		Node root = new Node(50);
		root.left = new Node(30);
		root.right = new Node(60);
		root.left.left = new Node(5);
		root.left.right = new Node(20);
		root.right.left = new Node(45);
		root.right.right = new Node(70);
		root.right.right.left = new Node(65);
		root.right.right.right = new Node(80);
		
		LargestBSTinBinaryTree l = new LargestBSTinBinaryTree();
		l.largestBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
		System.out.println(bstRoot.data + "  " + maxLen);
		
	}
}
class Node{
	int data;
	Node left;
	Node right;
	public Node(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
