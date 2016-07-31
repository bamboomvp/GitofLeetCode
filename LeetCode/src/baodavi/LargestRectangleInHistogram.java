package baodavi;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
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
    
    public int largestRectangleAreaII(int[] heights) {
    	return 0; // how to use Stack???
    }
}
