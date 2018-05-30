package baodavi;

public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
    	if(n <= 0)	return false;
    	while(n > 0){
    		if((n & 1) == 1 && n >> 1 > 0)
    			return false;
    		n >>= 1;
    	}
    	return true;
    }
    
    public boolean isPowerOfTwoFancy(int n) {
    	if(n <= 0)	return false;
    	else	return Integer.bitCount(n) == 1;
    }
}
