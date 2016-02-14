package baodavi;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakII {
	private boolean wordBreakPreCheck(String s, Set<String> dict) {
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

	private void wordBreakHelper(String subStr, Set<String> dict,
			List<String> currRes, List<String> res, StringBuilder sb) {
		if (subStr.isEmpty() || subStr.length() == 0) {
			for (int i = 0; i < currRes.size(); i++) {
				sb.append(currRes.get(i));
				if (i != currRes.size() - 1) {
					sb.append(" ");
				}
			}
			String oneRes = sb.toString();
			res.add(oneRes);
			sb.setLength(0); // reset the string builder
			return;
		}

		for (int j = 1; j <= subStr.length(); j++) {
			String curr = subStr.substring(0, j);
			String rest = subStr.substring(j);
			if (dict.contains(curr)) {
				currRes.add(curr);
				wordBreakHelper(rest, dict, currRes, res, sb);
				currRes.remove(currRes.size() - 1);
			}
		}

		return;
	}

	public List<String> wordBreak(String s, Set<String> dict) {

		List<String> res = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		if (s.isEmpty() || s.length() == 0) {
			return res; // special case, just return the empty list
		}

		// check first to see if there is a solution
		if (wordBreakPreCheck(s, dict)) {
			wordBreakHelper(s, dict, new ArrayList<String>(), res, sb);
		}

		return res;
	}

	public static void main(String args[]) {
		WordBreakII ins = new WordBreakII();
		Set<String> dict = new HashSet<String>();
		dict.add("b");
		List<String> res = ins.wordBreak("a", dict);
	}
}
