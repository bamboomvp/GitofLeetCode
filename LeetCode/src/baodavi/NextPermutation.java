package baodavi;

import java.util.Arrays;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
    	int hehe = Integer.MIN_VALUE;
    	int index = -1;
        for(int i = nums.length - 1; i >= 0; i--){
        	if(nums[i] >= hehe)
        		hehe = nums[i];
        	else{
        		index = i;
        		break;
        	}
        }
        
        if(index == -1){
        	Arrays.sort(nums);
        }else{
        	Arrays.sort(nums, index + 1, nums.length);
        	for(int j = index + 1; j < nums.length; j++){
        		if(nums[j] > nums[index]){
        			int tmp = nums[index];
        			nums[index] = nums[j];
        			nums[j] = tmp;
        			break;
        		}
        	}
        }
    }
    
    public static void main(String[] args){
    	new NextPermutation().nextPermutation(new int[]{1, 3, 2});
    }
}
