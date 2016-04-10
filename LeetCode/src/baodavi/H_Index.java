package baodavi;

import java.util.Arrays;

public class H_Index {
    public int hIndex(int[] citations) {
    	Arrays.sort(citations);
    	
    	int hIdx = citations.length;
    	for(int i = 0; i < citations.length; i++){
    		if(citations[i] < hIdx){
    			hIdx--;
    		}else{
    			return hIdx;
    		}
    	}
    	return hIdx;
    }
}
