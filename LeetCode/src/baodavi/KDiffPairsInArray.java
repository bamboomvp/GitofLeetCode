package baodavi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class KDiffPairsInArray {
    public int findPairs(int[] nums, int k) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
        	Integer cnt = map.get(num);
        	if(cnt == null)	map.put(num, 1);
        	else				map.put(num, cnt+1);
        }
        for(Map.Entry<Integer, Integer> pair : map.entrySet()){
        	if(k == 0 && pair.getValue() > 1)	res++;
        	if(k > 0 && map.containsKey(pair.getKey() + k))	res++;
        }
        return res;
    }
    
    public int findPairs2Ptrs(int[] nums, int k) {
    	int res = 0;
    	Arrays.sort(nums);
    	int j = 0;
    	for(int i = 0; i < nums.length; i++){
    		j = Math.max(i + 1, j); // if we found a j already, then i increased, new j has to be larger than old j
    		while(j < nums.length && nums[j] - nums[i] < k) j++;
    		if(j < nums.length && nums[j] - nums[i] == k) res++;
    		while(i < nums.length - 1 && nums[i] == nums[i + 1])	 i++;
    	}
    	return res;
    }
}
