package baodavi;

/*
 * n!后缀0的个数 = n!质因子中5的个数
              = floor(n/5) + floor(n/25) + floor(n/125) + ....
 */

//原因就是 i*5一直连乘时出现i = 5^14时，内存溢出(5^13 = 1220703125 < 2^31, but 5^14 = 6103515625 > 2^32)
//
//Integer overflow之后会wrap around, 即Integer.MAX_VALUE + 1会成为Integer.MIN_VALUE, 详见Why Integer overflows wrap around
//
// 
//
//6103515625 wrap around之后 为正的1808548329-1 = 1808548328
//
//原因是6103515625 % 2^32 = 1808548329 < 2 ^31，即 i 比32位Integer（共2^32）多出1808548329个数， 为 1808548328，又可以再进一次for 循环（本不应该进的）。所以答案偏大
//
//解决办法：用除法代替乘法，用n / 5代替 i * 5，防止overflow，如最上面那段code所示
public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int factor = 5;
        int res = 0;
        while(n >= factor){
        	res += n / factor;
        	n /= 5;
        }
        return res;
    }
}
