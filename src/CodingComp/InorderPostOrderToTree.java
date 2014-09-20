package CodingComp;

import java.util.LinkedList;
import java.util.Queue;

public class InorderPostOrderToTree {

	public static int pIndex=0;
	public Node makeBTree(int [] inOrder, int [] postOrder, int iStart, int iEnd, int postStart, int postEnd ){
		if(iStart>iEnd || postEnd>postEnd){
			return null;
		}
		
		int rootValue = postOrder[postEnd];
		Node root = new Node(rootValue);pIndex++;
	
		if(iStart==iEnd){
			return root;
		}
		int index = getInorderIndex(inOrder, iStart, iEnd, root.data);
			root.left = makeBTree(inOrder,postOrder,iStart, index-1,postStart,postStart+index-(iStart+1));
			root.right = makeBTree(inOrder,postOrder,index+1, iEnd,postStart+index-iStart, postEnd-1);
		//}
		return root;
	}
	public int getInorderIndex(int [] inOrder, int start, int end, int data){
		for(int i=start;i<=end;i++){
			if(inOrder[i]==data){
				return i;
			}
		}
		return -1;
	}
	public void printINORDER(Node root){
		if(root!=null){
			printINORDER(root.left);
			System.out.print("  " + root.data);
			printINORDER(root.right);
		}
	}
	public void levelOrderQueue(Node root){
		Queue q = new LinkedList();
		int levelNodes =0;
		if(root==null) return;
		q.add(root);
		
		while(!q.isEmpty()){
			//levelNodes = q.size();
			//while(levelNodes>0){
				Node n = (Node)q.remove();
				System.out.print("," + n.data);
				if(n.left!=null) q.add(n.left);
				if(n.right!=null) q.add(n.right);
				levelNodes--;
			//}
			//System.out.println("");
		}

	}
	public static void main (String[] args) throws java.lang.Exception
	{
		int [] inOrder = {57,40,23,8,48,69,58,42,4,32,11,9,54,66,53,52,19,36,27,62,13,22,2,24,43,41,61,1,17,49,10,55,51,7,25,47,64,5,15,35,50,18,59,3,70,31,6,20,26,28,16,34,38,45,67,65,60,39,12,29,56,63,21,44,30,46,37,14,68,33,0};
		int [] postOrder = {50,18,35,15,5,64,59,3,47,25,7,51,70,31,55,6,10,49,17,20,26,28,1,61,41,43,24,2,22,13,62,16,34,27,38,45,36,67,19,52,65,60,53,66,39,54,9,11,32,4,12,29,42,56,63,21,44,58,69,30,46,37,14,48,8,68,23,40,33,57,0};
		InorderPostOrderToTree  i = new InorderPostOrderToTree();
		if(inOrder.length!=postOrder.length){
			System.out.print("InvalidInput");
		}else{
			Node x = i.makeBTree(inOrder, postOrder, 0, inOrder.length-1,0,postOrder.length-1);
			//i.printINORDER(x);
			i.levelOrderQueue(x);
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