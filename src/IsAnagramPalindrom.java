import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class IsAnagramPalindrom {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String inputString = scan.nextLine();
		Map<Character, Integer> baseTable = new HashMap<>();

		for (int i = 0; i < inputString.length(); i++) {
			char c = inputString.charAt(i);
			if (baseTable.get(c) != null)
				baseTable.put(c, baseTable.get(c) + 1);
			else
				baseTable.put(c, 1);
		}
		int count = 0;
		for (int i : baseTable.values()) {
			if (i % 2 != 0) {
				count++;
			}
		}

		String ans = null;
		if (inputString.length() % 2 == 0) {
			ans = (count ==0) ? "YES" : "NO";
		} else if (inputString.length() % 2 != 0) {
			ans = (count == 1) ? "YES" : "NO";
		}
		System.out.println(ans);
	}
}
