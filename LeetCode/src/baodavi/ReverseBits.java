package baodavi;

import java.util.HashMap;
import java.util.Map;

/*
Reverse bits of a given 32 bits unsigned integer.
For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).
 */
// 最简单的做法，原数不断右移取出最低位，赋给新数的最低位后新数再不断左移。
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
分段相或法
复杂度
时间 O(1) 空间 O(1)

思路
Java标准的Integer.reverse()源码。
*/

/*
后续 Follow Up
Q：如果该方法被大量调用，或者用于处理超大数据（Bulk data）时有什么优化方法？
A：这其实才是这道题的精髓，考察的大规模数据时算法最基本的优化方法。其实道理很简单，反复要用到的东西记下来就行了，
所以我们用Map记录之前反转过的数字和结果。更好的优化方法是将其按照Byte分成4段存储，节省空间。
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
