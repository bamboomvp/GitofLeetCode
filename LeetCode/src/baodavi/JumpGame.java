package baodavi;
public class JumpGame {

	public boolean canJump(int[] A) {

		int currIndex, currCover, maxCover;
		maxCover = 0;
		for (currIndex = 0; currIndex < A.length; currIndex++) {
			if (maxCover < currIndex) {
				return false;
			}
			currCover = A[currIndex];
			if (currCover + currIndex > maxCover)
				maxCover = currCover + currIndex;
			if (maxCover >= A.length - 1)
				return true;
		}

		return false;
	}

	public int jump(int[] A) {

		int currIndex, currJump, maxCover;
		currJump = 0;
		maxCover = A[0];
		for (currIndex = 0; currIndex < A.length; currIndex++) {
			if (maxCover >= A.length - 1) {
				return currJump + 1;
			}
			int reach = currIndex + A[currIndex];
			int currReach = currIndex + 1;
			// find the greedy best next jump
			while (currReach <= reach) {
				maxCover = Math.max(maxCover, currReach + A[currReach]);
			}
			currJump += 1;
			currIndex = reach + 1;
		}

		return -1;
	}
    
	public static void main(String[] args) {
		(new JumpGame()).canJump(new int[] { 1, 1, 1, 0 });
	}

}
