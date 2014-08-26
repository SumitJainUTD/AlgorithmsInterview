package MaxPathSumBwTwoLeaves;
//Now we will calculate the max path sum between two leaves node
//So our max path will be either on the left sub tree
//our max path will be either on the right sub tree
//Our max path will have some part in left and some part in right and passes through through
public class MaxPathSumBwTwoLeaves {
	
	public static int maxSoFar =0;
	public int maxPathSum(Node root){
		if(root!=null){
			int leftS = maxPathSum(root.left);
			int rightS = maxPathSum(root.right);
			int sumCurrent = Math.max(leftS+rightS+root.data , Math.max(leftS, rightS));			
			if(maxSoFar<sumCurrent){
				maxSoFar = sumCurrent;
			}
			return Math.max(leftS,rightS)+root.data;
		}
		else return 0;
	}
	public void inorder(Node root){
		if(root!=null){
			inorder(root.left);
			System.out.print("  " + root.data);
			inorder(root.right);
		}
		
	}
	public static void main(String args[]){
		Node root = new Node(-5);
		root.left = new Node(1);
		root.right = new Node(4);
		root.left.left = new Node(-6);
		root.left.right = new Node(5);
		root.left.right.left = new Node(-2);
		root.left.right.right = new Node(3);
		root.left.left.left = new Node(9);
		root.left.left.right = new Node(10);		
		root.right.left = new Node(11);
		root.right.right = new Node(-2);		
		root.right.right.right = new Node(-8);
		root.right.right.left = new Node(7);
		root.right.right.right.left = new Node(1);
		root.right.right.right.right = new Node(7);
		root.right.right.right.right.left = new Node(12);
		
		MaxPathSumBwTwoLeaves m = new MaxPathSumBwTwoLeaves();
		m.maxPathSum(root);
		System.out.println(maxSoFar);
		//m.inorder(root);
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
