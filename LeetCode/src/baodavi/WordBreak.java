package baodavi;
import java.util.Set;

public class WordBreak {
	public boolean wordBreak(String s, Set<String> dict) {
		if (s.isEmpty() || s.length() == 0) {
			return true; // special case, for empty string, we return true.
		}

		boolean[] res = new boolean[s.length() + 1];
		res[0] = true; // base case for iteration

		for (int i = 0; i < s.length(); i++) {
			String subStr = s.substring(0, i + 1);
			for (int j = 0; j <= i; j++) {
				if (res[j] && dict.contains(subStr.substring(j))) {
					res[i + 1] = true;
					break;
				}
			}
		}

		return res[s.length()]; // the last elem of the array stored the global
								// result
	}
}
