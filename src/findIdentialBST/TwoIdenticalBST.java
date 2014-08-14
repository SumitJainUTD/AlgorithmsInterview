package findIdentialBST;

public class TwoIdenticalBST {
	
	public boolean identicalBSTs(Node rootA, Node rootB){
		if((rootA==null)&&(rootB==null)){
			return true;
		}else if((rootA!=null && rootB==null)||(rootA==null && rootB!=null)){
			return false;
		}else if(rootA.data==rootB.data){
			return identicalBSTs(rootA.left, rootB.left) && identicalBSTs(rootA.right, rootB.right); 
		}else{
			return false;
		}
	}
	public static void main(String args[]){
		BST a = new BST();
		a.insert(1);a.insert(4);a.insert(2);a.insert(3);a.insert(5);
		BST b = new BST();
		b.insert(1);b.insert(4);b.insert(2);b.insert(3);b.insert(5);
		TwoIdenticalBST t = new TwoIdenticalBST();
		System.out.println(t.identicalBSTs(a.root, b.root));
		a.insert(11);b.insert(12);
		System.out.println(t.identicalBSTs(a.root, b.root));
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
