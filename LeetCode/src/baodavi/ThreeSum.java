package baodavi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
    	List<List<Integer>> res = new ArrayList<>();
    	if(nums == null || nums.length == 0){
    		return res;
    	}else if(nums.length < 3){
    		return res;
    	}else{
    		Arrays.sort(nums);
    		for(int smallest = 0; smallest < nums.length - 2; smallest++){
    			if(smallest != 0 && nums[smallest] == nums[smallest - 1])	continue;
    			else{
    				int ptr1 = smallest + 1;
    				int ptr2 = nums.length - 1;
    				while(ptr1 < ptr2){
    					if(nums[ptr1] + nums[ptr2] + nums[smallest] == 0){
    						res.add(Arrays.asList(nums[smallest], nums[ptr1], nums[ptr2]));
    						while (ptr1 < ptr2 && nums[ptr1] == nums[ptr1+1]) ptr1++;
    	                    while (ptr1 < ptr2 && nums[ptr2] == nums[ptr2-1]) ptr2--;
    						ptr1++;
    						ptr2--;
    					}else if(nums[ptr1] + nums[ptr2] + nums[smallest] > 0){
    						ptr2--;
    					}else{
    						ptr1++;
    					}
    				}
    			}
    		}
    		return res;
    	}
    }
}
