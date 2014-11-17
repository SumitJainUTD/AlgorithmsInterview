package LargestBSTinBinaryTree;

public class LargestBSTinBinaryTree {
	public static int maxLen =0;
	public static int currLen =0;
	public static int leftMax =0;
	public static int rightMin =0;
	public static Node bstRoot = null;
	public int largestBST(Node root,boolean leftCall){
		if(root==null){
			return 0;
		}
		int x = largestBST(root.left,true);		
		int y = largestBST(root.right,false);
		if(leftCall){
			if(root.data>x){
				currLen++;
			}else{
				currLen=0;
			}
			if(currLen>maxLen){
				maxLen=currLen;
			}
			if(leftMax<root.data){
				leftMax = root.data;
			}
			return leftMax;
		}else{
			if(root.data<y){
				currLen++;
			}else{
				currLen=0;
			}
			if(currLen>maxLen){
				maxLen=currLen;
			}
			if(rightMin>root.data){
				rightMin = root.data;
			}
			return rightMin;
			
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
		l.largestBST(root,true);
		System.out.println(maxLen);
		
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
