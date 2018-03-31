package baodavi;
public class MaximumSubarray {
	
	// 2018 update
	public int maxSubArrayNew(int[] A){
		if(A == null || A.length == 0){
			return 0;
		}
		int max = Integer.MIN_VALUE, sum = 0, minSum = 0;
		for(int i = 0; i < A.length; i++){
			sum += A[i];
			max = Math.max(max, sum - minSum);
			minSum = Math.min(minSum, sum);
		}
		return max;
	}
	
	public int maxSubArray(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		} else if (A.length == 1) {
			return A[0];
		} else {
			int localMax = A[0];
			int localLow, localHigh;
			localLow = localHigh = 0;
			int globalMax = localMax;
			int globalLow, globalHigh;
			globalLow = globalHigh = 0;
			for (int i = 1; i < A.length; i++) {
				// localMax = Math.max(localMax + A[i], A[i]);
				// globalMax = Math.max(globalMax, localMax);
				if (localMax + A[i] > A[i]) {
					localMax = localMax + A[i]; // take the current elem into
												// current subarray
					localHigh = i;
					if (localMax > globalMax) {
						globalMax = localMax;
						globalHigh = i;
					}
				} else {
					localMax = A[i]; // disgard the previous subarray, starting
										// at current elem for a new subarray
					localLow = localHigh = i;
					if (localMax > globalMax) {
						globalMax = localMax;
						globalLow = globalHigh = i;
					}
				}
			}

			System.out.println(globalLow + " | " + globalHigh);

			return globalMax;
		}
	}
	
	public static void main(String[] args){
		MaximumSubarray ins = new MaximumSubarray();
		int res = ins.maxSubArray(new int[]{ -2, 1, -3, 4, -1, 2, 1, -5, 4});
	}
}
