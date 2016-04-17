package baodavi;

/*
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
 */

//Two Pointers
public class RemoveDuplicatesFromSortedArrayII {
	public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
        	return 0;
        }
        if(nums.length == 1){
        	return 1;
        }
        
        boolean flag = true;
        int ptr1, ptr2;
        ptr1 = ptr2 = 1;
        int prev = nums[0];
        while(ptr2 < nums.length){
        	if(nums[ptr2] > prev || (nums[ptr2] == prev && flag)){
        		if(nums[ptr2] > prev){
        			flag = true;
        		}else{
        			flag = false;
        		}
        		nums[ptr1] = nums[ptr2];
        		prev = nums[ptr2];
        		ptr1++;
        	}
        	ptr2++;
        }
        return ptr1;
    }
}
