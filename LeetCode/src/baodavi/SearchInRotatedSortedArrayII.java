package baodavi;

/*
��⣺

     �������֮ǰSearch in Rotated Sorted Array���ƣ�����ֻ���ڴ���dupilcate����ô��֮ǰ�ǵ���Ľⷨ������ǣ�����ͨ���Ƚ�A[mid]�ͱ�Եֵ��ȷ���ı�������ģ������A[mid]���Եֵ��ȵ�״̬�����ԣ�����������Ƕ���A[mid]==A[low]��A[mid]==A[high]��������

     ���м�ֵ���Եֵ���ʱ����ָ���Եֵ��ָ��ֱ���ǰ�ƶ������Ե������ͬ�㣬����֮ǰ�ķ����жϼ��ɡ�

     ��һ�ı�������ʱ�临�Ӷȣ�����һ��������ͬһ�������{1��1��1��1��1}��target=2, ��ô����㷨�ͻὫ�������������ʱ�临�Ӷ���O(logn)����O(n)
 */

public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0)
        	return false;
        
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
        	int mid = (low + high) / 2;
        	if(target < nums[mid]){
        		if(nums[mid] < nums[high]) 					// right side is sorted
        			high = mid - 1; // SO - target must in left side
        		else if(nums[mid] == nums[high]) 			// cannot tell right is sorted, move pointer high
        			high--;
        		else{													// left side is sorted
        			if(nums[low] > target)
        				low = mid + 1;
        			else
        				high = mid - 1;
        		}
        	}else if(target > nums[mid]){
        		if(nums[low] < nums[mid])					// left side is sorted
        			low = mid + 1;	// SO - target must in the right side
        		else if(nums[low] == nums[mid])			// cannot tell...
        			low++;
        		else{													// right side is sorted
        			if(nums[high] < target)
        				high = mid - 1;
        			else
        				low = mid + 1;
        		}
        	}else
        		return true;
        }
        return false;
    }
}
