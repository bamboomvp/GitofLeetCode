package baodavi;

import helpers.VersionControl;

/* The isBadVersion API is defined in the parent class VersionControl.
boolean isBadVersion(int version); */

public class FirstBadVersion extends VersionControl {
    public int firstBadVersion(int n) {
        if(n < 1){
        	return -1;
        }else if(n == 1){
        	return isBadVersion(n) ? n : -1;
        }
        
        int badVersion = -1;
        int low, high, middle;
        low = 1;
        high = n;
        while(low <= high){
        	middle = low + (high - low) / 2;
        	if(isBadVersion(middle)){
        		high = middle - 1;
        		badVersion = middle;
        	}else{
        		low = middle + 1;
        	}
        }
        
        return badVersion;
    }
}
