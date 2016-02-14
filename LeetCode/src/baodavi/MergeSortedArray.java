package baodavi;
public class MergeSortedArray {
	public void merge(int A[], int m, int B[], int n) {
		int aLast = m - 1;
		int bLast = n - 1;
		int newLast = m + n - 1;

		while (aLast >= 0 && bLast >= 0) {
			if (A[aLast] > B[bLast]) {
				A[newLast] = A[aLast];
				aLast--;
				newLast--;
			} else {
				A[newLast] = B[bLast];
				bLast--;
				newLast--;
			}
		}

		while (aLast >= 0) {
			A[newLast] = A[aLast];
			aLast--;
			newLast--;
		}

		while (bLast >= 0) {
			A[newLast] = B[bLast];
			bLast--;
			newLast--;
		}
	}
}
