package InorderSuccessorInBST;

public class InOrderSuccessor {
	public TreeNode findInOrderSuccessor(TreeNode root, TreeNode x){
		//if the right child of x is not null then in-Order successor will the left most node in 
		//the right sub tree of x.
		if(x.right!=null){
			return leftMostTreeNode(x.right);
		}
		TreeNode successor = null;
		while(root!=null){			
			if(root.data>x.data){
				successor = root;
				root = root.left;
			}else if(root.data<x.data){
				root = root.right;
			}else{
				return successor;
			}
		}
		return null;		
	}
	public void display(TreeNode root){
		if(root!=null){
			display(root.left);
			System.out.print(" " + root.data);
			display(root.right);
		}
	}
	
	public static void main(String args[]){
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);
		root.left.left = new TreeNode(3);
		root.right.left = new TreeNode(17);
		TreeNode a = new TreeNode(7);
		root.left.right = a;
		InOrderSuccessor b = new InOrderSuccessor();
		System.out.print(" Tree : ");
		b.display(root);
		System.out.println();
		TreeNode x = b.findInOrderSuccessor(root, a);
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
	public TreeNode leftMostTreeNode(TreeNode x){
		while(x.left!=null){
			x = x.left;
		}
		return x;
	}
}
class TreeNode{
	int data;
	TreeNode left;
	TreeNode right;
	public TreeNode(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
