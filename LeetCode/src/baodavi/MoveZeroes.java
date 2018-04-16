package baodavi;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0){
        	return;
        }
        int zeroFinder = 0;
        while(zeroFinder < nums.length){
        	if(nums[zeroFinder] != 0){
        		zeroFinder++;
        	}else{
        		int noneZeroFinder = zeroFinder + 1;
        		boolean found = false;
        		while(noneZeroFinder < nums.length){
        			if(nums[noneZeroFinder] == 0){
        				noneZeroFinder++;
        			}else{
        				found = true;
        				nums[zeroFinder] = nums[noneZeroFinder];
        				nums[noneZeroFinder] = 0;
        				zeroFinder += 1;
        				break;
        			}
        		}
        		if(!found){
        			break;
        		}
        	}
        }
    }
}
