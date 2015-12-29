import java.util.Arrays;

public class LIS {

	static int findLIS(int[] s) {
		int[] lookUp = new int[s.length];
		// populate all element of lookupArray to 1
		for (int i = 0; i < lookUp.length; i++) {
			lookUp[i] = 1;
		}

		for (int i = 1; i < s.length; i++) {
			for (int j = 0; j < i; j++) {
				if (s[i] > s[j] && lookUp[i] < lookUp[j] + 1) {
					lookUp[i] = lookUp[j] + 1;
				} else {
					lookUp[i] = lookUp[j];
				}
			}
		}
		Arrays.sort(lookUp);

		return lookUp[lookUp.length - 1];
	}
}
