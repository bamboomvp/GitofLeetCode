package baodavi;

public class SearchForARange {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        if(nums == null || nums.length == 0)	return res;
        
        double target1 = target - 0.1;
        double target2= target + 0.1;
        
        int low, high, mid = Integer.MIN_VALUE;
        boolean flag = false;
        boolean check = false;
        for(int i = 1; i <= 3; i++){
            low = 0;
            high = nums.length - 1;
            while(low <= high){
            	mid = low + (high - low) / 2;
            	if(i == 1){
            		if(target == nums[mid]){
            			check = true;
            			break;
            		}else if(target < nums[mid]){
            			high = mid - 1;
                	}else{
                		low = mid + 1;
                	} 
            	}else{
            		double tmpTarget = (i == 2) ? target1 : target2;
            		if(tmpTarget < nums[mid]){
            			high = mid - 1;
                		flag = true; // moved the upper bound last;
            		}else{
                		low = mid + 1;
                		flag = false; // moved the lower bound last;
            		}
            	}
            }
            if(i == 1 && !check)		return res;
            if(i == 2)	res[0] = (flag) ? mid : mid + 1;
            if(i == 3)	res[1] = (flag) ? mid - 1 : mid;
        }
        return res;
    }
}
