package baodavi;
public class MaximumProductSubarray {
	public int maxProduct(int[] A) {
		if (A.length == 1) {
			return A[0];
		}

		int localMax, localMin, globalMax;
		localMax = localMin = globalMax = A[0];
		int maxL, maxH, minL, minH, globalL, globalH;
		maxL = maxH = minL = minH = globalL = globalH = 0;

		for (int i = 1; i < A.length; i++) {
			if ((A[i] * localMax > A[i])
					&& (A[i] * localMax >= A[i] * localMin)) {
				maxH = i;
				localMax *= A[i];
				if (A[i] * localMin < A[i]) {
					minH = i;
					localMin *= A[i];
				} else {
					minL = minH = i;
					localMin = A[i];
				}
				if (globalMax < localMax) {
					globalH = i;
					globalMax = localMax;
				}
			} else if ((A[i] >= A[i] * localMax) && (A[i] >= A[i] * localMin)) {
				int maxLCopy = maxL;
				int localMaxCopy = localMax;
				maxL = maxH = i;
				localMax = A[i];
				if (A[i] * localMaxCopy < A[i] * localMin) {
					minL = maxLCopy;
					minH = i;
					localMin = A[i] * localMaxCopy;
				} else {
					minH = i;
					localMin *= A[i];
				}
				if (globalMax < localMax) {
					globalL = globalH = i;
					globalMax = localMax;
				}
			} else {
				int maxLCopy = maxL;
				int localMaxCopy = localMax;
				maxL = minL;
				maxH = i;
				localMax = localMin * A[i];
				if (A[i] * localMaxCopy < A[i]) {
					minL = maxLCopy;
					minH = i;
					localMin = localMaxCopy * A[i];
				} else {
					minL = minH = i;
					localMin = A[i];
				}
				if (globalMax < localMax) {
					globalL = maxL;
					globalH = maxH;
					globalMax = localMax;
				}
			}
		}
		System.out.println(globalL + " | " + globalH);

		return globalMax;
	}

	public static void main(String args[]) {
		MaximumProductSubarray ins = new MaximumProductSubarray();
		int res = ins.maxProduct(new int[] { 2, -1, 3, -1 });
	}
}
