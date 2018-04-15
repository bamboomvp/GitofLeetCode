package baodavi;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        for(int i = 0; i < nums.length; i++){
        	if(nums[i] == i)	continue;
        	else if(nums[i] == nums.length) continue;
        	else{
        		int tmp = nums[nums[i]];
        		nums[nums[i]] = nums[i];
        		nums[i] = tmp;
        		i--;
        	}
        }
        int missing = -1;
        for(int j = 0; j < nums.length; j++){
        	if(nums[j] != j){
        		missing = j;
        		break;
        	}
        }
        return missing == -1 ? nums.length : missing;
    }
}
