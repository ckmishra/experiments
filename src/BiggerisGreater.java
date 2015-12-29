import java.util.Scanner;

public class BiggerisGreater {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		while (n > 0) {
			String input = null;
			input = s.next();
			char[] tempArray = input.toCharArray();
			String output = findNext(tempArray);
			if (output.equals(input)) {
				System.out.println("no answer");
			} else {
				System.out.println(output);
			}
			n--;
		}
	}

	private static String findNext(char[] tempArray) {
		int len = tempArray.length;
		int swapIndex = 0;
		// finding pivot point 
		for (int i = len - 1; i > 0; i--) {
			if (tempArray[i - 1] < tempArray[i]) {
				swapIndex = i - 1;
				break;
			}
		}
		// finding next pivot
		char temp = tempArray[swapIndex];
		int index = 0;
		char swapChar;
		for (int i = swapIndex + 1; i < len; i++) {
			if (tempArray[i] > temp) {
				swapChar = tempArray[i];
				tempArray[swapIndex] = swapChar;
				index = i;
			}
		}
		tempArray[index] = temp;

		// if change then reverse else no need to reverse
		if (index > 0) {
			int i = swapIndex + 1;
			int j = len - 1;
			// reversing
			while (j > i) {
				if (tempArray[j] < tempArray[i]) {
					char c = tempArray[j];
					tempArray[j] = tempArray[i];
					tempArray[i] = c;
				}
				i++;
				j--;
			}
		}
		return String.valueOf(tempArray);
	}

}
