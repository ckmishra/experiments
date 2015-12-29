import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

class Prim {
	int no_vertices, no_edges;

	Prim(int n, int m) {
		no_vertices = n;
		no_edges = m;
	}

	public void findShortestPath(Integer[][] adjMatrix, int start) {
		HashSet<Integer> visitedNode = new HashSet<Integer>();
		Boolean[] flag = new Boolean[adjMatrix.length];
		for (int i = 0; i < flag.length; i++) {
			flag[i] = false;
		}
		visitedNode.add(start - 1);
		flag[start - 1] = true;
		int maxLength = 0;

		while (visitedNode.size() != adjMatrix.length) {
			int min = 1000000;
			int index = 0;
			Iterator<Integer> ind = visitedNode.iterator();
			int test = 0;
			while (ind.hasNext()) {
				int m = ind.next();
				Integer[] s = adjMatrix[m];
				for (int j = 0; j < s.length; j++) {
					if (s[j] != 0 && s[j] < min && flag[j] == false) {
						min = s[j];
						index = j;
						test = m;
					}
				}
			}
			flag[index] = true;
			adjMatrix[test][index] = 0;
			adjMatrix[index][test] = 0;
			maxLength = maxLength + min;
			visitedNode.add(index);
		}
		System.out.println(maxLength);

	}
}

public class Prims {

	public static void main(String[] args) {
		final int INT_MAX = 0;
		Scanner s = new Scanner(System.in);
		int n = s.nextInt(); // number of nodes
		int m = s.nextInt();// number of edges
		Prim graph = new Prim(n, m);
		Integer[][] adjMatrix = new Integer[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(adjMatrix[i], INT_MAX);
		}

		for (int i = 0; i < m; i++) {
			int u = s.nextInt();
			int v = s.nextInt();
			int w = s.nextInt();
			adjMatrix[u - 1][v - 1] = w;
			adjMatrix[v - 1][u - 1] = w;
		}
		int start = s.nextInt();
		graph.findShortestPath(adjMatrix, start);

	}
}
