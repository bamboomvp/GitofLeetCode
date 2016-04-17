package baodavi;

import java.util.HashMap;
import java.util.Map;

/*
Reverse bits of a given 32 bits unsigned integer.
For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).
 */
// ��򵥵�������ԭ����������ȡ�����λ���������������λ�������ٲ������ơ�
/*
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for(int i = 0; i < 32; i++, n >>= 1){
            res = res << 1 | (n & 1);
        }
        return res;
    }
}
*/
/*
�ֶ����
���Ӷ�
ʱ�� O(1) �ռ� O(1)

˼·
Java��׼��Integer.reverse()Դ�롣
*/

/*
���� Follow Up
Q������÷������������ã��������ڴ��������ݣ�Bulk data��ʱ��ʲô�Ż�������
A������ʵ���������ľ��裬����Ĵ��ģ����ʱ�㷨��������Ż���������ʵ����ܼ򵥣�����Ҫ�õ��Ķ��������������ˣ�
����������Map��¼֮ǰ��ת�������ֺͽ�������õ��Ż������ǽ��䰴��Byte�ֳ�4�δ洢����ʡ�ռ䡣
*/
public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for(int i = 0; i < 32; i++){
        	if((n & 1) == 1){
        		res <<= 1;
        		res = res | 1;
        	}else{
        		res <<= 1;
        	}
        	n >>= 1;
        }
        return res;
    }
    
    // Advanced Solution:
    private final Map<Byte, Integer> cache = new HashMap<>();
    
    public int reverseBitsAdvanced(int n){
    	byte[] bytes = new byte[4];
    	for(int i = 0; i < 4; i++)
    		bytes[i] = (byte)((n >>> 8*i) & 0xFF);
    	int res = 0;
    	for(int j = 0; j < 4; j++){
    		res += reverseBytesAdvanced(bytes[j]);
    		if(j < 3)
    			res <<= 8;
    	}
    	return res;
    }
    
    private int reverseBytesAdvanced(byte b){
    	if(cache.containsKey(b)){
    		return cache.get(b);
    	}else{
    		int val = 0;
    		for(int i = 0; i < 8; i++){
    			val += ((b >>> i) & 1);
    			if(i < 7)
    				val <<= 1;
    		}
    		cache.put(b, val);
    		return val;
    	}
    }
}
