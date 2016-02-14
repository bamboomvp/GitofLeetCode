package baodavi;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {
	public String convert(String s, int nRows) {
		if (s == null || s.length() == 0 || nRows < 1) {
			return "";
		}

		if (nRows == 1) {
			return s;
		}

		List<List<Character>> zigZagMagic = new ArrayList<>();
		for (int i = 0; i < nRows; i++) {
			zigZagMagic.add(new ArrayList<>());
		}

		int zigZagHead = 0;
		boolean zigZagTurn = true;
		for (int i = 0; i < s.length(); i++) {
			zigZagMagic.get(zigZagHead).add(s.charAt(i));
			if (zigZagHead == zigZagMagic.size() - 1) {
				zigZagTurn = false;
			}
			if (zigZagHead == 0) {
				zigZagTurn = true;
			}

			if (zigZagTurn) {
				zigZagHead++;
			} else {
				zigZagHead--;
			}
		}

		StringBuilder sb = new StringBuilder();
		StringBuilder sbTmp = new StringBuilder();
		for (List<Character> l : zigZagMagic) {
			sbTmp.setLength(0);
			for (char c : l) {
				sbTmp.append(c);
			}
			sb.append(sbTmp.toString());
		}

		return sb.toString();
	}
}
