package doublyLinkedList;

public class DoublyLinkedList {
	public static Node head=null; 
	public static Node tail = null;
	public static int size = 0;
	public void deleteNode(Node delNode){
		if(head==delNode){
			deleteatBegin();
		}else if (tail==delNode){
			deleteatEnd();
		}else{
			Node temp = delNode;
			delNode.prev.next = delNode.next;
			temp.next.prev = temp.prev;
		}
	}
	public void addAtBegin(int data){
		Node n = new Node(data);
		if(head==null){
			head = n;
			tail = n;
		}else{
			head.prev = n;
			n.next = head;
			head = n;
		}
		size++;
	}
//	public void 
	public void addAtEnd(int data){
		Node n = new Node(data);
		if(head==null){
			head = n;
			tail = n;
		}else{
			tail.next = n;
			n.prev = tail;
			tail = n;
		}
		size++;
	}
	public int deleteatBegin(){
		if(head==null)return -1;
		Node temp = head;
		head = head.next;
		head.prev = null;
		size--;
		return temp.data;		
	}
	public int deleteatEnd(){
		if(head==null)return -1;
		Node temp = tail;
		tail=tail.prev;
		tail.next = null;
		size--;
		return temp.data;
	}
	public int getSize(){
		return size;
	}
	public void print(){
		Node current = head;
		while(current!=null){
			System.out.print("  " + current.data);
			current = current.next;
		}
	}
	public void printBackwards(){
		Node current = tail;
		while(current!=null){
			System.out.print("  " + current.data);
			current = current.prev;
		}
	}
	public static void main(String agrs[]){
		DoublyLinkedList d = new DoublyLinkedList();
		d.addAtBegin(1);d.addAtBegin(2);d.addAtBegin(3);d.addAtEnd(4);
		d.print();
		System.out.println("\n size : " + d.getSize());
//		System.out.println("deleted data : " + d.deleteatBegin());
//		System.out.println("deleted data : " + d.deleteatEnd());
		d.print();
		System.out.println("\n size : " + d.getSize());
		d.deleteNode(d.head.next.next);
		d.print();
	}
	

}

class Node{
	int data;
	Node next;
	Node prev;
	public Node(int data){
		this.data =data;
		this.next = null;
		this.prev = null;
	}
}
