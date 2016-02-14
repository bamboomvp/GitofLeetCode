package baodavi;

public class ExcelSheetColumnNumber {
	public int titleToNumber(String s) {
		char[] charArr = s.toCharArray();
		int res = 0;
		for (int i = 0; i < charArr.length; i++) {
			int curr = (charArr[i] - 'A' + 1);
			res = (res * 26) + curr;
		}

		return res;
	}
}
