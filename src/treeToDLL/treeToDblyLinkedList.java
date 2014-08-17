package treeToDLL;

public class treeToDblyLinkedList {
	public static Node root = null;
	public static Node head = null;
	public static Node tail = null;
	
	public Node l,r;
	public Node TreetoDLL(Node root){
		if(root!=null){
			System.out.println("  " + root.data);
			Node leftTmp = root.left;
			Node rytTmp = root.right;
			l = TreetoDLL(leftTmp);
			if(l!=null){
				root.left = l;				
				l.right = root;
				return l;
			}else if(l==null){
				root.left = l;
				return l;
			}
			r = TreetoDLL(rytTmp);
			if(r!=null){
				root.right = r;
				r.left = root;
				return r;
			}else if(l==null){
				root.right = r;
				return r;
			}			
		}
		return root;
//		
	}
	public Node getHead(Node x){
		while(x!=null && x.left!=null){
			x = x.left;
		}
		head = x;
		return head;
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
	public void print(Node head){
		Node current = head;
		while(current!=null){
			System.out.print("  " + current.data);
			current = current.right;
		}
	}
	public static void main(String args[]){
		root = new Node(10);
		root.left = new Node(12);
		root.right = new Node(15);
		root.left.left = new Node(25);
		root.left.right = new Node(30);
		root.right.left = new Node(36);
		
		treeToDblyLinkedList t= new treeToDblyLinkedList();
		//t.inOrder(root);
		Node x = t.TreetoDLL(root);
		t.print(t.getHead(x));
		
	}
}

class Node{
	int data;
	Node left;
	Node right;
	public Node(int data){
		this.data =data;
		this.left = null;
		this.right = null;
	}
}
