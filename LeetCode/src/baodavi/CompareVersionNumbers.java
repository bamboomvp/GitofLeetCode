package baodavi;
public class CompareVersionNumbers {
	private int compareVersionHelper(int ind1, int ind2, String[] v1Arr,
			String[] v2Arr) {
		if (ind1 == v1Arr.length && ind2 == v2Arr.length) {
			return 0;
		} else if (ind1 == v1Arr.length) {
			while (ind2 != v2Arr.length) {
				if (Integer.parseInt(v2Arr[ind2]) != 0) {
					return -1;
				}
				ind2++;
			}
			return 0;
		} else if (ind2 == v2Arr.length) {
			while (ind1 != v1Arr.length) {
				if (Integer.parseInt(v1Arr[ind1]) != 0) {
					return 1;
				}
				ind1++;
			}
			return 0;
		} else {
			if (Integer.parseInt(v1Arr[ind1]) < Integer.parseInt(v2Arr[ind2])) {
				return -1;
			} else if (Integer.parseInt(v1Arr[ind1]) > Integer
					.parseInt(v2Arr[ind2])) {
				return 1;
			} else {
				return compareVersionHelper(ind1 + 1, ind2 + 1, v1Arr, v2Arr);
			}
		}
	}

	public int compareVersion(String version1, String version2) {

		String[] v1Arr = version1.split("\\.");
		String[] v2Arr = version2.split("\\.");
		return compareVersionHelper(0, 0, v1Arr, v2Arr);
	}

	public static void main(String[] argv) {
		new CompareVersionNumbers().compareVersion("1", "0");
	}
}
