package SortedLLToBST;

public class SortedLLToBST {

	public static Node head = null;
	public BSTNode LLToBST(int start, int end){
		//System.out.print ("\n" + start + "  " + end + "   ");
		if(start>end)return null;
		int mid = (start+end)/2;
		BSTNode leftChild = LLToBST(start,mid-1);
		BSTNode root = new BSTNode(head.data);
		root.left = leftChild;
		head = head.next;
		root.right = LLToBST(mid+1,end);
		return root;
	}
	public int getSize(){
		Node curr = head;
		int size =0;
		while(curr!=null){
			curr=curr.next;
			size++;
		}
		return size;
	}
	public void inorder(BSTNode root){
		if(root!=null){
			inorder(root.left);
			System.out.print("   " + root.data);
			inorder(root.right);
		}
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		Node tail = new Node(6);
		head.next.next.next.next.next = tail;
		
		SortedLLToBST i = new SortedLLToBST();
		BSTNode x = i.LLToBST(1,i.getSize()) ;
		System.out.print("Constructed BST is :");
		i.inorder(x);
		
	}
}
class Node{
	int data;
	Node next;
	public Node(int data){
		this.data = data;
		next = null;
	}
}
class BSTNode{
	int data;
	BSTNode left;
	BSTNode right;
	public BSTNode(int data){
		this.data = data;
		left = null;
		right = null;
	}
}