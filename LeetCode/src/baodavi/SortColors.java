package baodavi;
public class SortColors {
	public void sortColors(int[] A) {
		if (A == null || A.length == 0) {
			return;
		}

		int p1 = -1;
		int p2 = -1;

		for (int ind = 0; ind < A.length; ind++) {
			if (A[ind] == 0) {
				if (p1 == -1 && p2 == -1) {
					continue;
				} else if (p1 == -1) {
					A[p2] = 0;
					A[ind] = 2;
					p2++;
				} else if (p2 == -1) {
					A[p1] = 0;
					A[ind] = 1;
					p1++;
				} else {
					A[p1] = 0;
					A[p2] = 1;
					A[ind] = 2;
					p1++;
					p2++;
				}
			} else if (A[ind] == 1) {
				if (p1 == -1 && p2 == -1) {
					p1 = ind;
				} else if (p1 == -1 && p2 != -1) {
					p1 = p2;
					A[ind] = 2;
					A[p2] = 1;
					p2++;
				} else if (p1 != -1 && p2 != -1) {
					A[ind] = 2;
					A[p2] = 1;
					p2++;
				}
			} else {
				if (p2 == -1) {
					p2 = ind;
				}
			}
		}
	}
}
