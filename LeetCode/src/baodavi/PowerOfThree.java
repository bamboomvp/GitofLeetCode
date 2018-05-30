package baodavi;

public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        if(n <= 0)	return false;
        while(n % 3 == 0){
        	n /= 3;
        }
        return n == 1;
    }
    
    public boolean isPowerOfThreeFancy(int n) {
    	if(n <= 0)	return false;
    	String base3Str = Integer.toString(n, 3);
    	return base3Str.matches("^10*$");
    }
}
