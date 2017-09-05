package baodavi;

public class JumpGameII {
    public int jump(int[] nums) {
        if(nums == null || nums.length < 2)	return 0;
        else{
        	// Greedy
        	/*
			 * We use "last" to keep track of the maximum distance that has been reached
			 * by using the minimum steps "ret", whereas "curr" is the maximum distance
			 * that can be reached by using "ret+1" steps. Thus,
			 * curr = max(i+A[i]) where 0 <= i <= last.
        	 */
        	int last = 0;
        	int ret = 0;
        	int curr = 0;
        	for(int i = 0; i < nums.length; i++){
        		if(i > last){
        			last = curr;
        			ret++;
        		}
        		curr = Math.max(curr, i + nums[i]);
        	}
        	return ret;
        }
    }
}
