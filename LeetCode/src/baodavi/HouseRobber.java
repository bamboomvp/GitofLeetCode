package baodavi;

public class HouseRobber {
	public int rob(int[] num) {
		/*
		 * dp[i] = max(num[i] + dp[i - 2], dp[i - 1])
		 */
		if (num == null || num.length == 0) {
			return 0;
		}
		if (num.length == 1) {
			return num[0];
		}
		if (num.length == 2) {
			return (num[0] >= num[1]) ? num[0] : num[1];
		}

		int[] dp = new int[num.length];
		dp[0] = num[0];
		dp[1] = (num[0] >= num[1]) ? num[0] : num[1];
		for (int i = 2; i < num.length; i++) {
			dp[i] = Math.max(num[i] + dp[i - 2], dp[i - 1]);
		}

		return dp[num.length - 1];
	}
}
