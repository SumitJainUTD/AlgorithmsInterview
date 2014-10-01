package InOrderSuccessorBinaryTree;

public class InOrderSuccessorBinaryTree {
	public static TreeNode n = null;
	public static Boolean nodeFound = false;
	public TreeNode inOrderSuccBiTree(TreeNode root, TreeNode x){
		nodeFound = false;
		if(x.right!=null){
			TreeNode temp = leftMostTreeNode(x.right);
			System.out.println("The In Order Successor for '" + x.data + "' is "+ temp.data );
			return null;
		}
		return findRecur(root, x);
	}
	public void display(TreeNode root){
		if(root!=null){
			display(root.left);
			System.out.print(" " + root.data);
			display(root.right);
		}
	}

	public TreeNode findRecur(TreeNode root, TreeNode x){
		if(root==null) return null;
		if(root==x||(n = findRecur(root.left,x))!=null||(n=findRecur(root.right,x))!=null){	
			
			if(n!=null){
				if(root.left==n){
					nodeFound = true;
					System.out.println("The In Order Successor for '" + x.data + "' is "+ root.data );
					return null;
				}
			}				
			return root;
		}
		return null;		
	}
	public TreeNode leftMostTreeNode(TreeNode x){
		while(x.left!=null){
			x = x.left;
		}	
		nodeFound = true;
		return x;
	}
	public static void main(String args[]){
		TreeNode root = new TreeNode('a');
		root.left = new TreeNode('b');
		root.right = new TreeNode('c');
		root.left.left = new TreeNode('d');
		root.left.right = new TreeNode('e');
		TreeNode x = new TreeNode('x');
		root.left.right.left = new TreeNode('i');
		root.left.right.left.right = new TreeNode('j');
		root.left.right.left.right.right = x;
		root.right.left = new TreeNode('f');
		TreeNode y = new TreeNode('g');
		root.right.right = y;
		
		InOrderSuccessorBinaryTree i = new InOrderSuccessorBinaryTree();
		System.out.print(" Tree : ");
		i.display(root);
		System.out.println();
		nodeFound = false;
		i.inOrderSuccBiTree(root, x);		
		if(!nodeFound){
			System.out.println("InOrder Successor of " + x.data + " is NULL");
		}
		nodeFound = false;
		i.inOrderSuccBiTree(root, root);		
		if(!nodeFound){
			System.out.println("InOrder Successor of " + root.data + " is NULL");
		}
		nodeFound = false;
		i.inOrderSuccBiTree(root, y);
		if(!nodeFound){
			System.out.println("InOrder Successor of " + y.data + " is NULL");
		}
	}
}
class TreeNode{
	char data;
	TreeNode left;
	TreeNode right;
	public TreeNode(char data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

