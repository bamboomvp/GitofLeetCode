package baodavi;
public class PlusOne {

	private boolean checkSpecial(int[] digits) {
		for (int i = 0; i < digits.length; i++) {
			if (digits[i] != 9) {
				return false;
			}
		}
		return true;
	}

	public int[] plusOne(int[] digits) {

		if (checkSpecial(digits)) {
			int[] res = new int[digits.length + 1];
			res[0] = 1;
			return res;
		}

		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] == 9) {
				digits[i] = 0;
			} else {
				digits[i] += 1;
				break;
			}
		}

		return digits;
	}
}
