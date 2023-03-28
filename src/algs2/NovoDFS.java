package algs2;

import java.util.Iterator;
import java.util.Stack;

public class NovoDFS extends Searcher {
	public NovoDFS(Graph graph, int source) {
		super(graph, source);
		
		ndfs(source);
	}
	
	public void ndfs(int v) {
		Stack<Integer> stack = new Stack<>();
		
		stack.push(v);
		while(!stack.isEmpty()) {
			
			v = stack.peek();
			stack.pop();
			
			if(!marked[v]) {
				System.out.print(v + " ");
				marked[v] = true;
			}
			
			Iterator<Integer> adj = graph.getAdjacents(v).iterator();
			while(adj.hasNext()) {
				int a = adj.next();
				
				if(!marked[a]) {
					stack.push(a);
				}
			}
		}
		
		
	}
}
