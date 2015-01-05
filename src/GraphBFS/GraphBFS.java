package GraphBFS;

import java.util.LinkedList;
import java.util.Queue;

public class GraphBFS {
	public static void main(String args[]) {
		Graph g = new Graph(5);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(3, 4);
		g.addEdge(2, 3);
		g.addEdge(4, 0);
		g.addEdge(4, 1);
		g.BFS(g, 0);
		
		Node head = g.array[4].head;
		while(head!=null){
			System.out.println(head.src + "  " + head.dest);
			head = head.next;
		}
	}
}

class Node {
	int src;
	int dest;
	Node next;

	public Node(int s, int d) {
		src = s;
		dest = d;
		next = null;
	}
}

class adjList {
	Node head;
}

class Graph {
	int V;
	adjList[] array;

	public Graph(int V) {
		this.V = V;
		array = new adjList[V];

		for (int i = 0; i < V; i++) {
			array[i] = new adjList();
			array[i].head = null;
		}
	}

	public void addEdge(int src, int dest) {
		Node n = new Node(src, dest);
		n.next = array[src].head;
		array[src].head = n;
	}

	public void BFS(Graph g, int src) {
		boolean [] visited = new boolean[V];
		Queue<Node> q = new LinkedList<Node>();
		q.add(array[src].head);
		visited[src] = true;
		while (q.isEmpty() == false) {
			Node x = q.poll();
			Node curr = x;
			while (curr.next != null) {
				curr = curr.next;
				if(visited[curr.dest]==false){
					q.add(array[curr.dest].head);
					visited[curr.dest] = true;
				}
				
			}
			System.out.print(" " + x.dest);
		}
	}
}