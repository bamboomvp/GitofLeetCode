package baodavi;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if(height == null || height.length == 0){
        	return -1;
        }else if(height.length == 1){
        	return -1;
        }
        
        int low, high, globalMax;
        low = 0;
        high = height.length - 1;
        globalMax = (high - low) * (height[low] < height[high] ? height[low] : height[high]);
        
        while(low < high){
        	if(height[low] < height[high]){
        		low++;
        		int localVal = (high - low) * (height[low] < height[high] ? height[low] : height[high]);
        		globalMax = localVal > globalMax ? localVal : globalMax;
        	}else{
        		high--;
        		int localVal = (high - low) * (height[low] < height[high] ? height[low] : height[high]);
        		globalMax = localVal > globalMax ? localVal : globalMax;        		
        	}
        }
        
        return globalMax;
    }
    
    public int maxAreaDecent(int[] height){
    	if(height == null || height.length == 0){
    		return 0;
    	}
    	
    	int low = 0, high = height.length - 1;
    	int max = 0;
    	
    	while(low < high){
    		int area = (high - low) * Math.min(height[low], height[high]);
    		max = Math.max(max, area);
    		if(height[low] < height[high])
    			low++;
    		else
    			high--;
    	}
    	
    	return max;
    }
}
