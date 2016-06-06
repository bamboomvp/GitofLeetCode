package baodavi;

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0)
        	return -1;
        if(nums.length == 1)
        	return nums[0];
        if(nums[0] < nums[nums.length - 1])
        	return nums[0];
        
        int low, high, mid;
        low = 0;
        high = nums.length - 1;
        while(high - low != 1){
        	mid = low + ((high - low) / 2);
        	if(nums[low] < nums[mid])
        		low = mid;
        	else
        		high = mid;
        }
        
        if(nums[low] < nums[high])
        	return nums[low];
        else
        	return nums[high];
    }
}
