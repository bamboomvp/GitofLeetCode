package baodavi;

import java.util.Stack;

public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int l = nums.length, r = 0;
        for(int i = 0; i < nums.length - 1; i++){
        	for(int j = i + 1; j < nums.length; j++){
        		if(nums[j] < nums[i]){
        			r = Math.max(r, j);
        			l = Math.min(l, i);
        		}
        	}
        }
        return r - l < 0 ? 0 : r - l + 1;
    }
    
    public int findUnsortedSubarrayStack(int[] nums) {
    	Stack<Integer> stack = new Stack<>();
    	int l = nums.length, r = 0;
    	for(int i = 0; i < nums.length; i++){
    		while(!stack.isEmpty() && nums[stack.peek()] > nums[i])
    			l = Math.min(l, stack.pop());
    		stack.push(i);
    	}
    	stack.clear();
    	for(int j = nums.length - 1; j >= 0; j--){
    		while(!stack.isEmpty() && nums[stack.peek()] < nums[j])
    			r = Math.max(r, stack.pop());
    		stack.push(j);
    	}
    	return r - l > 0 ? r - l + 1 : 0;
    }
}
