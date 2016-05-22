package baodavi;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        
        if(s.length() < 4 || s.length() > 12)
        	return res;
        else{
        	restoreIpAddressesHelper(s, 0, new ArrayList<>(), res);
        }
        
        return res;
    }
    
    private void restoreIpAddressesHelper(String s, int currIdx, List<String> currList, List<String> res){
    	if(currList.size() == 3){
    		String lastSeg = s.substring(currIdx);
    		if(validateIpSegment(lastSeg))
    			res.add(String.join(".", currList) + "." + lastSeg);
    		return;
    	}
    	int bIdx = currIdx;
    	int cnt = currList.size();
    	for(int lIdx = currIdx + 1; lIdx <= s.length() - (3 - cnt); lIdx++){
    		String currSubStr = s.substring(bIdx, lIdx);
    		if(validateIpSegment(currSubStr)){
    			currList.add(currSubStr);
    			restoreIpAddressesHelper(s, lIdx, currList, res);
    			currList.remove(currList.size() - 1);
    		}
    	}
    }
    
    private boolean validateIpSegment(String s){
    	int ip = Integer.parseInt(s);
    	int digits = s.length();
    	if(digits == 1){
    		return ip >= 0 && ip <= 9;
    	}else if(digits == 2){
    		return ip >= 10 && ip <= 99;
    	}else if(digits == 3){
    		return ip >= 100 && ip <= 255;
    	}else
    		return false;
    }
}
