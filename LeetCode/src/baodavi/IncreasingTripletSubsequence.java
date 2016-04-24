package baodavi;

/*
Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
Formally the function should:
	Your algorithm should run in O(n) time complexity and O(1) space complexity.
	
	Examples:
		Given [1, 2, 3, 4, 5],
		return true.

		Given [5, 4, 3, 2, 1],
		return false.	
*/

/*
���⣺����һ������Ϊn�����������arr���������Ƿ���i,j,k��������ʹ�� arr[i] < arr[j] < arr[k] ( 0 �� i < j < k �� n-1)

˼·��

�� x1Ϊ��ĿǰΪֹ����Сֵ ��  x2Ϊ��ĿǰΪֹ������һ������x2С����С������

��ʼʱ����x1 = x2 = INT_MAX ��Ȼ���������,���ϵĸ���x1��x2 ��������

num <= x1,  ��ʱ��x1����Ϊnum
�� x1 < num <= x2���� ��x2 ����Ϊnum
x2 < num  ˵���н⣬����true����
�򵥵�˵�������Ĺ��̾��ǲ��ϵ���Сx1��x2�������Ƿ��е������� ��x2��

������ֵ������� num > x2����֮ǰ�ض����и���x С��x2������˵���� x < x2 < num������˵�д�����
*/

public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length < 3)
        	return false;
        
        int m1, m2;
        m1 = m2 = Integer.MAX_VALUE;
        for(int n : nums){
        	if(n <= m1)	m1 = n;
        	else if(n <= m2) m2 = n;
        	else	return true;
        }
        return false;
    }
}
