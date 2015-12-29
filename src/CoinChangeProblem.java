import java.util.Scanner;

/**
 * finding change for given number using different possible combination of given
 * coin denomination.
 * 
 * @author chandan
 * 
 */
public class CoinChangeProblem {

	public static void main(String[] args) {
		/*
		 * reading input from console First line will contain 2 integer N and M
		 * respectively. Second line contain M integer that represent list of
		 * distinct coins that are available in infinite amount. Scanner s = new
		 * Scanner(System.in);
		 */
		Scanner s = new Scanner(System.in);
		int number = s.nextInt();
		int coin_deno_set = s.nextInt();
		int[] coinArray = new int[coin_deno_set];
		for (int i = 0; i < coin_deno_set; i++) {
			coinArray[i] = s.nextInt();
		}
		long max_comb_possible = findCoinChangeCombination(number, coinArray);
		System.out.println(max_comb_possible);
	}

	/**
	 * method for coin change algorithm using dynamic programming and building
	 * cost matrix
	 * 
	 * @param number
	 *            Given Number
	 * @param coinArray
	 *            set of possible coin denomination
	 * @return max possible way of coin changes
	 */
	private static long findCoinChangeCombination(int number, int[] coinArray) {

		int size = coinArray.length;
		long[][] costMatrix = new long[size + 1][number + 1];

		// first row making 0
		for (int j = 1; j <= number; j++) {
			costMatrix[0][j] = 0;
		}
		// first column making 1
		for (int j = 0; j <= size; j++) {
			costMatrix[j][0] = 1;
		}

		for (int i = 1; i <= size; i++) {
			for (int j = 1; j <= number; j++) {
				if (j < coinArray[i-1]) {
					costMatrix[i][j] = costMatrix[i - 1][j];
				}
				int rem = j - coinArray[i - 1];
				if (rem >= 0)
					costMatrix[i][j] = costMatrix[i - 1][j]
							+ costMatrix[i][rem];
			}
		}
		return costMatrix[size][number];
	}
}
