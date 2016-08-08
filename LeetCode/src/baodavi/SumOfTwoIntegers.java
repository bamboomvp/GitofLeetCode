package baodavi;

public class SumOfTwoIntegers {
    public int getSum(int a, int b) {
        if(a == 0)
        	return b;
        else if(b == 0)
        	return a;
        else{
        	int xor = a ^ b;
        	int extra = (a & b) << 1;
        	return getSum(xor, extra);
        }
    }
}
