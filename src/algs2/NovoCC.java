package algs2;

import java.util.PriorityQueue;
import java.util.Queue;

public class NovoCC {
	private boolean[] marked;
	private int[] id;
	private int count;
	
	public NovoCC(Graph graph) {
		marked = new boolean[graph.getNumberOfVertices()];
		id = new int[graph.getNumberOfVertices()];
		for (int v = 0; v < id.length; v++) {
			if (!marked[v]) {
				bfs(graph, v);
				count++;
			}
//			for (int x = 0; x < marked.length; x ++) {
//				String res;
//				if(marked[x] == true) {
//					res = "t";
//				}
//				else {
//					res = "f";
//				}
//				System.out.print(res + ", ");
//				System.out.print(id[x] + ", ");
//				
//			}
//			
//			System.out.println();
		}
	}

	private void bfs(Graph graph, int v) {
		Queue<Integer> queue = new PriorityQueue<>();
		
		queue.add(v);
		marked[v] = true;
		
		while (!queue.isEmpty()) {
			Integer y = queue.poll();
			id[y] = count;
			Iterable<Integer> adj = graph.getAdjacents(y);
			for (Integer w : adj) {
				if (!marked[w]) {
					queue.add(w);
					marked[w] = true;
					
				}
			}
			
			for (int x = 0; x < marked.length; x ++) {
				String res;
				
				if(marked[x] == true) {
					res = "t";
				}
				else {
					res = "f";
				}
				System.out.print(res + " - ");
				System.out.print(id[x] + ", ");
				
			}
			
			System.out.println();
		}
	}
	
	public int count() {
		return count;
	}
	
	public int id(int v) {
		return id[v];
	}
	
	public int[] getId() {
		return id;
	}
	public boolean connected(int v, int w) {
		return id[v] == id[w];
	}
}

