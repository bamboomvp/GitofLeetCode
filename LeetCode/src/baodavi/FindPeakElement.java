package baodavi;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0)
        	return -1;
        
        int left, right;
        for(int i = 0; i < nums.length; i++){
        	if(i - 1 >= 0)
        		left = nums[i - 1];
        	else
        		left = Integer.MIN_VALUE;
        	if(i + 1 < nums.length)
        		right = nums[i + 1];
        	else
        		right = Integer.MIN_VALUE;
        	
        	if(nums[i] > left && nums[i] > right)
        		return i;
        }
        return -1;
    }
    
    // Your solution should be in logarithmic complexity.
    public int findPeakElementAdvanced(int[] nums) {
        if(nums == null || nums.length == 0)
        	return -1;
        
        int low, high, curr;
        low = 0;
        high = nums.length - 1;
        while(low <= high){
        	curr = (low + high) / 2;
        	int left, right;
        	if(curr == 0)
        		left = Integer.MIN_VALUE;
        	else
        		left = nums[curr - 1];
        	
        	if(curr == nums.length - 1)
        		right = Integer.MIN_VALUE;
        	else
        		right = nums[curr + 1];
        	
        	if(nums[curr] >= left && nums[curr] >= right)
        		return curr;
        	else if(nums[curr] < left){
        		high = curr - 1;
        	}else if(nums[curr] < right){
        		low = curr + 1;
        	}
        }
        return -1;
    }
}
