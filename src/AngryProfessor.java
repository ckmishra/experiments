import java.util.Scanner;

public class AngryProfessor {

	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int numTests = s.nextInt();
		while (numTests > 0) {
			int n = s.nextInt();
			int k = s.nextInt();
			for (int i = 0; i < n; i++) {
				if (Integer.valueOf(s.next()) <= 0) {
					k--;
				}
			}
			if (k <= 0) {
				System.out.println("NO");

			} else {
				System.out.println("YES");
			}
			numTests--;
		}
	}
}
