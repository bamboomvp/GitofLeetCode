package baodavi;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int idx = 0; idx < nums.length; idx++){
        	int elemAsIdx = Math.abs(nums[idx]);
        	if(nums[elemAsIdx - 1] > 0)
        		nums[elemAsIdx - 1] *= -1;
        }
        List<Integer> res = new ArrayList<>();
        for(int idx = 0; idx < nums.length; idx++){
        	if(nums[idx] > 0)	res.add(idx + 1);
        }
        return res;
    }
}
