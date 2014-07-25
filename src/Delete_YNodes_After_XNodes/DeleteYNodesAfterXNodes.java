package Delete_YNodes_After_XNodes;

public class DeleteYNodesAfterXNodes
{
	public int len;
	public Node head;
	public DeleteYNodesAfterXNodes(){
		head=null;
	}	
	public void deleteYAfterX(int x, int y){
		len = getLength(head);
		if(x>=len){
			System.out.println("\nINVALID NUMBER");
			return;
		}
		Node n = head;
		while(x>1){//since we need to one node prior before we start deleting
			n=n.next;
			x--;
		}
		Node temp = n;
		//System.out.println("\n" + temp.data);
		y=y+1; //since we need the node, after deleting y nodes
		while(y>0 && n!=null){
			n=n.next;
			y--;
		}
	//	System.out.println("\n" + n.data);
		temp.next = n;
	}
	
	public int getLength(Node head){
		Node n = head;
		int count=0;
		while(n!=null){
			n= n.next;
			count++;
		}
		return count;
	}
	public void addAtEnd(int data){
		Node n = new Node(data);
		
		if (head==null){
			n.next = head;
			head = n;
		}
		else{
			Node currNode = head;
			while(currNode.next!=null){
				//System.out.print("---->" + currNode.data);
				currNode = currNode.next;
			}
			currNode.next = n;
		}
	}
	public void display(){
		//System.out.println("");
		Node currNode = head;
		while(currNode!=null){
			System.out.print("->" + currNode.data);
			currNode=currNode.next;
		}
	}
	
	public static void main (String[] args) throws java.lang.Exception	{
		DeleteYNodesAfterXNodes a = new DeleteYNodesAfterXNodes();
		a.addAtEnd(10);a.addAtEnd(20);a.addAtEnd(30);
		a.addAtEnd(40);a.addAtEnd(50);a.addAtEnd(60);
		a.addAtEnd(70);a.addAtEnd(80);a.addAtEnd(90);
		a.addAtEnd(100);a.addAtEnd(110);a.addAtEnd(120);
		a.display();
		a.deleteYAfterX(5, 4);
		System.out.println("\nDeleted 4 Nodes after 5 Nodes");
		a.display();
	}
}
class Node{
	public int data;
	public Node next;
	public Node(int data){
		this.data = data;
		this.next = null;
	}
}
