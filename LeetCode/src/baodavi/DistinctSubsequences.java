package baodavi;

/*
 这道题首先引用我忘记在哪里看到的一句话：
 “When you see string problem that is about subsequence or matching, dynamic programming method should come to your mind naturally. ”
 所以这种类型题可以多往DP思考思考。
 */

public class DistinctSubsequences {
	public int numDistinct(String s, String t) {
		int[][] dp = new int[s.length() + 1][t.length() + 1];
		dp[0][0] = 1;// initial

		for (int j = 1; j <= t.length(); j++)// S is empty
			dp[0][j] = 0;

		for (int i = 1; i <= s.length(); i++)// T is empty
			dp[i][0] = 1;

		for (int i = 1; i <= s.length(); i++) {
			for (int j = 1; j <= t.length(); j++) {
				dp[i][j] = dp[i - 1][j];
				if (s.charAt(i - 1) == t.charAt(j - 1))
					dp[i][j] += dp[i - 1][j - 1];
			}
		}

		return dp[s.length()][t.length()];
	}
}
