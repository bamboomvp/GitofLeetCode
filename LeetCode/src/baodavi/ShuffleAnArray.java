package baodavi;

import java.util.Arrays;
import java.util.Random;

public class ShuffleAnArray {

	class Solution {
		
		private int[] origin;
		private int[] shuffled;
		private Random rand;
		
	    public Solution(int[] nums) {
//	    	origin = nums.clone();
	        origin = Arrays.copyOf(nums, nums.length);
	        shuffled = Arrays.copyOf(nums, nums.length);
	        rand = new Random();
	    }
	    
	    /** Resets the array to its original configuration and return it. */
	    public int[] reset() {
	        return this.origin;
	    }
	    
	    /** Returns a random shuffling of the array. */
	    public int[] shuffle() {
	        for(int i = 0; i < this.shuffled.length; i++){
	        	int swapPos = i + rand.nextInt(this.shuffled.length - i);
	        	swap(this.shuffled, i, swapPos);
	        }
	        return this.shuffled;
	    }
	    
	    private void swap(int[] nums, int i, int j){
	    	int tmp = nums[i];
	    	nums[i] = nums[j];
	    	nums[j] = tmp;
	    }
	}
}
