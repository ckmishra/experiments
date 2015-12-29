import java.math.BigInteger;
import java.util.Scanner;

public class FibnociModified {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int b = s.nextInt();
		int n = s.nextInt();
		FibnociModified fib = new FibnociModified();
		System.out.println(fib.findNumber(a, b, n));

	}

	BigInteger findNumber(int a, int b, int n) {
		BigInteger[] lookup = new BigInteger[n];
		lookup[0] = BigInteger.valueOf(a);
		lookup[1] = BigInteger.valueOf(b);
		for (int i = 2; i < n; i++) {
			lookup[i] = lookup[i - 1].pow(2).add(lookup[i - 2]);
		}
		return lookup[n - 1];
	}
}
