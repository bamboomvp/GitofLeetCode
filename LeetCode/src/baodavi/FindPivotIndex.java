package baodavi;

public class FindPivotIndex {
	
//	先求出数组的总和，然后维护一个当前数组之和curSum，
//	然后对于遍历到的位置，用总和减去当前数字，看得到的结果是否是curSum的两倍，
//	是的话，那么当前位置就是中枢点，返回即可；否则就将当前数字加到curSum中继续遍历，遍历结束后还没返回，说明没有中枢点，返回-1即可
	public int pivotIndexUpdate(int[] nums) {
		int totalSum = 0;
		for(int i = 0; i < nums.length; i++)
			totalSum += nums[i];
		int currSum = 0;
		for(int j = 0; j < nums.length; j++){
			if(totalSum - nums[j] == 2 * currSum)		return j;
			currSum += nums[j];
		}
		return -1;
	}
	
    public int pivotIndex(int[] nums) {
        if(nums == null || nums.length == 0)	return -1;
        else if(nums.length == 1)					return 0;
        
        int[] sumFromLeft = new int[nums.length];
        int[] sumFromRight = new int[nums.length];
        int runningSum = 0;
        for(int j = nums.length - 1; j >= 0; j--){
        	runningSum += nums[j];
        	sumFromRight[j] = runningSum;
        }
        runningSum = 0;
        for(int i = 0; i < nums.length; i++){
        	runningSum += nums[i];
        	sumFromLeft[i] = runningSum;
        	if(i == 0){
        		if(sumFromRight[i + 1] == 0)	return i;
        	}else if(i == nums.length - 1){
        		if(sumFromLeft[i - 1] == 0)		return i;
        	}else{
        		if(sumFromLeft[i - 1] == sumFromRight[i + 1]) return i;
        	}
        }
        return -1;
    }
}
