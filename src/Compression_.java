import java.io.IOException;
import java.util.ArrayList;

public class Compression_ {

	public static void main(String[] args) throws IOException {
		System.out.println(compress("aabbcacaad"));
	}

	private static String compress(String str) {
		ArrayList<String> output = new ArrayList<>();

		for (int i = 0; i < str.length(); i++) {
			output.add(String.valueOf(str.charAt(i)));

			Integer rLen = 1;
			while (i + 1 < str.length() && str.charAt(i) == str.charAt(i+1)) {
				rLen++;
				i++;
			}
			if(rLen >1)
			output.add(String.valueOf(rLen));
		}
		String temp = "";
		for(String s: output){
			temp = temp + s;
		}
		return temp;
	}

}
