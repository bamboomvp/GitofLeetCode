package baodavi;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
    	
    	if(nums == null || nums.length == 0)
    		return new int[0];
    	if(nums.length == 1)
    		return new int[]{0};
    	
        int[] output = new int[nums.length];

        int base = 1;
        for(int i = nums.length - 1; i >= 0; i--){
        	base *= nums[i];
        	output[i] = base;
        }
        
        base = 1;
        for(int j = 0; j <= nums.length - 1; j++){
        	base *= nums[j];
        	nums[j] = base;
        }
        
        for(int k = 0; k < output.length - 1; k++){
        	if(k - 1 < 0)
        		output[k] = output[k + 1];
        	else if(k + 1 >= output.length)
        		output[k] = nums[k - 1];
        	else
        		output[k] = nums[k - 1] * output[k + 1];
        }
        
        return output;
    }
}
