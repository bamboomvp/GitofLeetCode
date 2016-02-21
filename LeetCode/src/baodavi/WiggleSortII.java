package baodavi;

import java.util.Arrays;

public class WiggleSortII {
	
	public void wiggleSort(int[] nums) {
		
		if(nums.length < 2)
			return;
		
		int[] snums = Arrays.copyOf(nums, nums.length);
		Arrays.sort(snums);
		
		int k = snums.length - 1;
		
		for(int i = 1; i < nums.length; i += 2){
			nums[i] = snums[k];
			k--;
		}
		
		for(int j = 0; j < nums.length; j += 2){
			nums[j] = snums[k];
			k--;
		}
	}
	
    public void wiggleSort_WRONG(int[] nums) {
        
    	if(nums.length < 2)
    		return;
    	
    	if(nums.length == 2){
    		if(nums[0] < nums[1])
    			return;
    		else{
    			int tmp = nums[1];
    			nums[1] = nums[0];
    			nums[0] = tmp;
    		}
    	}
    	
    	Arrays.sort(nums);
    	
    	for(int i = 1; i < nums.length; i += 2){
    		int k = i + 1;
    		while(k < nums.length){
    			if(nums[i] != nums[k])
    				break;
    			else
    				k++;
    		}
    		
    		if(k >= nums.length && i != nums.length - 1)
    			throw new RuntimeException();
    		else if(k >= nums.length && i == nums.length - 1)
    			break;
    		
    		int tmp = nums[k];
    		nums[k] = nums[i];
    		nums[i] = tmp;
    	}
    }
}
