package baodavi;

public class BitwiseANDOfNumbersRange {
	
	/*
	对于一个连续的数字序列，两个相邻的两个数最后一位肯定是不一样的，那么只要m!=n,那么最后一位肯定是0，那么我们就看从哪一位开始m==n即可。
	ps: 其实我们也应该很容易理解这个问题，最后的与肯定是从某一位开始都相同，那么我们只需要看最大和最小的两个数，从哪一位开始是相同的，
	也就是看最大和最小的两个值的高几位相同。 当然我们也可以使用从高位往地位判断，有多少位是相同的。
	*/
	public int rangeBitwiseAnd(int m, int n){
		int offset = 0;
		while(m != 0 && n != 0){
			if(m == n){
				return m << offset;
			}
			m >>= 1;
			n >>= 1;
			offset++;
		}
		
		return 0;
	}
	
    public int rangeBitwiseAnd_backup(int m, int n) {
        // sanity check
    	if(m < 0 || m > Integer.MAX_VALUE){
    		return -1;
    	} else if (n < 0 || n > Integer.MAX_VALUE){
    		return -1;
    	} else if (m > n){
    		return -1;
    	} else {
    		// the normal logic
    		
    		if(m == 0){ // case 1
    			return 0;
    		}else if(m == n){ // case 2
    			return m;
    		}else{
    			int k = findPrevious2ToN(n);
    			
    			if(n == k){ // case 3
    				return 0;
    			}else if(m <= k){ // case 4
    				return k;
    			}else{ // case 5
    				int base = m;
    				for(int i = m + 1; i <= n; i++){
    					base &= i;
    				}
    				return base;
    			}
    		}
    	}
    }
    
    private int findPrevious2ToN(int n){
    	// shortcut
    	if(n == Integer.MAX_VALUE)
    		return 1 << 30;
    	
    	if((n & (n + 1)) == 0)
    		return (n + 1) >> 1;
    	
    	while(n > 0){
	    	if((n & (n - 1)) == 0){
	    		return n;
	    	}
	    	n--;
    	}
    	return -1;
    }
    
    public static void main(String[] args){
    	new BitwiseANDOfNumbersRange().rangeBitwiseAnd(20000, Integer.MAX_VALUE);
    }
}
