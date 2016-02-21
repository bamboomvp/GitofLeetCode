package baodavi;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
    	
    	// special case
        if(num1.equals("0") || num2.equals("0")){
        	return new String("0");
        }
        
        // 先把string翻转
        String num1_reverse = new StringBuilder(num1).reverse().toString();
        String num2_reverse = new StringBuilder(num2).reverse().toString();
        
        // 构建数组存放乘积
        int[] multiple_arr = new int[num1.length() + num2.length()];
        
        // 在正确位置累加乘积
        for(int i = 0; i < num1_reverse.length(); i++){
        	for(int j = 0; j < num2_reverse.length(); j++){
        		multiple_arr[i + j] += (num1_reverse.charAt(i) - '0') * (num2_reverse.charAt(j) - '0');
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        for(int k = 0; k < multiple_arr.length; k++){
        	int digit = multiple_arr[k] % 10;	// 当前位
        	int carry = multiple_arr[k] / 10;	// 进位  
        	if(k != multiple_arr.length - 1){
        		multiple_arr[k + 1] += carry;
        	}
        	
        	sb.insert(0, digit);	// prepend  
        }
        
        // 移除前导零  
        while(sb.charAt(0) == '0' && sb.length() > 1){
        	sb.deleteCharAt(0);
        }
        
        return sb.toString();
    }
}
