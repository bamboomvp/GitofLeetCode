package baodavi;

/*
 * n!��׺0�ĸ��� = n!��������5�ĸ���
              = floor(n/5) + floor(n/25) + floor(n/125) + ....
 */

//ԭ����� i*5һֱ����ʱ����i = 5^14ʱ���ڴ����(5^13 = 1220703125 < 2^31, but 5^14 = 6103515625 > 2^32)
//
//Integer overflow֮���wrap around, ��Integer.MAX_VALUE + 1���ΪInteger.MIN_VALUE, ���Why Integer overflows wrap around
//
// 
//
//6103515625 wrap around֮�� Ϊ����1808548329-1 = 1808548328
//
//ԭ����6103515625 % 2^32 = 1808548329 < 2 ^31���� i ��32λInteger����2^32�����1808548329������ Ϊ 1808548328���ֿ����ٽ�һ��for ѭ��������Ӧ�ý��ģ������Դ�ƫ��
//
//����취���ó�������˷�����n / 5���� i * 5����ֹoverflow�����������Ƕ�code��ʾ
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
