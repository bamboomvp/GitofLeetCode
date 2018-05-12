package baodavi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

public class InsertDeleteGetRandomO1Duplicate {
	class RandomizedCollectionSimple {
		private Map<Integer, Set<Integer>> hashTable;
		private List<Integer> rawData;
		private Random rand;
	    /** Initialize your data structure here. */
	    public RandomizedCollectionSimple() {
	        this.hashTable = new HashMap<>();
	        this.rawData = new ArrayList<>();
	        this.rand = new Random();
	    }
	    
	    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
	    public boolean insert(int val) {
	        boolean nonExist = true;
	        if(!hashTable.containsKey(val)){
	        	hashTable.put(val, new HashSet<Integer>());
	        }
	        Set<Integer> locations = hashTable.get(val);
	        if(!locations.isEmpty())	nonExist = false;
	        locations.add(rawData.size());
	        rawData.add(val);
	        return nonExist;
	    }
	    
	    /** Removes a value from the set. Returns true if the set contained the specified element. */
	    public boolean remove(int val) {
	    	if(!hashTable.containsKey(val) || hashTable.get(val).isEmpty()){
	    		return false;
	    	}
	    	int lastElem = rawData.get(rawData.size() - 1);
	    	Set<Integer> locationRemove = hashTable.get(val);
	    	if(lastElem != val){
		    	Set<Integer> locationAdjust = hashTable.get(lastElem);
		    	int idxReplace = locationRemove.iterator().next(); // just get the first one
		    	if(idxReplace != rawData.size() - 1){
		    		rawData.set(idxReplace, lastElem);
		    		locationAdjust.remove(rawData.size() - 1);
		    		locationAdjust.add(idxReplace);
		    	}
		    	locationRemove.remove(idxReplace);
	    	}else{
	    		locationRemove.remove(rawData.size() - 1);
	    	}
	    	rawData.remove(rawData.size() - 1);
	    	return true;
	    }
	    
	    /** Get a random element from the set. */
	    public int getRandom() {
	    	return rawData.get(rand.nextInt(rawData.size()));
	    }
	}
	
	
	
	
	
	
	
	
	class RandomizedCollection {
		
		private HashMap<Integer, Stack<Integer>> locationMap;
		private ArrayList<Integer> rawData;
		private Random rand;
		
		// helper
		private ArrayList<Integer> tmpForStack;
		
	    /** Initialize your data structure here. */
	    public RandomizedCollection() {
	        this.locationMap = new HashMap<>();
	        this.rawData = new ArrayList<>();
	        this.rand = new Random();
	        this.tmpForStack = new ArrayList<>();
	    }
	    
	    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
	    public boolean insert(int val) {
	        boolean flag = false;
	        if(!locationMap.containsKey(val)){
	        	locationMap.put(val, new Stack<Integer>());
	        }
	        Stack<Integer> locations = locationMap.get(val);
	        if(locations.isEmpty())	flag = true;
	        locations.push(rawData.size());
	        rawData.add(val);
	        return flag;
	    }
	    
	    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
	    public boolean remove(int val) {
	        if(!locationMap.containsKey(val) || locationMap.get(val).isEmpty()){
	        	return false;
	        }
	        int deleteIdx = locationMap.get(val).pop();
	        if(deleteIdx != rawData.size() - 1){
	        	// 0. find the last elem to "replace delete"
	        	int lastVal = rawData.get(rawData.size() - 1);
	        	// 1. replace the last elem val to the deleted location
	        	rawData.set(deleteIdx, lastVal);
	        	// 2. remove the last location of the last value
	        	Stack<Integer> stackToSort = locationMap.get(lastVal);
	        	stackToSort.pop();
	        	// 3. add the new location of the last value
	        	tmpForStack.clear();
	        	while(!stackToSort.isEmpty() && stackToSort.peek() > deleteIdx){
	        		tmpForStack.add(stackToSort.pop());
	        	}
	        	stackToSort.add(deleteIdx);
	        	for(int i = tmpForStack.size() - 1; i >= 0; i--){
	        		stackToSort.push(tmpForStack.get(0));
	        	}
	        }
	        rawData.remove(rawData.size() - 1);
	        return true;
	    }
	    
	    /** Get a random element from the collection. */
	    public int getRandom() {
	        return rawData.get(rand.nextInt(rawData.size()));
	    }
	}
}
