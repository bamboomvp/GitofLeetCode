package baodavi;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        
        int uniqueSubsetCnt = (int) (Math.pow(2, nums.length) - 1);
        for(int i = 0; i <= uniqueSubsetCnt; i++){
        	ArrayList<Integer> resRow = new ArrayList<>();
        	for(int j = 0; j < nums.length; j++){
        		int flag = (i >> j) & 1;
        		if(flag > 0){
        			resRow.add(nums[j]);
        		}
        	}
        	res.add(resRow);
        }
        
        return res;
    }
}
