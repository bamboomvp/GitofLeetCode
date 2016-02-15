package baodavi;

public class BitwiseANDOfNumbersRange {
	
	/*
	����һ���������������У��������ڵ����������һλ�϶��ǲ�һ���ģ���ôֻҪm!=n,��ô���һλ�϶���0����ô���ǾͿ�����һλ��ʼm==n���ɡ�
	ps: ��ʵ����ҲӦ�ú��������������⣬������϶��Ǵ�ĳһλ��ʼ����ͬ����ô����ֻ��Ҫ��������С��������������һλ��ʼ����ͬ�ģ�
	Ҳ���ǿ�������С������ֵ�ĸ߼�λ��ͬ�� ��Ȼ����Ҳ����ʹ�ôӸ�λ����λ�жϣ��ж���λ����ͬ�ġ�
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
