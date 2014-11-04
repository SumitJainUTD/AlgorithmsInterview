package RightViewOfTree;

public class RightViewOfTree {


// method 1 : recursion : 
//traverse the tree from right to left
// print the first node you encounter
//take two variables , currentLevel=0 and nextLevel=1
//as soon as you change level , change the currentLevel = nextLevel
//print only when current level<nextLevel so this way you will print only the first element
//for rest of the nodes on the the level currentLevel and nextLevel are equal so it wont print

//Method 2:
//do the Level order traversal and print the last node value
	public static int currentLevel =0;
	public void rightViewRecur(Node root, int nextLevel){
		if(root==null) return;
		if(currentLevel<nextLevel){
			System.out.print ("  " + root.data);
			currentLevel = nextLevel;
		}
		rightViewRecur(root.right,nextLevel+1);
		rightViewRecur(root.left,nextLevel+1);
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
		root.left.right.right = new Node(45);
		
		RightViewOfTree i  = new RightViewOfTree();
		i.rightViewRecur(root,1);
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