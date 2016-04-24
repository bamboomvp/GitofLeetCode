package baodavi;

/*
Write a program to check whether a given number is an ugly number.
Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.
Note that 1 is typically treated as an ugly number.
*/

/*
算术基本定理确立了素数于数论里的核心地位：任何大于1的整数均可被表示成一串唯一素数之乘积。
该定理的唯一性需将1排除于素数外，因为在约数分解中可以有任意多个1，如3、1*3、1*1*3等都是3的有效约数分解。 
验证一个数字 n 是否为素数的一种简单但缓慢的方法为试除法。此一方法会测试 n 是否为任一在2与\sqrt{n}之间的整数之倍数。
比试除法更加有效率的算法已被发现用来测试较大的数字是否为素数。特别的是，对一些特别形式的数字（如梅森数），有更快的方法。直到2016年1月为止，已知最大的素数为2^74207281-1。
*/
public class UglyNumber {
    public boolean isUgly(int num) {
        if(num <=0)
        	return false;
        if(num == 1)
        	return true;
        
        while(num != 1){
        	if(num % 2 == 0)	num /= 2;
        	else if(num % 3 == 0)	num /= 3;
        	else if(num % 5 == 0)	num /= 5;
        	else	return false;
        }
        
        return true;
    }
}
