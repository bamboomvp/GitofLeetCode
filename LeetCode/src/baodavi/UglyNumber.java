package baodavi;

/*
Write a program to check whether a given number is an ugly number.
Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.
Note that 1 is typically treated as an ugly number.
*/

/*
������������ȷ����������������ĺ��ĵ�λ���κδ���1���������ɱ���ʾ��һ��Ψһ����֮�˻���
�ö����Ψһ���轫1�ų��������⣬��Ϊ��Լ���ֽ��п�����������1����3��1*3��1*1*3�ȶ���3����ЧԼ���ֽ⡣ 
��֤һ������ n �Ƿ�Ϊ������һ�ּ򵥵������ķ���Ϊ�Գ�������һ��������� n �Ƿ�Ϊ��һ��2��\sqrt{n}֮�������֮������
���Գ���������Ч�ʵ��㷨�ѱ������������Խϴ�������Ƿ�Ϊ�������ر���ǣ���һЩ�ر���ʽ�����֣���÷ɭ�������и���ķ�����ֱ��2016��1��Ϊֹ����֪��������Ϊ2^74207281-1��
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
