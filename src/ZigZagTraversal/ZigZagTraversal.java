package ZigZagTraversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class ZigZagTraversal {
	
	ArrayList<Integer> al = new ArrayList<>();
	public static boolean evenLevel = false;	
	
	public void levelOrderQueue(Node root){
		Queue q = new LinkedList();
		int levelNodes =0;
		if(root==null) return;
		q.add(root);		
		while(!q.isEmpty()){
			levelNodes = q.size();
			al.clear();
			while(levelNodes>0){
				Node n = (Node)q.remove();
				al.add(n.data);
				//System.out.print(" " + n.data);
				if(n.left!=null) q.add(n.left);
				if(n.right!=null) q.add(n.right);
				levelNodes--;								
			}			
			if(evenLevel){
				System.out.print(al);
				evenLevel = !evenLevel;
			}else{
				Collections.reverse(al);
				System.out.print(al);
				evenLevel = !evenLevel;
			}
			System.out.println("");
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
		root.left.left.left = new Node(40);
		root.left.left.right = new Node(45);		
		ZigZagTraversal i  = new ZigZagTraversal();		
		System.out.println(" Spiral Print of a Tree : ");
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