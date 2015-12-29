import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Set;

public class Compression {

	public static void main(String[] args) throws IOException {
		System.out.println(compress("aaaaabbbbbaacdeefAfgghhggB"));	
	}

	private static String compress(String str) {
		
		String compressedString = "";
		LinkedHashMap<Character, Integer> lookUp = new LinkedHashMap<>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (lookUp.get(c) == null) {
				lookUp.put(c, 1);
			} else {
				int oldCount = lookUp.get(c);
				lookUp.put(c, oldCount + 1);
			}
		}
		// getting all keys and iterating
		Set<Character> keys = lookUp.keySet();
		for (Character key : keys) {
			int value = lookUp.get(key);
			if ((Integer) value != 1) {
				compressedString = compressedString + key + value;
			} else {
				compressedString = compressedString + key;
			}
		}
		return compressedString;
	}
}
