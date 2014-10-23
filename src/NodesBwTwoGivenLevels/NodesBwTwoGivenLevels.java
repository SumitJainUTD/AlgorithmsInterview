package NodesBwTwoGivenLevels;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class NodesBwTwoGivenLevels {
	public static int currLevel = 1;
	
	public void levelOrderQueue(Node root, int low, int high){
		Queue q = new LinkedList();
		int levelNodes =0;
		if(root==null) return;
		q.add(root);
		
		while(!q.isEmpty()){
			levelNodes = q.size();
			while(levelNodes>0){
				Node n = (Node)q.remove();
				if(currLevel>=low && currLevel<=high){
					System.out.print(" " + n.data);
				}
				if(n.left!=null) q.add(n.left);
				if(n.right!=null) q.add(n.right);
				levelNodes--;								
			}
			if(currLevel>=low && currLevel<=high){
				System.out.println("");
			}
			currLevel++;
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
		root.left.right.left = new Node(40);
		root.left.right.right = new Node(45);
		root.left.right.left.left = new Node(50);
		
		NodesBwTwoGivenLevels i  = new NodesBwTwoGivenLevels();	
		int low = 2;
		int high = 4;
		System.out.println("Print all nodes between nodes " + low + " and " + high);
		i.levelOrderQueue(root,low,high);
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