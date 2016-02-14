package baodavi;
public class FirstMissingPositive {
	public int firstMissingPositive(int[] A) {
		for (int i = 0; i < A.length; i++) {
			if (A[i] > 0 && A[i] <= A.length) {
				if (A[A[i] - 1] != A[i]) {
					int tmp = A[A[i] - 1];
					A[A[i] - 1] = A[i];
					A[i] = tmp;
					i--;
				}
			}
		}

		for (int j = 0; j < A.length; j++) {
			if (A[j] != j + 1) {
				return j + 1;
			}
		}
		return A.length + 1;
	}
}
