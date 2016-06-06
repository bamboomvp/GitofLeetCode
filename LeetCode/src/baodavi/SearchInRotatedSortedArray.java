package baodavi;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0)
        	return -1;
        if(nums.length == 1)
        	return (nums[0] == target) ? 0 : -1;
        
        int low, high, mid;
        low = 0;
        high = nums.length - 1;
        while(low < high){
        	mid = low + ((high - low) / 2);
        	if(nums[mid] == target)
        		return mid;
        	else{
        		if(nums[low] < nums[high]){
        			if(nums[mid] < target)
        				low = mid + 1;
        			else
        				high = mid - 1;
        		}else{
	        		if(nums[low] <= nums[mid]){
	        			if(nums[mid] < target)
	        				low = mid + 1;
	        			else{
	        				if(nums[low] <= target)
	        					high = mid - 1;
	        				else
	        					low = mid + 1;
	        			}
	        		}else{
	        			if(nums[mid] > target)
	        				high = mid - 1;
	        			else{
	        				if(nums[high] >= target)
	        					low = mid + 1;
	        				else
	        					high = mid - 1;
	        			}
	        		}
        		}
        	}
        }
        
        if(low == high)
        	return (nums[low] == target) ? low : -1;
        else
        	return -1;
    }
}
