package baodavi;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        boolean flag = grayCodeBacktracer(0, n, res);
        if(flag)
        	return res;
        else
        	return new ArrayList<>();
    }
    
    private boolean grayCodeBacktracer(int currNum, int n, List<Integer> res){
    	if(res.size() == Math.pow(2, n)){
    		return true;
    	}
    	
    	for(int i = 0; i < n; i++){
    		int newNum = currNum ^ (1 << i);
    		if(!res.contains(newNum)){
    			res.add(newNum);
    			boolean flag = grayCodeBacktracer(newNum, n, res);
    			if(flag)
    				return true;
    			res.remove(res.size() - 1);
    		}
    	}
    	
    	return false;
    }
}
