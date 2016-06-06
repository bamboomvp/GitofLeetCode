package baodavi;

import java.util.ArrayList;
import java.util.List;

public class AdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        return isAdditiveNumHelper(num, 0, new ArrayList<Integer>());
    }
    
    private boolean isAdditiveNumHelper(String num, int index, List<Integer> candidate){
    	if(index == num.length()){
    		if(candidate.size() >= 3)
    			return true;
    		else
    			return false;
    	}
    	
    	boolean magicZero = false;
    	if(num.charAt(index) == '0')
    		magicZero = true;
    	
    	boolean flag = false;
    	for(int i = index + 1; i <= num.length(); i++){
    		boolean res = false;
    		String sub = num.substring(index, i);
    		int subInt;
    		try{
    			subInt = Integer.valueOf(sub);
    		}catch(Exception e){
    			break;
    		}
    		if(candidate.size() <= 1){
    			candidate.add(subInt);
    			res = isAdditiveNumHelper(num, i, candidate);
    			candidate.remove(candidate.size() - 1);
    		}else{
    			if(candidate.get(candidate.size() - 1) + candidate.get(candidate.size() - 2) == subInt){
        			candidate.add(subInt);
        			res = isAdditiveNumHelper(num, i, candidate);    			
        			candidate.remove(candidate.size() - 1);
    			}else{
    				if(!magicZero)
    					continue;
    			}
    		}
    		if(res){
    			flag = true;
    			break;
    		}
    		
    		// special case
    		if(magicZero)
    			break;
    	}
    	
    	return flag;
    }
    
    public static void main(String args[]){
    	new AdditiveNumber().isAdditiveNumber("1203");
    }
    
    
    
//    思路：
//
//    其实只要前两个数固定了，后面是否能划分就是确定的了。
//
//    因为前两个数决定了第三个数，第三个数和第二个数决定了第四个。。。
//
//    所以，枚举前两个数的终点位置，进行递归判断即可。
    
    public boolean isAdditiveNumberADV(String num){
    	for(int i = 0; i < num.length(); i++){
    		for(int j = i + 1; j < num.length() - i - 1; j++){ // this is IMPORTANT!!!
    			String first = num.substring(0, i + 1);
    			String second = num.substring(i + 1, j + 1);
    			if(valid(j + 1, num, first, second))
    				return true;
    		}
    	}
    	return false;
    }
    
    private boolean valid(int start, String num, String first, String second){
    	if(start == num.length())
    		return true;
    	long f = Long.parseLong(first);
    	long s = Long.parseLong(second);
    	// making sure there is no heading ZERO!!!
    	if(!Long.toString(f).equals(first) || !Long.toString(s).equals(second))  
            return false; 
    	long sum = f + s;
    	String sumStr = Long.toString(sum);
    	// shortcut
    	if(start + sumStr.length() > num.length())
    		return false;
    	String third = num.substring(start, start + sumStr.length()); // it can ONLY be this!!!
    	long t = Long.parseLong(third);
    	if(t != sum || !Long.toString(t).equals(third)) // making sure there is no heading ZERO!!!
    		return false;
    	else
    		return valid(start + sumStr.length(), num, second, third);
    }
}
