package baodavi;

public class ReverseInteger {

	public int reverse(int x) {
        if(x == 0)
            return x;
        int original = 0;
        if(x < 0)
            original = -x;
        else 
            original = x;
        
        int res = 0;
        int resCheck = 0;
        while(original != 0){
            int currDigit = original % 10;
            original /= 10;
            resCheck = res << 1;
            if(resCheck < res){
            	return 0; // overflow
            }
            res *= 10;
            res += currDigit;
        }
        
        if(x < 0)
            return -res;
        else
            return res;
    }
	
	public static void main(String[] args) {
//		new ReverseInteger().reverse(1534236469);
		int tmp = Integer.MAX_VALUE;
		String s1 = Integer.toBinaryString(tmp);
		int tmp2 = tmp << 1;
		String s2 = Integer.toBinaryString(tmp2);
		String s3 = Integer.toBinaryString(-2);
		assert(tmp2 < tmp);
	}

}
