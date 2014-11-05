package ReverseAlternateLevelsOfBinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class ReverseAlternateLevelsOfBinaryTree {

	public static ArrayList al;
	public void storeAlterNateLevels(Node root,int level){
		if(root!=null){
			storeAlterNateLevels(root.left,level+1);
			if(level%2!=0){
				al.add(root.data);
			}
			storeAlterNateLevels(root.right,level+1);
		}
	}
	
	public void reverseAlterNateLevels(Node root,int level){
		if(root!=null){
			reverseAlterNateLevels(root.left,level+1);
			if(level%2!=0){
				root.data = (Integer)al.remove(0);
			}
			reverseAlterNateLevels(root.right,level+1);
		}
	}
	public void levelOrderQueue(Node root){
		Queue q = new LinkedList();
		int levelNodes =0;
		if(root==null) return;
		q.add(root);
		
		while(!q.isEmpty()){
			levelNodes = q.size();
			while(levelNodes>0){
				Node n = (Node)q.remove();
				System.out.print(" " + n.data);
				if(n.left!=null) q.add(n.left);
				if(n.right!=null) q.add(n.right);
				levelNodes--;
			}
			System.out.println("");
		}
	}
	public void inorder(Node root){
		if(root!=null){
			inorder(root.left);
			System.out.print(" " + root.data);
			inorder(root.right);
		}
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		Node root = new Node(1);
		root.left = new Node (2);
		root.right = new Node (3);
		root.left.left = new Node (4);
		root.left.right = new Node (5);
		root.right.left = new Node (6);
		root.right.right = new Node (7);
		root.left.left.left = new Node (8);
		root.left.left.right = new Node (9);
		root.left.right.left = new Node (10);
		root.left.right.right = new Node (11);
		
		root.right.left.left = new Node (12);
		root.right.left.right = new Node (13);
		root.right.right.left = new Node (14);
		root.right.right.right = new Node (15);
		
		ReverseAlternateLevelsOfBinaryTree i = new ReverseAlternateLevelsOfBinaryTree();
		al = new ArrayList();
		System.out.println(" Orininal Tree");
		//i.inorder(root);
		i.levelOrderQueue(root);
		i.storeAlterNateLevels(root,0);
		// System.out.println(" LIst " + al);
		Collections.reverse(al);
	
		i.reverseAlterNateLevels(root,0);
		System.out.println("\n New Tree, Alternate Levels Reversed..");
		//i.inorder(root);
		i.levelOrderQueue(root);
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