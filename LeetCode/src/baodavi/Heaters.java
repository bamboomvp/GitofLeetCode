package baodavi;

import java.util.Arrays;

public class Heaters {
    public int findRadius(int[] houses, int[] heaters) {
    	if(houses == null || heaters == null || houses.length == 0 || heaters.length == 0)	return 0;
    	
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int minRadius = 0; 
        for(int i = 0; i < houses.length; i++){
        	int posInd = binarySearchHelper(houses[i], heaters);
        	if(posInd < 0){
        		minRadius = Math.max(minRadius, heaters[0]  - houses[i]);
        	}else if(houses[i] == heaters[posInd]){
        		minRadius = Math.max(minRadius, 0);
        	}else if(posInd >= heaters.length - 1){
        		minRadius = Math.max(minRadius, houses[i] - heaters[heaters.length - 1]);
        	}else{
        		int r1 = houses[i] - heaters[posInd];
        		int r2 = heaters[posInd + 1] - houses[i];
        		minRadius = Math.max(minRadius, Math.min(r1, r2));
        	}
        }
        return minRadius;
    }
    
    private int binarySearchHelper(int housePos, int[] heaters){
    	int posInd = -1;
    	int low = 0;
    	int high = heaters.length - 1;
    	boolean flag = false;
    	while(!(low > high)){
    		int mid = low + (high - low) / 2;
    		if(heaters[mid] == housePos){
    			return mid;
    		}else if(heaters[mid] < housePos){
    			low = mid + 1;
    		}else{
    			high = mid - 1;
    			flag = true;
    		}
    	}
    	if(flag)	posInd = high;
    	else	posInd = (low - 1);
    	return posInd;
    }
}
