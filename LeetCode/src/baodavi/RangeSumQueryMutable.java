package baodavi;

public class RangeSumQueryMutable {

	private int[] BIT;
	private int[] nums;
	
    public RangeSumQueryMutable(int[] nums) {
        BIT = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++){
        	init(i + 1, nums[i]);
        }
        this.nums = nums;
    }
    
    private void init(int i, int val){
    	while(i < BIT.length){
    		BIT[i] += val;
    		i = i + (i & -i);
    	}
    }

    void update(int i, int val) {
        int delta = val - nums[i];
        nums[i] = val;
        init(i + 1, delta);
    }

    public int sumRange(int i, int j) {
    	return getSum(j + 1) - getSum(i);
    }
    
    private int getSum(int i){
    	int sum = 0;
    	while(i > 0){
    		sum += BIT[i];
    		i = i - (i & -i);
    	}
    	return sum;
    }
}

// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);