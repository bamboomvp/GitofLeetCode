package baodavi;

import java.util.Arrays;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int size = nums.length;
        return nums[size / 2];
    }
    
    public int majorityElementBetter(int[] nums) {
    	int res = nums[0];
    	int cnt = 1;
    	for(int i = 1; i < nums.length; i++){
    		if(nums[i] == res)	cnt++;
    		else{
    			cnt--;
    			if(cnt == 0){
    				res = nums[i];
    				cnt++;
    			}
    		}
    	}
    	return res;
    }
}
