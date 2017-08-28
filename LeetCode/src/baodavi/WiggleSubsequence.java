package baodavi;

public class WiggleSubsequence {
	// up[i] and down[i]
    public int wiggleMaxLengthDP(int[] nums) {
        if(nums.length < 2)
        	return nums.length;
        int[] up = new int[nums.length];
        int[] down = new int[nums.length];
        for(int x = 0; x < nums.length; x++){
        	up[x] = 1;
        	down[x] = 1;
        }
        for(int i = 1; i < nums.length; i++){
        	for(int j = 0; j < i; j++){
        		if(nums[i] > nums[j]){
        			up[i] = Math.max(up[i], down[j] + 1);
        		}else if(nums[i] < nums[j]){
        			down[i] = Math.max(down[i], up[j] + 1);
        		}
        	}
        }
        return Math.max(up[nums.length - 1], down[nums.length - 1]);
    }
}
