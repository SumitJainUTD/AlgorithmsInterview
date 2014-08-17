package treeToDLL;
//Add more methods later
public class treeToDblyLinkedList {
	public static Node root = null;
	public static Node head = null;
	public static Node prev = null;
	
	
	public void TreetoDLL(Node root){
		if(root!=null){
			TreetoDLL(root.left);
			if(prev==null ){
				head = root;
			}else{
				root.left = prev;
				prev.right = root;
			}
			prev = root;
			TreetoDLL(root.right);
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
		System.out.println(" InOrder Traversal :");
		t.inOrder(root);
		t.TreetoDLL(root);
		System.out.println("\n Doubly Linked List  :");
		t.print(head);
		
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
