package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	public void levelOrder(Node root){
		int h = height(root);
		for(int i=1;i<=h;i++){
			printLevels(root,i);
		}		
	}
	public void printLevels(Node root, int h){
		if(root==null) return;
		if(h==1) System.out.print(" " + root.data);
		else{
			printLevels(root.left,h-1);
			printLevels(root.right,h-1);
			
		}
	}
	public int height(Node root){
		if (root==null) return 0;
		return 1 + Math.max(height(root.left),height(root.right));
	}
	public void levelOrderQueue(Node root){
		Queue q = new LinkedList();
		if(root==null) return;
		q.add(root);		
		while(!q.isEmpty()){		
			Node n = (Node)q.remove();
			System.out.print(" " + n.data);
			if(n.left!=null) q.add(n.left);
			if(n.right!=null) q.add(n.right);			
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
		
		BFS i  = new BFS();
		i.levelOrder(root);
		System.out.println("");
		i.levelOrderQueue(root);
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