package baodavi;

public class UTF8Validation {
    public boolean validUtf8(int[] data) {
        byte oneByteMask = (byte) (1 << 7);
        byte twoByteMask = (byte) (7 << 5);
        byte threeByteMask = (byte) (15 << 4);
        byte fourByteMask = (byte) (31 << 3);
        byte succeedingByteMask = (byte) (3 << 6);
        byte oneByteValidate = (byte) (0 << 7);
        byte twoByteValidate = (byte) (6 << 5);
        byte threeByteValidate = (byte) (15 << 4);
        byte fourByteValidate = (byte) (30 << 3);
        byte succeedingByteValidate = (byte) (2 << 6);
        int followingCnt = 0;
        for(int i = 0; i < data.length; i++){
        	if(followingCnt != 0){
        		if((data[i] & succeedingByteMask) == succeedingByteValidate)	followingCnt--;
        		else	return false;
        	}else{
	        	if((data[i] & oneByteMask) == oneByteValidate){
	        		continue;
	        	}else if((data[i] & twoByteMask) == twoByteValidate){
	        		followingCnt = 1;
	        	}else if((data[i] & threeByteMask) == threeByteValidate){
	        		followingCnt = 2;
	        	}else if((data[i] & fourByteMask) == fourByteValidate){
	        		followingCnt = 3;
	        	}else{
	        		return false;
	        	}
        	}
        }
        return true;
    }
    
    public boolean validUtf8UPDATE(int[] data) {
    	int cnt = 0;
    	for(int d : data){
    		if(cnt == 0){
    			if((d >> 5) == 0b110)	cnt = 1;
    			else if((d >> 4) == 0b1110) cnt = 2;
    			else if((d >> 3) == 0b11110) cnt = 3;
    			else if(d >> 7 == 0b1)	return false;
    		}else{
    			if((d >> 6) != 0b10) return false;
    			else	--cnt;
    		}
    	}
    	return cnt == 0;
    }
}
