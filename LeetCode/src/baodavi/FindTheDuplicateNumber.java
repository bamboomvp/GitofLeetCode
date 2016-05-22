package baodavi;

public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        for(int i = 0; i < nums.length; i++){
        	if(nums[Math.abs(nums[i])] < 0)
        		return Math.abs(nums[i]);
        	else
        		nums[Math.abs(nums[i])] *= -1;
        }
        return Math.abs(nums[0]);
    }
    
    /*
    这道题给了我们n+1个数，所有的数都在[1, n]区域内，首先让我们证明必定会有一个重复数，
    这不禁让我想起了小学华罗庚奥数中的抽屉原理(又叫鸽巢原理), 即如果有十个苹果放到九个抽屉里，如果苹果全在抽屉里，
    则至少有一个抽屉里有两个苹果，这里就不证明了，直接来做题吧。
    题目要求我们不能改变原数组，即不能给原数组排序，又不能用多余空间，那么哈希表神马的也就不用考虑了，又说时间小于O(n2)，
    也就不能用brute force的方法，那我们也就只能考虑用二分搜索法了，我们在区别[1, n]中搜索，首先求出中点mid，
    然后遍历整个数组，统计所有小于等于mid的数的个数，如果个数大于mid，则说明重复值在[mid+1, n]之间，
    反之，重复值应在[1, mid-1]之间，然后依次类推，直到搜索完成，此时的low就是我们要求的重复值，参见代码如下:
    */
    public int findDuplicateAlt(int[] nums) {
    	int low, high;
    	low = 1;
    	high = nums.length - 1;
    	while(low <= high){
    		int mid = low + (high - low) / 2;
    		int cnt = 0;
    		for(int i = 0; i < nums.length; i++){
    			if(nums[i] <= mid)	cnt++;
    		}
    		if(cnt <= mid)	low = mid + 1;
    		else	high = mid - 1;
    	}
    	return low;
    }
}
