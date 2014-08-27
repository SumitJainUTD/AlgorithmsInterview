package PrintVerticalOrderBinaryTree;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

public class VerticalOrder {
	public static TreeMap<Integer, ArrayList> ht = new TreeMap<>();;
	public static int  level;	
	public ArrayList<ArrayList> main = new ArrayList<>();
	public ArrayList<Integer> al;
	public int vertical(Node root, int level, boolean leftCall){
		if(root!=null){
			level = vertical(root.right,++level, true);
			//System.out.println("level " + level + " data " + root.data);
			
			if(ht.get(level)!=null){
				ArrayList x = ht.get(level) ;
				x.add(root.data);
				//System.out.println(" Entering " + x + " level " + level );
				ht.put(level, x);
			}else{
				al = new ArrayList<>();
				al.add(root.data);
				ht.put(level, al);
			}			
			vertical(root.left,--level,false);
			return level;
		}else if(leftCall){
			return --level;
		}else{
			return ++level;
		}
	}
	public void printResult(TreeMap ht){
//		Iterator it = ht.keySet().iterator();
		Set<Integer> i = ht.keySet();		
		for(int keys:i){
			System.out.println(ht.get(keys));
		}
	}
	public static void main(String args[]){
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		VerticalOrder p = new VerticalOrder();
		p.vertical(root, 0, false);
		p.printResult(ht);
		
		
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
class ListNode{
	int data;
	ListNode next;
	public ListNode(int data){
		this.data = data;
		next = null;
	}
}

