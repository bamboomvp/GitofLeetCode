package baodavi;

/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
*/

public class DecodeWays {
	
//	private static int ways = 0;
//	
//    public int numDecodings(String s) {
//    	numDecodingsRecursive(s, 0, false);
//    	return ways;
//    }
//    
//    private void numDecodingsRecursive(String s, int currIdx, boolean jump) {
//    	if(currIdx == s.length()){
//    		ways += 1;
//    		return;
//    	}else if(currIdx > s.length()){
//    		return;
//    	}else{
//    		if(jump){
//    			int num = Integer.parseInt(s.substring(currIdx - 1, currIdx + 1));
//    			if(num < 1 || num > 26)
//    				return;
//    		}else{
//    			int num = s.charAt(currIdx) - '0';
//    			if(num == 0)
//    				return;
//    		}
//    		numDecodingsRecursive(s, currIdx + 1, false);
//    		numDecodingsRecursive(s, currIdx + 2, true);
//    	}
//    }
	
	/*  DP! DP! DP! DP!DP! DP! DP! DP!DP! DP! DP! DP!DP! DP! DP! DP!DP! DP! DP! DP!DP! DP! DP! DP! */
	// DW[i] = DW[i-1] + if possible DW[i-2]
	
	public int numDecodings(String s) {
		
		if(s == null || s.length() == 0)
			return 0;
		if(s.charAt(0) - '0' == 0)
			return 0;
		
		int[] DW = new int[s.length() + 1];
		DW[0] = 1;
		DW[1] = 1;
		for(int i = 2; i < DW.length; i++){
			if(s.charAt(i - 1) - '0' == 0){
				if(s.charAt(i - 2) != '1' && s.charAt(i - 2) != '2')
					return 0;
				else
					DW[i] = 0;
			}else{
				DW[i] = DW[i - 1];
			}
			int num = Integer.parseInt(s.substring(i - 2, i));
			if(num >= 10 && num <= 26){
				DW[i] += DW[i - 2];
			}
		}
		
		return DW[DW.length - 1];
	}
	
	public static void main(String args[]){
		new DecodeWays().numDecodings("10");
	}
}
