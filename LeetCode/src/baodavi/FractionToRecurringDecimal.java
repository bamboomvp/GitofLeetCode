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
 这即是说，22/7实际是一个无限循环小数：

22 / 7 = 3.142857142857142857...
如果我们细心观察一下22/7的演算过程，我们便会明白为何这分数必然是循环的。在计算22/7的第一步骤中， 我们先得商3和余数1。
接着我们把余数1倍大为10，然后计算10/7，得商1和余数3。接着我们把余数3倍大为30 ，然后计算30/7，得商4和余数2。接着我们又把余数2倍大为20，然后计算20/7......如此类推。
因此，在计算 22/7时，我们实际上是在不断做10/7或20/7或30/7...。可是，由于任何数除以7所得的余数只有7种可能(即0、 1、2、3、4、5和6)(注2)，这样下去必然会重复出现之前的计算。
当出现重复时，接着下来的计算便会跟之前 做过的计算一模一样，因而出现循环小数的情况。

例如，在22/7的运算中，当计算至小数点后第6位时，得商7 和余数1，接着我们把余数1倍大为10，然后计算10/7，但是此一计算在之前已做过，接下来的计算结果必然是 142857，因此22/7必然是不断重复出现142857这组数字的循环小数。

 把上述讨论推广至一般情况，那么由于任何整数除以整数n，其余数只有n种可能(即0、1、2...、n - 1)，因此 在进行任何整数除法时，在运算至某一阶段时，必然会重复出现之前做过的运算，
 这时就必定重复出现之前的计算结果，即无限循环小数。换句话说，任何分数(在高等数学中称为「有理数」Rational Number)都必然是无 限循环小数。
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
