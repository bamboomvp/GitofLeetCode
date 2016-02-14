package baodavi;
public class ExcelSheetColumnTitle {

	public String convertToTitle(int n) {
		StringBuilder sb = new StringBuilder();
		while (n > 0) {
			int curr = n % 26;
			int rest = n / 26;
			if (curr == 0) {
				rest -= 1; // special case
				sb.append(String.valueOf('Z'));
			} else {
				sb.append(String.valueOf((char) ('A' + curr - 1)));
			}
			n = rest;
		}
		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
