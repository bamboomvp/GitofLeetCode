package baodavi;

// Determine whether an integer is a palindrome. Do this without extra space.
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
    	int mirror = 0;
    	
    	int currVal = x;
    	while(currVal != 0){
    		int digit = currVal % 10;
    		mirror *= 10;
    		mirror += digit;
    		currVal /= 10;
    	}
    	
    	if(x >= 0){
    		return mirror == x;
    	}else{
    		return mirror == -x;
    	}
    }
    
	public boolean isPalindromeEnhanced(int x) {
		// negative numbers are not palindrome
		if (x < 0)
			return false;

		// initialize how many zeros
		int div = 1;
		while (x / div >= 10) {
			div *= 10;
		}

		while (x != 0) {
			int left = x / div;
			int right = x % 10;

			if (left != right)
				return false;

			x = (x % div) / 10;
			div /= 100;
		}

		return true;
	}
}
