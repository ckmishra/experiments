import java.util.Scanner;

public class UtopianTree {
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		while (n > 0) {
			int cycle = s.nextInt();
			int height = 1;
			for (int i = 0; i < cycle; i++) {
				if (i % 2 == 0) {
					height = height * 2;
				}
				if (i % 2 == 1){
					height++;
				}

			}
			System.out.println(height);
			n--;
		}
	}
}
