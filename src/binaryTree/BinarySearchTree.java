package binaryTree;

public class BinarySearchTree {
	Node root;
	public BinarySearchTree(){
		this.root = null;
	}
	
	public boolean find(Node root, int id){
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
	public void inOrder(Node root){
		if(root!=null){
			inOrder(root.left);
			System.out.print(" " + root.data);
			inOrder(root.right);
		}
	}
	public void preOrder(Node root){
		if(root!=null){
			System.out.print(" " + root.data);
			preOrder(root.left);			
			preOrder(root.right);			
		}
	}
	public static void main(String arg[]){
		BinarySearchTree b = new BinarySearchTree();
		b.insert(2);b.insert(5);
		b.insert(1);b.insert(4);
		b.inOrder(b.root);
		System.out.println("");
		b.preOrder(b.root);
		System.out.println("");
		System.out.println(b.find(b.root,4));
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
