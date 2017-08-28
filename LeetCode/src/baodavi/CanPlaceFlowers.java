package baodavi;

public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n == 0){
        	return true;
        }else if((flowerbed.length % 2 == 0) && ((flowerbed.length / 2) < n)){
        	return false;
        }else if((flowerbed.length % 2 == 1) && ((flowerbed.length / 2 + 1) < n)){
        	return false;
        }else{
        	int cnt = 0;
        	for(int i = 0; i < flowerbed.length; i++){
        		if(canPlaceThisSlot(flowerbed, i)){
        			flowerbed[i] = 1;
        			cnt++;
        		}
        	}
        	return (cnt >= n) ? true : false;
        }
    }
    
    private boolean canPlaceThisSlot(int[] flowerbed, int index){
    	if(flowerbed[index] == 1)
    		return false;
    	if(flowerbed.length == 1)
    		return true;
    	
    	if(index == 0){
    		return flowerbed[index + 1] == 0 ? true : false;
    	}else if(index == flowerbed.length - 1){
    		return flowerbed[index - 1] == 0 ? true : false;
    	}else if(flowerbed[index - 1] == 0 && flowerbed[index + 1] == 0){
    		return true;
    	}else{
    		return false;
    	}
    }
}
