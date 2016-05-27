package baodavi;

public class RangeSumQueryImmutable {
	
	private int[] DP;
	
    public RangeSumQueryImmutable(int[] nums) {
        DP = new int[nums.length + 1];
        DP[0] = 0;
        for(int i = 0; i < nums.length; i++){
        	DP[i + 1] = DP[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
    	return DP[j + 1] - DP[i];
    }
}

// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
/*
public class NumArray {
    private int[] dp;
    public NumArray(int[] nums) {
        dp = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            dp[i] = sum;
        }
    }

    public int sumRange(int i, int j) {
        return i == 0 ? dp[j] : dp[j] - dp[i - 1];
    }
}
*/