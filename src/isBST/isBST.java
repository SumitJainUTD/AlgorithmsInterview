package isBST;

public class isBST {
	//method 1: do inOrder and check if it is in ascending order
	public boolean isBSTInOrder(Node root){
		if(root!=null){
			return checkBST(root, root.data);
		}else{
			return true;
		}
	}
	public boolean checkBST(Node root, int x){
		if(root!=null){
			checkBST(root.left, root.data);
			System.out.println(x + "  " + root.data);
			if(x>root.data){
				return false;
			}
			checkBST(root.right, root.data);
		}
		return true;
	}
	public static void main(String args[]){
		BST b = new BST();
		b.insert(2);b.insert(5);
		b.insert(1);b.insert(4);
		isBST i = new isBST();
		System.out.println(i.isBSTInOrder(b.root));
		Node root = new Node(2);
		root.left = new Node(1);
		root.right = new Node(3);
		root.left.left = new Node(4);
		System.out.println(i.isBSTInOrder(root));		
	}
	
}

class Node{
	int data;
	Node left;
	Node right;	
	public Node(int data){
		this.data = data;
		left = null;
		right = null;
	}
}
class BST{
	public Node root=null;
	public boolean find(int id){
		Node current = root;
		while(current!=null){
			if(current.data==id){
				return true;
			}else if(current.data>id){
				current = current.left;
			}else{
				current = current.right;
			}
		}
		return false;
	}
	public void insert(int id){
		Node newNode = new Node(id);
		if(root==null){
			root = newNode;
			return;
		}
		Node current = root;
		Node parent = null;
		while(true){
			parent = current;
			if(id<current.data){				
				current = current.left;
				if(current==null){
					parent.left = newNode;
					return;
				}
			}else{
				current = current.right;
				if(current==null){
					parent.right = newNode;
					return;
				}
			}
		}
	}
	public void printTree(){
		inOrder(root);
	}
	public void inOrder(Node root){
		if(root!=null){
			inOrder(root.left);
			System.out.print(" " + root.data);
			inOrder(root.right);
		}
	}
}
