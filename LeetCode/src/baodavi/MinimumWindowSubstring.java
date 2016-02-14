package baodavi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MinimumWindowSubstring {

	public String minWindow(String S, String T) {

		// special cases
		if (S == null || S.length() == 0) {
			return "";
		} else if (T == null || T.length() == 0) {
			return "";
		} else if (S.length() < T.length()) {
			return "";
		}

		// initial phase
		Map<Character, Integer> lookup = new HashMap<Character, Integer>();
		for (int i = 0; i < T.length(); i++) {
			if (lookup.containsKey(T.charAt(i))) {
				lookup.put(T.charAt(i), lookup.get(T.charAt(i)) + 1);
			} else {
				lookup.put(T.charAt(i), 1);
			}
		}

		int left = 0;
		int count = 0;
		int minLen = S.length() + 1;
		int minStart = 0;
		for (int right = 0; right < S.length(); right++) {
			if (lookup.containsKey(S.charAt(right))) {
				lookup.put(S.charAt(right), lookup.get(S.charAt(right)) - 1);
				if (lookup.get(S.charAt(right)) >= 0) {
					count++;
				}

				while (count == T.length()) {
					if (right - left + 1 < minLen) {
						minLen = right - left + 1;
						minStart = left;
					}
					if (lookup.containsKey(S.charAt(left))) {
						lookup.put(S.charAt(left),
								lookup.get(S.charAt(left)) + 1);
						if (lookup.get(S.charAt(left)) > 0) {
							count--;
						}
					}
					left++;
				}
			}
		}
		if (minLen > S.length()) {
			return "";
		}
		return S.substring(minStart, minStart + minLen);
	}

	public static void main(String[] argv) {
		MinimumWindowSubstring ins = new MinimumWindowSubstring();
		ins.minWindow("abc", "c");
	}
}
