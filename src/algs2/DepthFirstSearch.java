package algs2;

public class DepthFirstSearch extends Searcher {
	public DepthFirstSearch(Graph graph, int source) {
		super(graph, source);
		
		dfs(source);
	}

	private void dfs(int v) {
		marked[v] = true;

		Iterable<Integer> adj = graph.getAdjacents(v);
		for (Integer w : adj) {
			if (!marked[w]) {
				dfs(w);
				
				edgeTo[w] = v;
			}
		}
	}
}