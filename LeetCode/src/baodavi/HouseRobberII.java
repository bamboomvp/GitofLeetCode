package baodavi;

/*
Note: This is an extension of House Robber.

After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
*/

public class HouseRobberII {
	// arranged in a circle, arranged in a circle, arranged in a circle, arranged in a circle, arranged in a circle
	// 那我们这里变通一下，如果我们把第一家和最后一家分别去掉，各算一遍能抢的最大值，然后比较两个值取其中较大的一个即为所求。
	public int rob(int[] num) {
		if(num == null || num.length == 0)
			return 0;
		else if(num.length == 1)
			return num[0];
		else if(num.length == 2)
			return Math.max(num[0], num[1]);
		
		// don't robber last one
		int[] DP = new int[num.length - 1];
		DP[0] = num[0];
		DP[1] = Math.max(num[0], num[1]);
		for(int i = 2; i < num.length - 1; i++)
			DP[i] = Math.max(DP[i-2] + num[i], DP[i-1]);
		
		int res1 = DP[num.length - 2];
		
		// don't robber first one
		int[] DP2 = new int[num.length - 1];
		DP2[0] = num[1];
		DP2[1] = Math.max(num[1], num[2]);
		for(int i = 2; i < num.length - 1; i++)
			DP2[i] = Math.max(DP2[i-2] + num[i+1], DP2[i-1]);
		
		int res2 = DP2[num.length - 2];
		
		return Math.max(res1, res2);
	}
}
