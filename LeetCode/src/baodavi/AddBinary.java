package baodavi;

public class AddBinary {
	public static final String s;
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        boolean carry = false;
        int range = Math.max(a.length(), b.length());
        boolean currA, currB;
        for (int i = 0; i < range; i++) {
            try {
                currA = a.charAt(a.length() - i - 1) == '1';
            } catch (IndexOutOfBoundsException e) {
                currA = false;
            }
            try {
                currB = b.charAt(b.length() - i - 1) == '1';
            } catch (IndexOutOfBoundsException e) {
                currB = false;
            }

            if (!carry) {
                if (!(currA || currB)) {
                    sb.append("0");
                    carry = false;
                } else if (currA && currB) {
                    sb.append("0");
                    carry = true;
                } else {
                    sb.append("1");
                    carry = false;
                }
            } else {
                if (!(currA || currB)) {
                    sb.append("1");
                    carry = false;
                } else if (currA && currB) {
                    sb.append("1");
                    carry = true;
                } else {
                    sb.append("0");
                    carry = true;
                }
            }
        }

        if (carry) {
            sb.append("1");
        }

        return sb.reverse().toString();
    }
    
    public static void main(){
    	s = "abc";
    	final String sb;
    	sb = "abc";
    	sb = "cde";
    }
}
