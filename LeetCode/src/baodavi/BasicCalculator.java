package baodavi;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
解题思路：
表达式求值可以分解为下列两步完成：

1. 中缀表达式转为后缀表达式（逆波兰表达式）

2. 后缀表达式求值

以下内容来自百度百科：“后缀表达式”词条

中缀表达式转为后缀表达式的要点：

开始扫描；

数字时，加入后缀表达式；

运算符：

a. 若为 '('，入栈；

b. 若为 ')'，则依次把栈中的的运算符加入后缀表达式中，直到出现'('，从栈中删除'(' ；

c. 若为 除括号外的其他运算符， 当其优先级高于除'('以外的栈顶运算符时，直接入栈。否则从栈顶开始，依次弹出比当前处理的运算符优先级高和优先级相等的运算符，直到一个比它优先级低的或者遇到了一个左括号为止。
·当扫描的中缀表达式结束时，栈中的的所有运算符出栈；

后缀表达式求值的过程简述：

建立一个栈S

从左到右读表达式，如果读到操作数就将它压入栈S中

如果读到n元运算符(即需要参数个数为n的运算符)则取出由栈顶向下的n项按操作符运算，再将运算的结果代替原栈顶的n项，压入栈S中

如果后缀表达式未读完，则重复上面过程，最后输出栈顶的数值则为结束。
*/


//Infix to Postfix Conversion
//• We use a stack
//• When an operand is read, output it
//• When an operator is read
//– Pop until the top of the stack has an element of lower
//precedence
//– Then push it
//• When ) is found, pop until we find the matching (
//• ( has the lowest precedence when in the stack
//• but has the highest precedence when in the input
//• When we reach the end of input, pop until the stack is
//empty

public class BasicCalculator {

    public int calculate(String s) {
        Stack<Character> stack = new Stack<>();
        List<String> list = new ArrayList<>();
        
        int index = 0;
        while(index != s.length()){
        	if(Character.isDigit(s.charAt(index))){
        		int i2 = index + 1;
        		while(i2 != s.length() && Character.isDigit(s.charAt(i2))){
        			i2++;
        		}
        		list.add(s.substring(index, i2));
        		index = i2;
        	}else{
        		switch(s.charAt(index)){
        		case '+':
        		case '-':
        			while(!stack.isEmpty() && (stack.peek() == '+' || stack.peek() == '-')){
        				list.add(stack.pop().toString());
        			}
        			stack.push(s.charAt(index));
        			break;
        		case '(':
        			stack.push('(');
        			break;
        		case ')':
        			while(stack.peek() != '('){
        				list.add(stack.pop().toString());
        			}
        			stack.pop();
        			break;
        		case ' ':
        			break;
        		}
        		index++;
        	}
        }
        
        while(!stack.isEmpty()){
        	list.add(stack.pop().toString());
        }
        
        return evalRPN(list.toArray(new String[0]));
    }
	
    private int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String s : tokens){
        	if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
        		int i2 = stack.pop();
        		int i1 = stack.pop();
        		switch(s){
        		case "+":
        			stack.push(i1 + i2);
        			break;
        		case "-":
        			stack.push(i1 - i2);
        			break;
        		case "*":
        			stack.push(i1 * i2);
        			break;
        		case "/":
        			stack.push(i1 / i2);
        			break;
        		}
        	}else{
        		stack.push(Integer.parseInt(s));
        	}
        }
        return stack.pop();
    }
}
