package baodavi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
    	
    	List<Integer> res = new ArrayList<>();
    	
    	Map<Integer, Set<Integer>> dependents = new TreeMap<>(); // key is depended on by val1, val2, val3, ...
    	Map<Integer, Set<Integer>> dependsOn = new TreeMap<>(); // key depends on val1, val2, val3, ...
    	
    	for(int i = 0; i < numCourses; i ++){
    		dependents.put(i, new TreeSet<Integer>());
    		dependsOn.put(i, new TreeSet<Integer>());
    	}
    	
    	for(int j = 0; j < prerequisites.length; j++){
    		
    		int m = prerequisites[j][0];
    		int n = prerequisites[j][1];
    		
			// it means that m depends on n... maybe?
			dependents.get(n).add(m);
			dependsOn.get(m).add(n);
    	}
    	
    	while(!dependsOn.isEmpty()){
    		
    		boolean flag = false;
    		Iterator<Entry<Integer, Set<Integer>>> it = dependsOn.entrySet().iterator();
    		
    		while(it.hasNext()){
    			Entry<Integer, Set<Integer>> curr_entry = it.next();
    			// this guy depends on nobody...
    			if(curr_entry.getValue().isEmpty()){
    				res.add(curr_entry.getKey()); // add it...
    				// release all its dependents from it...
    				for(Integer x : dependents.get(curr_entry.getKey())){
    					dependsOn.get(x).remove(curr_entry.getKey());
    				}
    				
    				it.remove();
    				flag = true;
    			}
    		}
    		
    		// find circle!!!
    		if(!flag){
    			return new int[0];
    		}
    	}
    	
    	int[] resArr = new int[numCourses];
    	for(int k = 0; k < resArr.length; k++){
    		resArr[k] = res.get(k);
    	}
    	
    	return resArr;
    }
}
