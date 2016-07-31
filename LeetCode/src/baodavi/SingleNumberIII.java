package baodavi;

public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
    	if(nums == null || nums.length < 2)
    		return new int[0];
    	else if(nums.length == 2)
    		return nums;
    	else{
    		int xor = 0;
    		for(int i = 0; i < nums.length; i++){
    			xor ^= nums[i];
    		}
    		int mask = 1;
    		for(int j = 0; j < 32; j++){
    			if((mask & xor) > 0)
    				break;
    			else
    				mask <<= (j + 1); 
    		}
    		
    		int[] res = new int[2];
    		for(int num : nums){
    			if((num & mask) > 0)
    				res[0] ^= num;
    			else
    				res[1] ^= num;
    		}
    		return res;
    	}
    }
}
