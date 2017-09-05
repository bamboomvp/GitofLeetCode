package baodavi;

public class MinimumSizeSubarraySum {
    public int minSubArrayLenBinarySearch(int s, int[] nums) {
    	if(nums == null || nums.length == 0)	return 0;
    	
    	int res = Integer.MAX_VALUE;
    	int[] sums = new int[nums.length];
    	int sumRunning = 0;
    	for(int i = 0; i < nums.length; i++){
    		sumRunning += nums[i];
    		sums[i] = sumRunning;
    	}
    	for(int x = 0; x < nums.length; x++){
    		// special case, itself
    		if(nums[x] >= s){
    			res = Math.min(res, 1);
    			break;
    		}
    		
    		int target = (x == 0) ? s : (s + sums[x - 1]);
    		int found = binarySearchHelper(target, x + 1, nums.length - 1, sums);
        	if(found > nums.length - 1)	break; // can't find...
    		else	res = Math.min(res, found + 1 - x);
    	}
    	return (res == Integer.MAX_VALUE) ? 0 : res;
    }
    
    private int binarySearchHelper(int target, int low, int high, int[] sums){
    	if(low > high){
    		return low;
    	}
    	
    	int mid = low + (high - low) / 2;
    	if(sums[mid] == target)	return mid;
    	else if(sums[mid] < target)	return binarySearchHelper(target, mid + 1, high, sums);
    	else return binarySearchHelper(target, low, mid - 1, sums);
    }
    
    public int minSubArrayLenTwoPtrTech(int s, int[] nums) {
        if(nums == null || nums.length == 0)	return 0;
        
        int res = Integer.MAX_VALUE;
        int runner, keeper;
        runner = keeper = 0;
        int sum = 0;
        while(runner < nums.length){
        	sum += nums[runner];
        	while(sum >= s){
        		res = Math.min(res, runner + 1 - keeper);
        		sum -= nums[keeper++];
        	}
        	runner++;
        }
        return (res == Integer.MAX_VALUE) ? 0 : res;
    }
}
