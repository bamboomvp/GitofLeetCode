package baodavi;

public class Sqrt {
    public int mySqrt(int x) {
        // Instead of using fancy Newton's method, 
    	// this plain binary search approach also works.
    	if(x == 0)	return 0;
    	int left = 1, right = x;
    	while(true){
    		int mid = left + (right - left) / 2;
    		if(mid > x / mid){
    			right = mid - 1;
    		}else{
    			// THIS IS VERY IMPORTANT!!! (the base case)
    			if(mid + 1 > x / (mid + 1))	return mid;
    			left = mid + 1;
    		}
    	}
    }
}
