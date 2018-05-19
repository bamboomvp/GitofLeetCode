package baodavi;

public class SingleElementInSortedArray {
    public int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 1;
        while(low != high){
        	int mid = (high - low) / 2 + low;
        	boolean oddHalf = ((high - low) / 2) % 2 == 1;
        	if(oddHalf && nums[mid] == nums[mid - 1])
        		low = mid + 1;
        	else if(oddHalf && nums[mid] == nums[mid + 1])
        		high = mid - 1;
        	else if(!oddHalf && nums[mid] == nums[mid - 1])
        		high = mid - 2;
        	else if(!oddHalf && nums[mid] == nums[mid + 1])
        		low = mid + 2;
        	else
        		return -1;
        }
        return nums[low];
    }
}
