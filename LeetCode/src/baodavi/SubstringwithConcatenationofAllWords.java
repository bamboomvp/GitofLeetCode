package baodavi;
import java.util.ArrayList;
import java.util.List;

public class SubstringwithConcatenationofAllWords {
	public List<Integer> findSubstring(String S, String[] L) {
		List<Integer> res = new ArrayList<Integer>();
		if (S == null || S.length() == 0) {
			return res;
		} else if (L == null || L.length == 0 || L[0] == null
				|| L[0].length() == 0) {
			return res;
		}

		int wordLen = L[0].length();
		int wordNum = L.length;

		if (S.length() < wordNum * wordLen) {
			return res;
		}

		for (int i = 0; i < S.length(); i++) {
			if (i + wordNum * wordLen > S.length()) {
				break;
			}
			boolean[] checker = new boolean[wordNum];
			for (int j = 0; j < wordNum; j++) {
				String curr = S.substring(i + j * wordLen, i + j * wordLen
						+ wordLen);
				for (int k = 0; k < L.length; k++) {
					if (curr.equals(L[k]) && !checker[k]) {
						checker[k] = true;
					}
				}
			}

			boolean flag = true;
			for (int x = 0; x < checker.length; x++) {
				if (!checker[x]) {
					flag = false;
					break;
				}
			}
			if (flag) {
				res.add(i);
			}
		}

		return res;
	}
}
