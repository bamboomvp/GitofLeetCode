package baodavi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class LargestNumber {
    public String largestNumber(int[] nums) {
    	StringBuilder sb = new StringBuilder();
    	if(nums == null || nums.length == 0)	return null;
    	// bubble sort...
    	for(int i = 0; i < nums.length; i++){
    		for(int j = nums.length - 1; j > i; j--){
    			if(digitCompare(numToDigits(nums[j]), numToDigits(nums[j - 1]))){
    				int tmp = nums[j - 1];
    				nums[j - 1] = nums[j];
    				nums[j] = tmp;
    			}
    		}
    	}
    	boolean allZeroFlag = true;
    	for(int k = nums.length - 1; k >= 0; k--){
    		sb.append(nums[k]);
    		if(nums[k] > 0)	allZeroFlag = false;
    	}
    	if(allZeroFlag)	return "0";
    	else	return sb.toString();
    }
    
    private List<Integer> numToDigits(int num){
    	List<Integer> res = new LinkedList<>();
    	if(num == 0){
    		res.add(0);
    	}else{
	    	while(num != 0){
	    		res.add(0, num % 10);
	    		num /= 10;
	    	}
    	}
    	return res;
    }
    
    private boolean digitCompare(List<Integer> num1, List<Integer> num2){
    	int ind1, ind2;
    	ind1 = ind2 = 0;
    	while(ind1 < num1.size() || ind2 < num2.size()){
    		if(ind1 >= num1.size()){
        		if(num1.get(0) < num2.get(ind2))			return true;
        		else if(num1.get(0) > num2.get(ind2))	return false;
    		}else if(ind2 >= num2.size()){
        		if(num1.get(ind1) < num2.get(0))			return true;
        		else if(num1.get(ind1) > num2.get(0))	return false;
    		}else{
        		if(num1.get(ind1) < num2.get(ind2))			return true;
        		else if(num1.get(ind1) > num2.get(ind2))	return false;
    		}
			ind1++;
			ind2++;
    	}
    	// all equal, so...
    	return true;
    }
    
    public String largestNumberRef(int[] num) {
		if(num == null || num.length == 0)
		    return "";
		
		// Convert int array to String array, so we can sort later on
		String[] s_num = new String[num.length];
		for(int i = 0; i < num.length; i++)
		    s_num[i] = String.valueOf(num[i]);
			
		// Comparator to decide which string should come first in concatenation
		Comparator<String> comp = new Comparator<String>(){
		    @Override
		    public int compare(String str1, String str2){
		        String s1 = str1 + str2;
		        String s2 = str2 + str1;
		        return s2.compareTo(s1); // reverse order here, so we can do append() later
		    }
        };
		
		Arrays.sort(s_num, comp);
       // An extreme edge case by lc, say you have only a bunch of 0 in your int array
       if(s_num[0].charAt(0) == '0')
           return "0";
           
		StringBuilder sb = new StringBuilder();
		for(String s: s_num)
	            sb.append(s);
		
		return sb.toString();
	}
}
