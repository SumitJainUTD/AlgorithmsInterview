package VerticalOrderSumTree;
import java.util.Set;
import java.util.TreeMap;

public class VerticalOrderSum {
	public static TreeMap<Integer, Integer> ht = new TreeMap<>();;
	public static int  level;
	public int vertical(Node root, int level, boolean leftCall){
		if(root!=null){
			level = vertical(root.left,++level, true);
			//System.out.println("level " + level + " data " + root.data);
			
			if(ht.get(level)!=null){
				int x = ht.get(level) ;
				//System.out.println(" Entering " + x + " level " + level );
				ht.put(level, root.data+x);
			}else{
				ht.put(level, root.data);
			}			
			vertical(root.right,--level,false);
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
			System.out.println("Level " + keys + " Sum : " + ht.get(keys));
		}
//		while(it.hasNext()){
//			System.out.println(it.next());
//		}
	}
	public static void main(String args[]){
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		VerticalOrderSum p = new VerticalOrderSum();
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

