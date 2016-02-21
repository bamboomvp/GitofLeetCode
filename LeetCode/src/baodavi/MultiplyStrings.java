package baodavi;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
    	
    	// special case
        if(num1.equals("0") || num2.equals("0")){
        	return new String("0");
        }
        
        // �Ȱ�string��ת
        String num1_reverse = new StringBuilder(num1).reverse().toString();
        String num2_reverse = new StringBuilder(num2).reverse().toString();
        
        // ���������ų˻�
        int[] multiple_arr = new int[num1.length() + num2.length()];
        
        // ����ȷλ���ۼӳ˻�
        for(int i = 0; i < num1_reverse.length(); i++){
        	for(int j = 0; j < num2_reverse.length(); j++){
        		multiple_arr[i + j] += (num1_reverse.charAt(i) - '0') * (num2_reverse.charAt(j) - '0');
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        for(int k = 0; k < multiple_arr.length; k++){
        	int digit = multiple_arr[k] % 10;	// ��ǰλ
        	int carry = multiple_arr[k] / 10;	// ��λ  
        	if(k != multiple_arr.length - 1){
        		multiple_arr[k + 1] += carry;
        	}
        	
        	sb.insert(0, digit);	// prepend  
        }
        
        // �Ƴ�ǰ����  
        while(sb.charAt(0) == '0' && sb.length() > 1){
        	sb.deleteCharAt(0);
        }
        
        return sb.toString();
    }
}
