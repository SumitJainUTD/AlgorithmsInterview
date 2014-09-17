package HeightOfANode;

public class NodeHeight {

	public int getNodeHeight(Node root, Node x, int height){
		if(root==null) return 0;
		if(root==x) return height;
		
		//check if the node is present in the left sub tree
		int level = getNodeHeight(root.left,x,height+1);
		//System.out.println(level);
		if(level!=0) return level;
		
		//check if the node is present in the right sub tree
		return getNodeHeight(root.right,x,height+1);
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		Node root = new Node(5);
		root.left = new Node(10);
		root.right = new Node(15);
		root.left.left = new Node(20);		
		Node x = new Node(25);
		root.left.right = x;
		root.left.right.left = new Node(35);		
		NodeHeight i  = new NodeHeight();
		System.out.println("Height of the Node " + x.data + " is : " +  i.getNodeHeight(root,x,1));
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