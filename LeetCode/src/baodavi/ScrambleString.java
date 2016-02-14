package baodavi;
import java.util.Arrays;

public class ScrambleString {

	public boolean isScramble(String s1, String s2) {
		char[] charSet1 = s1.toCharArray();
		char[] charSet2 = s2.toCharArray();
		Arrays.sort(charSet1);
		Arrays.sort(charSet2);

		if (s1.length() != s2.length()
				|| !(new String(charSet1)).equals(new String(charSet2))) {
			return false;
		} else if (s1.equals(s2)) {
			return true;
		} else {
			// base cases
			if (s2.length() == 0) {
				return true;
			} else if (s2.length() == 1) {
				return s1 == s2;
			} else if (s2.length() == 2) {
				return (s1.charAt(0) == s2.charAt(0) && s1.charAt(1) == s2
						.charAt(1))
						|| (s1.charAt(0) == s2.charAt(1) && s1.charAt(1) == s2
								.charAt(0));
			} else {
				// length >= 3, general case
				int baseNum = s1.length();
				for (int cases = 1; cases < baseNum; cases++) {
					String s1Part1 = s1.substring(0, cases);
					String s1Part2 = s1.substring(cases);

					String s2C1P1 = s2.substring(0, cases);
					String s2C1P2 = s2.substring(cases);
					String s2C2P1 = s2.substring(0, s2.length() - cases);
					String s2C2P2 = s2.substring(s2.length() - cases);

					if ((isScramble(s1Part1, s2C1P1) && isScramble(s1Part2,
							s2C1P2))
							|| (isScramble(s1Part1, s2C2P2) && isScramble(
									s1Part2, s2C2P1))) {
						return true;
					}
				}
				return false;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
