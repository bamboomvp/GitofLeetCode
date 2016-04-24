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
题意：给定一个长度为n的乱序的数组arr，让你求是否有i,j,k三个数，使得 arr[i] < arr[j] < arr[k] ( 0 ≤ i < j < k ≤ n-1)

思路：

设 x1为到目前为止的最小值 ，  x2为到目前为止至少有一个数比x2小的最小的数。

初始时设置x1 = x2 = INT_MAX ，然后遍历数组,不断的更新x1和x2 具体如下

num <= x1,  此时将x1设置为num
若 x1 < num <= x2，则 把x2 设置为num
x2 < num  说明有解，返回true即可
简单的说，上述的过程就是不断的缩小x1和x2，看看是否有第三个数 比x2大。

如果出现第三个数 num > x2，则之前必定还有个数x 小于x2，就是说满足 x < x2 < num，就是说有答案啦。
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
