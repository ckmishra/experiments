import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Dijkastra {
	int numVertices;
	int numEdges;
	static int INT_MAX = 10000;

	public Dijkastra(int verticesCount, int edgeCount) {
		numVertices = verticesCount;
		numEdges = edgeCount;
	}

	public void findShortestPath(Integer[][] adjMatrix, int start) {
		int[] distance = new int[numVertices];
		boolean[] isIncluded = new boolean[numVertices];
		// initialize
		for (int i = 0; i < numVertices; i++) {
			distance[i] = INT_MAX;
			isIncluded[i] = false;
		}
		distance[start - 1] = 0;
		//
		for (int i = 0; i < numVertices - 1; i++) {
			int u = pickElement(distance, isIncluded);

			isIncluded[u] = true;

			// update
			for (int v = 0; v < numVertices; v++) {
				if (!isIncluded[v] && adjMatrix[u][v] != 0
						&& distance[u] != INT_MAX
						&& distance[v] > distance[u] + adjMatrix[u][v]) {
					distance[v] = distance[u] + adjMatrix[u][v];
				}
			}

		}
		printDistance(distance);
	}

	private void printDistance(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == INT_MAX) {
				array[i] = -1;
			}
			if (array[i] != 0) {
				System.out.print(array[i] + " ");

			}
		}
		System.out.println();
	}

	private int pickElement(int[] distance, boolean[] isIncluded) {
		int min = INT_MAX;
		int minIndex = 0;
		for (int v = 0; v < numVertices; v++) {
			if (distance[v] <= min && isIncluded[v] == false) {
				min = distance[v];
				minIndex = v;
			}
		}

		return minIndex;
	}

	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int num_testCases = s.nextInt();
		while (num_testCases  > 0) {
			int n = s.nextInt();
			int m = s.nextInt();
			Dijkastra graph = new Dijkastra(n, m);
			Integer[][] adjMatrix = new Integer[n][n];
			for (int i = 0; i < n; i++) {
				Arrays.fill(adjMatrix[i], 0);
			}

			for (int i = 0; i < m; i++) {
				int u = s.nextInt();
				int v = s.nextInt();
				int w = s.nextInt();
				int t = adjMatrix[u - 1][v - 1];
				//int z = adjMatrix[v - 1][u - 1];
				if (t == 0) {
					adjMatrix[u - 1][v - 1] = w;
					adjMatrix[v - 1][u - 1] = w;
				} else {
					if (t > w) {
						adjMatrix[u - 1][v - 1] = w;
						adjMatrix[v - 1][u - 1] = w;
					}
				}
			}
			int start = s.nextInt();
			graph.findShortestPath(adjMatrix, start);
			num_testCases--;
		}

	}
}