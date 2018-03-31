package baodavi;

public class MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {
        int maxSum = Integer.MIN_VALUE;
        int[] prefixSum = new int[nums.length];
        int runningSum = 0;
        for(int i = 0; i < nums.length; i++){
        	runningSum += nums[i];
        	prefixSum[i] = runningSum;
        }
        for(int j = 0; j + k <= nums.length; j++){
        	if(j == 0)	maxSum = Math.max(maxSum, prefixSum[j + k - 1]);
        	else			maxSum = Math.max(maxSum, prefixSum[j + k - 1] - prefixSum[j - 1]);
        }
        return maxSum / (double) k;
    }
}
