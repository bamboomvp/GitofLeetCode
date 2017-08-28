package baodavi;

import java.util.HashMap;
import java.util.Map;

public class CanIWin {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int sum = (1+maxChoosableInteger)*maxChoosableInteger/2;
        if(sum < desiredTotal) return false;
        if(desiredTotal <= 0) return true;
    	
    	Map<Integer, Boolean> caching = new HashMap<>();
    	boolean[] bookkeeping = new boolean[maxChoosableInteger];
    	return canIWinHelper(bookkeeping, caching, desiredTotal);
    }
    
    private boolean canIWinHelper(boolean[] bookkeeping, Map<Integer, Boolean> caching, int desiredTotal){
    	if(desiredTotal <= 0)	return false;
    	int key = format(bookkeeping);
    	// check caching
    	if(!caching.containsKey(key)){
    		// try every unchosen number as next step
    		for(int i = 1; i <= bookkeeping.length; i++){
    			if(!bookkeeping[i - 1]){
    				bookkeeping[i - 1] = true;
    				// check whether this lead to a win (i.e. the other player lose)
    				if(!canIWinHelper(bookkeeping, caching, desiredTotal - i)){
    					caching.put(key, true);
    					bookkeeping[i - 1] = false; // reset
    					return true;
    				}else{
    					bookkeeping[i - 1] = false; // reset
    				}
    			}
    		}
    		caching.put(key, false);
    	}
    	return caching.get(key);
    }
    
    // transfer boolean[] to an Integer
    private int format(boolean[] bookkeeping){
    	int num = 0;
    	for(boolean b : bookkeeping){
    		num <<= 1;
    		if(b)	num |= 1;
    	}
    	return num;
    }
}
