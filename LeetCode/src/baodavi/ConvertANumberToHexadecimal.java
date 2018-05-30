package baodavi;

public class ConvertANumberToHexadecimal {
    public String toHex(int num) {
        if(num == 0)	return "0";
        char[] map = "0123456789abcdef".toCharArray();
        StringBuilder hex = new StringBuilder();
        // handle 4 bits each iteration
        for(; num != 0; num >>>= 4){
        	hex.insert(0, map[num & 0xf]);
        }
        return hex.toString();
    }
}
