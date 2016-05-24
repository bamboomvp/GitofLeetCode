package baodavi;

import java.util.HashMap;
import java.util.Map;

/*
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

For example,

Given numerator = 1, denominator = 2, return "0.5".
Given numerator = 2, denominator = 1, return "2".
Given numerator = 2, denominator = 3, return "0.(6)".
*/

/*
 �⼴��˵��22/7ʵ����һ������ѭ��С����

22 / 7 = 3.142857142857142857...
�������ϸ�Ĺ۲�һ��22/7��������̣����Ǳ������Ϊ���������Ȼ��ѭ���ġ��ڼ���22/7�ĵ�һ�����У� �����ȵ���3������1��
�������ǰ�����1����Ϊ10��Ȼ�����10/7������1������3���������ǰ�����3����Ϊ30 ��Ȼ�����30/7������4������2�����������ְ�����2����Ϊ20��Ȼ�����20/7......������ơ�
��ˣ��ڼ��� 22/7ʱ������ʵ�������ڲ�����10/7��20/7��30/7...�����ǣ������κ�������7���õ�����ֻ��7�ֿ���(��0�� 1��2��3��4��5��6)(ע2)��������ȥ��Ȼ���ظ�����֮ǰ�ļ��㡣
�������ظ�ʱ�����������ļ������֮ǰ �����ļ���һģһ�����������ѭ��С���������

���磬��22/7�������У���������С������6λʱ������7 ������1���������ǰ�����1����Ϊ10��Ȼ�����10/7�����Ǵ�һ������֮ǰ���������������ļ�������Ȼ�� 142857�����22/7��Ȼ�ǲ����ظ�����142857�������ֵ�ѭ��С����

 �����������ƹ���һ���������ô�����κ�������������n��������ֻ��n�ֿ���(��0��1��2...��n - 1)����� �ڽ����κ���������ʱ����������ĳһ�׶�ʱ����Ȼ���ظ�����֮ǰ���������㣬
 ��ʱ�ͱض��ظ�����֮ǰ�ļ�������������ѭ��С�������仰˵���κη���(�ڸߵ���ѧ�г�Ϊ����������Rational Number)����Ȼ���� ��ѭ��С����
 */

public class FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        
    	// edge cases...
    	if(denominator == 0)
    		return null;
    	if(numerator == 0)
    		return "0";
    	
    	// normal cases...
    	boolean negFlag = false;
    	if(numerator > 0 && denominator < 0)
    		negFlag = true;
    	else if(numerator < 0 && denominator > 0)
    		negFlag = true;
    	else
    		negFlag = false;
    	
    	StringBuffer sb = new StringBuffer();
		if(negFlag)
			sb.insert(0, '-');
        
		long dividend = Math.abs((long) numerator);
		long divisor = Math.abs((long) denominator);
		long integerPart = dividend / divisor;
		long remainder = dividend % divisor;
    	
    	sb.append(Long.toString(integerPart));
    	if(remainder == 0)
    		return sb.toString();
        else
    		sb.append('.');
    	
    	Map<Long, Integer> bookkeeping = new HashMap<>();
    	while(remainder != 0 && !bookkeeping.containsKey(remainder)){
    		bookkeeping.put(remainder, sb.length());
    		dividend = remainder * 10;
    		
    		long fractionPart = dividend / divisor;
    		remainder = dividend % divisor;
    		sb.append(Long.toString(fractionPart));
    	}
    	
    	if(remainder == 0)
    		return sb.toString();
    	else{
    		int index = bookkeeping.get(remainder);
    		sb.insert(index, '(');
    		sb.append(')');
    		return sb.toString();
    	}
    }
}
