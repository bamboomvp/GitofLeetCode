package baodavi;

public class DivideTwoIntegers {
	// O(n) TLE...
    public int divide(int dividend, int divisor) {
        int defaultVal = Integer.MAX_VALUE;
        if(divisor == 0)	return defaultVal;
        else if(dividend == 0)	return 0;
        else if(dividend == Integer.MIN_VALUE && divisor == -1)	return defaultVal;
        else if(divisor == -1)	return (0 - dividend);
        else if(divisor == 1)	return dividend;
        else{
        	long dividendLong = Math.abs((long) dividend);
        	long divisorLong = Math.abs((long) divisor);
        	if((dividendLong < 0 && divisorLong > 0) || (dividendLong > 0 && divisorLong < 0)){
        		return 0 - divideHelper(dividendLong, divisorLong);
        	}else{
        		return divideHelper(dividendLong, divisorLong);
        	}
        }
    }
    
    private int divideHelper(long dividend, long divisor){
    	int cnt = 0;
    	while(dividend >= divisor){
    		dividend -= divisor;
    		cnt++;
    	}
    	return cnt;
    }
    
    // O(log n)
    public int divideUPDATED(int dividend, int divisor) {
    	if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) return Integer.MAX_VALUE;
    	long m = Math.abs((long) dividend);
    	long n = Math.abs((long) divisor);
    	int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
    	if(n == 1)	return (int) (sign == 1 ? m : -m);
    	int res = 0;
    	while(m >= n){
    		long t = n, cnt = 1;
    		while(m >= (t << 1)){
    			t <<= 1;
    			cnt <<= 1;
    		}
    		res += cnt;
    		m -= t;
    	}
    	return sign == 1 ? res : -res;
    }
}
