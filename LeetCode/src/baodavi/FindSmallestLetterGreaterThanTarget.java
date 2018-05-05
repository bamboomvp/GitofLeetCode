package baodavi;

public class FindSmallestLetterGreaterThanTarget {
	public char nextGreatestLetterUpdate(char[] letters, char target) {
		boolean[] seen = new boolean[26];
		for(char letter : letters){
			seen[letter - 'a'] = true;
		}
		while(true){
			target++;
			if(target > 'z')	target = 'a'; // wrap up back
			if(seen[target - 'a'])	return target;
		}
	}
	
    public char nextGreatestLetter(char[] letters, char target) {
    	if(target < letters[0]){
    		return letters[0];
    	}else if(target > letters[letters.length - 1]){
    		return letters[letters.length - 1];
    	}else{
	        int low = 0, high = letters.length - 1;
	        while(low + 1 < high){
	        	int mid = low + (high - low) / 2;
	        	if(letters[mid] <= target){
	        		low = mid + 1;
	        	}else{
	        		high = mid -1;
	        	}
	        }
	        if(low < high){
	        	if(letters[low] > target)			return letters[low];
	        	else if(letters[high] > target)	return letters[high];
	        	else										return letters[high + 1];
	        }else{
	        	if(letters[low] > target)	return letters[low];
	        	else								return letters[low + 1];
	        }
    	}
    }
}
