package baodavi;
public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {

		if (strs == null || strs.length == 0) {
			return "";
		}

		int maxLen = 0;
		int index = 0;
		while (true) {
			boolean flag = true;
			char common = 0;
			for (int i = 0; i < strs.length; i++) {
				if (strs[i].length() > index) {
					if (common == 0) {
						common = strs[i].charAt(index);
					} else {
						if (common != strs[i].charAt(index)) {
							flag = false;
							break;
						}
					}
				} else {
					flag = false;
					break;
				}
			}
			if (!flag) {
				break;
			} else {
				maxLen++;
				index++;
			}
		}
		return strs[0].substring(0, maxLen);
	}
}
