import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class GreedyLexico {

	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int numTests = s.nextInt();
		while (numTests > 0) {
			int n = s.nextInt();
			if(n==1){
				System.out.println("YES");
			}
			char[][] matrix = new char[n][n];
			for (int i = 0; i < n; i++) {
				char[] input = s.next().toCharArray();
				Arrays.sort(input);
				matrix[i] = input;
			}
			int i, j = 0;
			boolean flag=false;
			for (i = 0; i < n - 1; i++) {
				for (j = 0; j < n; j++) {
					if (matrix[i][j] > matrix[i + 1][j]) {
						flag=true;
						break;
					}
				}
				if(flag){
					System.out.println("NO");
					break;
				}
			}
			if (i == n - 1 && j == n)
				System.out.println("YES");
			numTests--;
		}
	}

}
