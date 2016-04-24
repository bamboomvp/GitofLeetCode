package baodavi;

import java.util.ArrayList;
import java.util.List;

/*
Write a program to find the n-th ugly number.
Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
Note that 1 is typically treated as an ugly number.
Show Hint

1. The naive approach is to call isUgly for every number until you reach the nth one. Most numbers are not ugly. Try to focus your effort on generating only the ugly ones.
2. An ugly number must be multiplied by either 2, 3, or 5 from a smaller ugly number.
3. The key is how to maintain the order of the ugly numbers. Try a similar approach of merging from three sorted lists: L1, L2, and L3.
4. Assume you have Uk, the kth ugly number. Then Uk+1 must be Min(L1 * 2, L2 * 3, L3 * 5).
*/ 

/*
Here is a time efficient solution with O(n) extra space. The ugly-number sequence is 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, ¡­
because every number can only be divided by 2, 3, 5, one way to look at the sequence is to split the sequence to three groups as below:
(1) 1¡Á2, 2¡Á2, 3¡Á2, 4¡Á2, 5¡Á2, ¡­
(2) 1¡Á3, 2¡Á3, 3¡Á3, 4¡Á3, 5¡Á3, ¡­
(3) 1¡Á5, 2¡Á5, 3¡Á5, 4¡Á5, 5¡Á5, ¡­
*/

public class UglyNumberII {
	
	// bad!
    public int nthUglyNumber(int n) {
    	
    	if(n == 1)
    		return 1;
    	
        int[] sequence = new int[n];
        sequence[0] = 1;
        List<Integer> L1 = new ArrayList<>();
        List<Integer> L2 = new ArrayList<>();
        List<Integer> L3 = new ArrayList<>();
        L1.add(2);
        L2.add(3);
        L3.add(5);
        for(int i = 1; i < sequence.length; i++){
        	int localMin = Math.min(Math.min(L1.get(0), L2.get(0)), L3.get(0));
        	sequence[i] = localMin;
        	L1.add(localMin * 2);
        	L2.add(localMin * 3);
        	L3.add(localMin * 5);
        	if(localMin == L1.get(0))
        		L1.remove(0);
        	if(localMin == L2.get(0))
        		L2.remove(0);
        	if(localMin == L3.get(0))
        		L3.remove(0);        	
        }
        
        return sequence[n -  1];
    }
    
    // awesome!
    public int nthUglyNumberAdvanced(int n) {
    	
    	if(n == 1)
    		return 1;
    	
        int[] sequence = new int[n];
        sequence[0] = 1;
        int index1 = 0;
        int index2 = 0;
        int index3 = 0;
        for(int i = 1; i < sequence.length; i++){
        	int localMin = Math.min(Math.min(sequence[index1] * 2, sequence[index2] * 3), sequence[index3] *5);
        	sequence[i] = localMin;
        	if(localMin == sequence[index1] * 2)
        		index1++;
        	if(localMin == sequence[index2] * 3)
        		index2++;
        	if(localMin == sequence[index3] * 5)
        		index3++;        	
        }
        
        return sequence[n -  1];
    }    
}
