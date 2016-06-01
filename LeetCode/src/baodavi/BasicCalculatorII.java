package baodavi;

import java.util.ArrayList;
import java.util.List;

public class BasicCalculatorII {
    public int calculate(String s) {
    	List<Integer> listNum = new ArrayList<>();
    	List<Character> listOp1 = new ArrayList<>();
    	List<Character> listOp2 = new ArrayList<>();
    	
        int pos1 = 0;
        int pos2 = 0;
        for(int i = 0; i < s.length(); i++){
        	Character c = s.charAt(i);
        	if(c == '+' || c == '-' || c == '*' || c == '/'){
        		pos2 = i;
        		String sub = s.substring(pos1, pos2).trim();
        		listNum.add(Integer.parseInt(sub));
        		listOp1.add(c);
     			pos1 = pos2 + 1;
        	}
        }
        listNum.add(Integer.parseInt(s.substring(pos1).trim()));
        
//        ʹ�ø�������d��¼��ǰ�������������������func��¼��һ���Ӽ��������total��¼���ʽ��ֵ��
//
//        ����ǰ�����Ϊ�˳����������϶�d����һ��������ִ�г˳����㣬��ֵ��d��
//
//        ����ǰ�����Ϊ�Ӽ��������total��dִ��func���Ӽ������㣬��ֵ��total��������func��
        
        int d = listNum.get(0);
        int total = 0;
        boolean op = true; // true means '+', false means '-'
        
        for(int j = 0; j < listOp1.size(); j++){
        	Character c = listOp1.get(j);
        	if(c == '*')
        		d = d * listNum.get(j + 1);
        	else if(c == '/')
        		d = d / listNum.get(j + 1);
        	else{
        		if(op)
        			total += d;
        		else
        			total -= d;
        		d = listNum.get(j + 1);
        		if(c == '+')
        			op = true;
        		else
        			op = false;
        	}
        }
        
        if(op)
        	total += d;
        else 
        	total -= d;
        
        return total;
        
        
        
   /* go die...     
        int magic = 0;
        for(int m = 0; m < listOp1.size(); m++){
        	Character c = listOp1.get(m);
        	if(c == '+' || c == '-')
        		listOp2.add(c);
        	else{
        		int num1 = listNum.remove(m - magic);
        		int num2 = listNum.remove(m - magic);
        		if(c == '*')
        			listNum.add(m - magic, num1 * num2);
        		else
        			listNum.add(m - magic, num1 / num2);
        		magic++;
        	}
        }
        int res = listNum.get(0);
        for(int n = 0; n < listOp2.size(); n++){
        	if(listOp2.get(n) == '+')
        		res += listNum.get(n + 1);
        	else
        		res -= listNum.get(n + 1);
        }
        
        return res;
        
        */
    }
}
