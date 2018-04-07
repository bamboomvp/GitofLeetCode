package baodavi;

import java.util.HashMap;
import java.util.Map;

public class FourSumII {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if(A == null || A.length == 0){
        	return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int l = 0; l < D.length; l++){
        	if(!map.containsKey(D[l])){
        		map.put(D[l], 0);
        	}
        	map.put(D[l], map.get(D[l]) + 1);
        }
        int cnt = 0;
        for(int i = 0; i < A.length; i++){
        	for(int j = 0; j < B.length; j++){
        		for(int k = 0; k < C.length; k++){
        			int target = 0 - A[i] - B[j] - C[k];
        			if(map.containsKey(target)){
        				cnt += map.get(target);
        			}
        		}
        	}
        }
        return cnt;
    }
    
    //我们如果把A和B的两两之和都求出来，
    //在哈希表中建立两数之和跟其出现次数之间的映射，
    //那么我们再遍历C和D中任意两个数之和，
    //我们只要看哈希表存不存在这两数之和的相反数就行了
    public int fourSumCountUpdate(int[] A, int[] B, int[] C, int[] D) {
    	int cnt = 0;
    	Map<Integer, Integer> map = new HashMap<>();
    	for(int i = 0; i < A.length; i++){
    		for(int j = 0; j < B.length; j++){
    			int subSum = A[i] + B[j];
    			if(!map.containsKey(subSum)){
    				map.put(subSum, 0);
    			}
    			map.put(subSum, map.get(subSum) + 1);
    		}
    	}
    	for(int i = 0; i < C.length; i++){
    		for(int j = 0; j < D.length; j++){
    			int target = 0 - (C[i] + D[j]);
    			if(map.containsKey(target)){
    				cnt += map.get(target);
    			}
    		}
    	}
    	return cnt;
    }
}
