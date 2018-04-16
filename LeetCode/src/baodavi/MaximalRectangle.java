package baodavi;

import java.util.Stack;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0)
        	return 0;
        else if(matrix[0] == null || matrix[0].length == 0)
        	return 0;
        else{
        	int rows = matrix.length;
        	int cols = matrix[0].length;
        	int max = 0;
        	int[] height = new int[cols]; // store the heights
        	for(int i = 0; i < rows; i++){
        		for(int j = 0; j < cols; j++){
        			if(matrix[i][j] == '0')
        				height[j] = 0;
        			else
        				height[j] += 1;
        		}
        		max = Math.max(max, largestRectangleAreaFancy(height));
        	}
        	return max;
        }
    }
    
    private int largestRectangleAreaFancy(int[] heights) {
    	Stack<Integer> stack = new Stack<>();
    	int maxArea = 0;
    	for(int i = 0; i <= heights.length; i++){
    		int curVal = (i == heights.length) ? -1 : heights[i];
    		while(!stack.isEmpty() && heights[stack.peek()] > curVal){
    			int h = heights[stack.peek()];
    			stack.pop();
    			int w = stack.isEmpty() ? i : (i - stack.peek() - 1);
    			maxArea = Math.max(maxArea, h * w);
    		}
    		stack.push(i);
    	}
    	return maxArea;
    }
    
    private int largestRectangleAreaOld(int[] heights) {
        int areaGlobal = 0;
        // iterates through every right boundary
        for(int i = 0; i < heights.length; i++){
        	// pruning, skip some...
        	for(int k = i + 1; k < heights.length; k++){
        		if(heights[k] < heights[k - 1]){
        			i = k - 1;
        			break;
        		}else{
        			i = k;
        		}
        	}
        	
        	// enumerates through all the possible left boundaries...
        	int lowestHeight = heights[i];
        	for(int j = i; j >= 0; j--){
        		if(heights[j] < lowestHeight){
        			lowestHeight = heights[j];
        		}
        		int areaLocal = lowestHeight * (i - j + 1);
        		if(areaLocal > areaGlobal){
        			areaGlobal = areaLocal;
        		}
        	}
        }
        
        return areaGlobal;
    }    
}
