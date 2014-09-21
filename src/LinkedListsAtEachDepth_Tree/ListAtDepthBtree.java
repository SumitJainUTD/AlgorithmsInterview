package LinkedListsAtEachDepth_Tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class ListAtDepthBtree {

	ArrayList<ListNode> al = new ArrayList<ListNode>();
	public void levelOrder(Node root){
		int h = height(root);
		for(int i=1;i<=h;i++){
			printLevels(root,i);
			System.out.println("");
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
		int levelNodes =0;
		if(root==null) return;
		q.add(root);
		
		while(!q.isEmpty()){
			levelNodes = q.size();
			ListNode head = null;
			ListNode curr = null;
			while(levelNodes>0){
				Node n = (Node)q.remove();
				ListNode ln = new ListNode(n.data);
				if(head==null){
					head = ln;
					curr = ln;
				}else{
					curr.next = ln;
					curr = curr.next;
				}
				if(n.left!=null) q.add(n.left);
				if(n.right!=null) q.add(n.right);
				levelNodes--;
			}			
			al.add(head);
		}
		display(al);
	}
	public void display(ArrayList al){
		Iterator<ListNode> it = al.iterator();
		while(it.hasNext()){
		  ListNode head = it.next();
		  //System.out.print("->" + head.data);
		  while(head!=null){
			  System.out.print("->" + head.data);
			  head = head.next;
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
		
		ListAtDepthBtree i  = new ListAtDepthBtree();
		//i.levelOrder(root);
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
class ListNode{
	int data;
	ListNode next;
	public ListNode(int data){
		this.data = data;
		this.next = null;
	}
}