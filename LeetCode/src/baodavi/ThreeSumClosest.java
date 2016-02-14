package baodavi;

import java.util.Arrays;

public class ThreeSumClosest {

	public int threeSumClosest(int[] num, int target) {
		if (num == null || num.length < 3) {
			return 0;
		}

		int closest = target - (num[0] + num[1] + num[2]);
		Arrays.sort(num);
		for (int i = 0; i < num.length - 2; i++) {
			int curr = TwoSumClosest(num, target - num[i], i + 1);
			if (Math.abs(curr) < Math.abs(closest)) {
				closest = curr;
			}
		}

		return target - closest;
	}

	private int TwoSumClosest(int[] num, int target, int start) {
		int closest = target - (num[start] + num[start + 1]);
		int low = start;
		int high = num.length - 1;
		while (low < high) {
			int tmp = target - (num[low] + num[high]);
			if (Math.abs(tmp) < Math.abs(closest)) {
				closest = tmp;
			}
			if (tmp < 0) {
				high--;
			} else if (tmp > 0) {
				low++;
			} else {
				break;
			}
		}
		return closest;
	}
}
