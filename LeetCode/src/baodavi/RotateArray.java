package baodavi;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        int trueK = k % nums.length;
        int start1 = 0, end1 = nums.length - trueK - 1;
        int start2 = nums.length - trueK, end2 = nums.length - 1;
        rotateHelper(start1, end1, nums);
        rotateHelper(start2, end2, nums);
        rotateHelper(0, nums.length - 1, nums);
    }
    
    private void rotateHelper(int low, int high, int[] nums){
        while(low < high){
        	int tmp = nums[low];
        	nums[low] = nums[high];
        	nums[high] = tmp;
        	low++;
        	high--;
        }
    }
}
