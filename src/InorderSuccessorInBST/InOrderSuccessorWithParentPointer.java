package InorderSuccessorInBST;

public class InOrderSuccessorWithParentPointer {
	public Node findInOrderSuccessor(Node root, Node x){
		//if the right child of x is not null then in-Order successor will the left most node in 
		//the right sub tree of x.
		if(x.right!=null){
			return leftMostNode(x.right);
		}
		Node parent = x.parent;		
		while(parent!=null && x==parent.right){
			x = parent;
			parent = parent.parent;
		}
		return parent;
	}
	public Node leftMostNode(Node x){
		while(x.left!=null){
			x = x.left;
		}
		return x;
	}
	public void display(Node root){
		if(root!=null){
			display(root.left);
			System.out.print(" " + root.data);
			display(root.right);
		}
	}
	public static void main(String args[]){
		Node root = new Node(10);
		root.left = new Node(5);
		root.left.parent = root;
		root.right = new Node(15);
		root.right.parent = root;
		root.left.left = new Node(3);
		root.left.left.parent = root.left;
		root.right.left = new Node(17);
		root.right.left.parent = root.right;
		Node a = new Node(7);
		root.left.right = a;
		root.left.right.parent = root.left;
		InOrderSuccessorWithParentPointer b = new InOrderSuccessorWithParentPointer();
		System.out.print(" Tree : ");
		b.display(root);
		System.out.println();
		Node x = b.findInOrderSuccessor(root, a);
		if(x!=null){
			System.out.println("InOrder Successor of " + a.data + " is " + x.data);
		}else{
			System.out.println("InOrder Successor of " + a.data + " is NULL");
		}
		x = b.findInOrderSuccessor(root, root);
		if(x!=null){
			System.out.println("InOrder Successor of " + root.data + " is " + x.data);
		}else{
			System.out.println("InOrder Successor of " + root.data + " is NULL");
		}
	}
}
class Node{
	int data;
	Node left;
	Node right;
	Node parent;
	public Node(int data){
		this.data = data;
		this.left = null;
		this.right = null;
		this.parent = null;
	}
}