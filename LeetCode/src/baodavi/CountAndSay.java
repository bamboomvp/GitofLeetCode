package baodavi;

public class CountAndSay {

	private static StringBuilder sb = new StringBuilder();

	private String calculateNext(String curr) {
		sb.setLength(0);
		char posCurr = curr.charAt(0);
		int count = 1;
		for (int i = 1; i < curr.length(); i++) {
			if (curr.charAt(i) == posCurr) {
				count++;
			} else {
				sb.append(String.valueOf(count));
				sb.append(posCurr);
				posCurr = curr.charAt(i);
				count = 1;
			}
		}
		sb.append(String.valueOf(count));
		sb.append(posCurr);
		return sb.toString();
	}

	public String countAndSay(int n) {
		String pre = "1";
		String curr = "";
		if (n <= 0) {
			return "";
		}

		if (n == 1) {
			return pre;
		}

		for (int i = 2; i <= n; i++) {
			curr = calculateNext(pre);
			pre = curr;
		}

		return pre;
	}
}
