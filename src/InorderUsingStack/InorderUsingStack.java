package InorderUsingStack;

import java.util.Stack;

public class InorderUsingStack {
	public void inorder(Node root){
		Stack<Node> s = new Stack<>();
		Node current = root;
		s.add(current);
		while(current!=null && s.isEmpty()!=true){
			while(current.left!=null){
				current=current.left;
				s.add(current);
			}
			
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


