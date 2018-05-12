package baodavi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class InsertDeleteGetRandomO1 {
	class RandomizedSet {
		private Map<Integer, Integer> hashTable;
		private int[] array;
		private int validLen;
	    /** Initialize your data structure here. */
	    public RandomizedSet() {
	        this.hashTable = new HashMap<>();
	        this.array = new int[10];
	        this.validLen = 0;
	    }
	    
	    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
	    public boolean insert(int val) {
	        if(this.hashTable.containsKey(val)){
	        	return false;
	        }else{
	        	// resizing
	        	if(this.validLen == this.array.length){
	        		this.array = Arrays.copyOf(this.array, this.array.length * 2);
	        	}
	        	int index = this.validLen;
	        	this.array[index] = val;
	        	this.validLen += 1;
	        	this.hashTable.put(val, index);
	        	return true;
	        }
	    }
	    
	    /** Removes a value from the set. Returns true if the set contained the specified element. */
	    public boolean remove(int val) {
	        if(!this.hashTable.containsKey(val)){
	        	return false;
	        }else{
	        	int idx1 = this.hashTable.get(val);
	        	int idx2 = this.validLen - 1;
	        	if(idx1 != idx2){
		        	this.array[idx1] = this.array[idx2]; // replace
		        	this.hashTable.put(this.array[idx2], idx1);
	        	}
	        	this.hashTable.remove(val);
	        	this.validLen -= 1;
	        	return true;
	        }
	    }
	    
	    /** Get a random element from the set. */
	    public int getRandom() {
	        int randIdx = (int) (Math.random() * this.validLen);
	        return this.array[randIdx];
	    }
	}
}
