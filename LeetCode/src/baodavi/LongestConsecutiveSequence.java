package baodavi;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
        	set.add(nums[i]);
        }
        int max = 0;
        for(int j = 0; j < nums.length; j++){
        	if(set.contains(nums[j] - 1)){
        		continue;
        	}else{ // this is the lower boundary of a potential consecutive sequence.
        		int cnt = 1, num = nums[j];
        		while(set.contains(num + 1)){
        			cnt++;
        			num += 1;
        		}
        		max = Math.max(max, cnt);
        	}
        }
        return max;
    }
}
