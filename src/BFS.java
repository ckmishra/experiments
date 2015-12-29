import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class BFS {
	private int vertices;
	private LinkedList<Integer>[] addjencyList;

	BFS(int v) {
		vertices = v;
		addjencyList = new LinkedList[v + 1];
		for (int i = 0; i <= v; i++) {
			addjencyList[i] = new LinkedList<Integer>();
		}
	}

	// adding edge
	public void addEdge(int v, int w) {
		addjencyList[v].add(w);
	}

	// doing dfs
	public void bfs(int start) {
		Integer[] result = new Integer[vertices + 1];
		boolean visited[] = new boolean[vertices + 1];
		visited[start] = true;
		result[start] = 0;
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		while (!queue.isEmpty()) {
			int q =queue.poll();
			ListIterator<Integer> neighbour = addjencyList[q]
					.listIterator();
			while (neighbour.hasNext()) {
				int n = neighbour.next();

				if (!visited[n]) {
					queue.add(n);
					visited[n] = true;
					result[n] = result[q] + 6 ;
				}
			}
		}
		for (int i = 1; i < result.length; i++) {
			if (result[i] == null) {
				result[i] = -1;
			}
			if (i != start)
				System.out.print(result[i] + " ");
		}
		System.out.println();
	}

	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int num_testCases = s.nextInt();

		while (num_testCases-- > 0) {
			int n = s.nextInt();
			int m = s.nextInt();
			BFS graph = new BFS(n);
			for (int i = 0; i < m; i++) {
				int v = s.nextInt();
				int w = s.nextInt();
				graph.addEdge(v, w);
				graph.addEdge(w, v);
			}
			int start = s.nextInt();
			graph.bfs(start);
		}

	}
}