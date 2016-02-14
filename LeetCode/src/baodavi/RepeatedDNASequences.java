package baodavi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedDNASequences {

	private int encoding(char c) {
		if (c == 'A') {
			return 0;
		} else if (c == 'C') {
			return 1;
		} else if (c == 'G') {
			return 2;
		} else if (c == 'T') {
			return 3;
		} else {
			throw new IllegalStateException();
		}
	}

	private String decoding(int n) {
		int mask = 3;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			int tmp = n & mask;
			switch (tmp) {
			case 0:
				sb.append('A');
				break;
			case 1:
				sb.append('C');
				break;
			case 2:
				sb.append('G');
				break;
			case 3:
				sb.append('T');
				break;
			}
			n = n >> 2;
		}
		sb.reverse();
		return sb.toString();
	}

	public List<String> findRepeatedDnaSequences(String s) {

		List<String> res = new ArrayList<String>();

		// special case
		if (s == null || s.length() <= 10) {
			return res;
		}

		Map<Integer, Boolean> bookkeeping = new HashMap<Integer, Boolean>();

		// initialize
		int currEncoded = 0;
		for (int i = 0; i < 10; i++) {
			currEncoded = currEncoded << 2;
			currEncoded |= encoding(s.charAt(i));
		}
		bookkeeping.put(currEncoded, false);

		// the main logic
		int magic = (int) (Math.pow(2, 20) - 1);
		for (int j = 10; j < s.length(); j++) {
			currEncoded = currEncoded << 2;
			currEncoded |= encoding(s.charAt(j));
			currEncoded &= magic;
			if (bookkeeping.containsKey(currEncoded)) {
				bookkeeping.put(currEncoded, true);
			} else {
				bookkeeping.put(currEncoded, false);
			}
		}

		// decoding phase
		for (Integer key : bookkeeping.keySet()) {
			if (bookkeeping.get(key)) {
				res.add(decoding(key));
			}
		}

		return res;
	}
}
