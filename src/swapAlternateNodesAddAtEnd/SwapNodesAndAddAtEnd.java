package swapAlternateNodesAddAtEnd;

public class SwapNodesAndAddAtEnd {
	public static void main(String args[]){
		LinkedListT a = new LinkedListT();
		a.addAtEnd(1);a.addAtEnd(2);a.addAtEnd(3);
		a.addAtEnd(4);a.addAtEnd(5);a.addAtEnd(6);
		a.addAtEnd(7);a.addAtEnd(8);a.addAtEnd(9);
		a.addAtEnd(10);a.addAtEnd(11);a.addAtEnd(12);
		System.out.print("Original Link List 1 : ");
		a.display(a.head);
		Node n = a.solve(a.head);
		a.display(n);
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
class LinkedListT{
	public Node head;
	public LinkedListT(){
		head=null;
	}
	public Node solve(Node head){
			Node x = head;
			while(x!=null){
				x = x.next;
			}
			Node end = x;
			Swap(head,end);
			return head;
	}
	public Node Swap(Node head, Node end){
		if(head.next.next.next!=null){
				Node one = head.next;
				Node one_next = one.next;
				Node two = one.next.next;
				head.next = one.next;
				two.next = one;
				one.next = null;
				end.next = two;				
				one_next.next = Swap(one_next.next,one);
				return head;
			}
			else{
				return head;
			}
			
		}
	public Node reverseAlter2KNodes(Node head, int k){
		//process 2K nodes at a time
		//reverse till k nodes and set the the pointer to k+1
		int x = k;
		Node moving = head;
		Node head_prev = null;		
		Node head_next = null;
		while(x>0 && moving!=null){
			head_next = moving.next;
			moving.next = head_prev;
			head_prev = moving;
			moving = head_next;
			x--;
		}
		if(head!=null)
		head.next = moving;
		x =k;
		while(x>1 && moving!=null){
			moving = moving.next;
			x--;
		}
		if(moving!=null){
			moving.next = reverseAlter2KNodes(moving.next,k);
		}
		
		return head_prev;		
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
	public void display(Node head){
		Node currNode = head;
		while(currNode!=null){
			System.out.print("->" + currNode.data);
			currNode=currNode.next;
		}		
	}
}


