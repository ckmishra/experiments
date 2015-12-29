import java.util.Scanner;

public class MaxSubarray {
	/*
	 * 1 8 -2 -3 4 -1 -2 1 5 -3
	 */
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		while (n > 0) {
			int elementSize = s.nextInt();
			int[] arrayInt = new int[elementSize];
			for (int i = 0; i < elementSize; i++) {
				arrayInt[i] = s.nextInt();
			}
			int max_contg = findMaxSubArray(arrayInt);
			int max_non_cont = findMaxSubArrayNonCont(arrayInt);

			if (max_contg > 0 || max_non_cont > 0)
				System.out.println(max_contg + " " + max_non_cont);
			else
				System.out.println(arrayInt[0] + " " + arrayInt[0]);
			n--;
		}
	}

	private static int findMaxSubArray(int[] arrayInt) {

		int max_so_far = 0;
		int max_ending_here = 0;
		for (int i = 0; i < arrayInt.length; i++) {
			max_ending_here = max_ending_here + arrayInt[i];
			if (max_ending_here < 0)
				max_ending_here = 0;
			else if (max_ending_here > max_so_far)
				max_so_far = max_ending_here;
		}

		return max_so_far;
	}

	private static int findMaxSubArrayNonCont(int[] arrayInt) {
		/*
		 * int[] lookUpArray = new int[arrayInt.length]; if (arrayInt[0] > 0)
		 * lookUpArray[0] = arrayInt[0]; else lookUpArray[0] = 0;
		 * 
		 * for (int i = 1; i < arrayInt.length; i++) { if (lookUpArray[i - 1] +
		 * arrayInt[i] > lookUpArray[i - 1]) { lookUpArray[i] = lookUpArray[i -
		 * 1] + arrayInt[i]; } else { lookUpArray[i] = lookUpArray[i - 1]; } }
		 * 
		 * return lookUpArray[arrayInt.length - 1];
		 */
		int positiveSum =0;
		for (int i = 0; i < arrayInt.length; i++) {
			if(arrayInt[i] > 0){
				positiveSum =positiveSum + arrayInt[i];
			}
		}
		return positiveSum;
	}
}
