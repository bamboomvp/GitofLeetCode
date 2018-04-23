package baodavi;

public class GuessNumberHigherLower {
	private int guess(int x){
		return 0;
	}
	
    public int guessNumber(int n) {
        int low = 1, high = n;
        while(low <= high){
        	int target = low + (high - low) / 2;
        	if(guess(target) == 0)	return target;
        	else if(guess(target) == -1) high = target - 1;
        	else	low = target + 1;
        }
        return -1;
    }
}
