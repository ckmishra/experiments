import java.util.Arrays;
import java.util.Scanner;

public class SherlockMiniMax {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] inputArray = new int[n];
		for (int i = 0; i < inputArray.length; i++) {
			inputArray[i] = s.nextInt();
		}
		int p = s.nextInt();
		int q = s.nextInt();

		int output = MiniMax(inputArray, p, q);
		System.out.println(output);
	}

	private static int MiniMax(int[] inputValue, int p, int q) {
		Arrays.sort(inputValue);
		int maxDiffGlobal = 0;
		int result =0;
		for (int i = p; i <= q; i++) {
			int diff = Math.abs(i - inputValue[0]);
			if (maxDiffGlobal < diff) {
				maxDiffGlobal = diff;
			    result=p;
			}
		}
		return result;
	}

}
