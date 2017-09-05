package baodavi;

import java.util.ArrayList;
import java.util.List;

/*
Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.

For example:
Given n = 13,
Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.
*/

/*
ͨ��������о����ǿ��Է��֣�100���ڵ����֣�����10-19֮����11����1��֮�⣬���඼ֻ��1����
������ǲ�����[10, 19]�������Ƕ������10����1���Ļ�����ô�����ڶ�����һ����λ����ʮλ���ϵ�����(��1)�ʹ���1���ֵĸ�����
��ʱ�������ٰѶ����10�����ϼ��ɡ�����56����(5+1)+10=16�������֪���Ƿ�Ҫ���϶����10���أ����Ǿ�Ҫ��ʮλ�ϵ������Ƿ���ڵ���2��
�ǵĻ���Ҫ���϶����10��'1'����ô���ǾͿ�����(x+8)/10���ж�һ�����Ƿ���ڵ���2��

������λ��Ҳ��һ��������[110, 119]֮������10����֮�⣬�����ÿ10���������䶼ֻ��11����1������ô���ǿ�������ͬ�ķ������жϲ��ۼ�1�ĸ���
*/

public class NumberOfDigitOne {
	
	// LOL, java 8 solution, so nice!
    public int countDigitOne(int n) {
        List<Character> wow = new ArrayList<>();
        for(int i = 1; i <= n; i++){
        	for(char c : Integer.toString(i).toCharArray()){
        		wow.add(c);
        	}
        }
        
        return (int) wow.stream().filter(c -> c == '1').count();
    }
    
    // pure math
    public int countDigitOneMath(int n) {
    	int res = 0;
    	for(long i = 1; i <= n; i *= 10){
    		long divider = i * 10;
    		res += (n / divider) * i;
    		res += Math.min(Math.max(n % divider - i + 1, 0L), i);
    	}
    	return res;
    }
}
