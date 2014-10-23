package MaxWidthOfTree;
import java.util.LinkedList;
import java.util.Queue;

public class MaxWidthOfTree {
	
	public static int maxWidth=0;
	public int findMaxWidth(Node root){
		Queue q = new LinkedList<>();
		int levelNodes =0;
		if(root==null) return 0;
		q.add(root);
		
		while(!q.isEmpty()){
			levelNodes = q.size();
			if(levelNodes>maxWidth){
				maxWidth = levelNodes;
			}
			while(levelNodes>0){
				Node n = (Node)q.remove();
				if(n.left!=null) q.add(n.left);
				if(n.right!=null) q.add(n.right);
				levelNodes--;
			}
		}
		return maxWidth;
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
		
		MaxWidthOfTree i  = new MaxWidthOfTree();		
		int x = i.findMaxWidth(root);
		System.out.println("Maximum Width of a binary Tree is : " + x);
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