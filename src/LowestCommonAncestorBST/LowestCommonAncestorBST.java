package LowestCommonAncestorBST;

public class LowestCommonAncestorBST {
	public void LCA(Node root, Node n1, Node n2){
		if(root==null){
			return ;
		}else{
			if(root.data>=n1.data && root.data<=n2.data){
			System.out.println("Lowest Common Ancestor of Nodes " + n1.data + " and " + n2.data + " is : " + root.data);
			return;
			}else{
				LCA(root.left, n1, n2);
				LCA(root.right, n1, n2);
			}
		}		
	}
	public Node LCA2(Node root, Node n1, Node n2){
		while(root!=null){
			
			if(root.data>n1.data && root.data>n2.data){
				root=root.left;
			}
			else if(root.data<=n1.data && root.data<n2.data){
				root=root.right;
			}else{
				break;
			}
		}
		return root;
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		Node root = new Node(20);
		root.left = new Node (8);
		root.right = new Node (22);
		Node n1 = new Node (4);
		root.left.left = n1;
		root.left.right = new Node (12);
		Node n2 = new Node (14);
		root.left.right.right = n2;
		root.left.right.left = new Node (10);
		
		LowestCommonAncestorBST i = new LowestCommonAncestorBST();
		i.LCA(root,n1,n2);
		Node x = i.LCA2(root,n1,n2);
		if(x!=null){
			System.out.println("Method 2-Lowest Common Ancestor of Nodes " + n1.data + " and " + n2.data + " is : " + x.data);
		}
	}
}

class Node{
	int data;
	Node left;
	Node right;
	public Node (int data){
		this.data = data;
		left = null;
		right = null;
	}
}
