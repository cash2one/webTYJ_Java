package com.flf.util;
import java.math.BigDecimal;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * @see <code>�ַ�ʽ�ļ���</code>
 * @author zw
 * @date 2015-07-27
 */
public class FormulaHelper {

		public static char PLUS = '+';
		public static char MINUS = '-';
		public static char MULTI = '*';
		public static char DEVIDE = '/';
		
		public static char BRACKET_LEFT = '(';
		public static char BRACKET_RIGHT = ')';
		
		/**
		 * �����С���ŵĹ�ʽ
		 * @param line
		 * @return
		 */
		public static double eval(String line){
			while(line.indexOf(BRACKET_LEFT) != -1){
				Pattern pattern = Pattern.compile("\\(([^\\(\\)]*?)\\)");
				Matcher matcher = pattern.matcher(line);
				while(matcher.find()){
					double result = simpleEval(matcher.group(1));
					line = line.replace(matcher.group(), result+"");
				}
			}
			return simpleEval(line);
		}
		
		/**
		 * ���㲻�����ŵĹ�ʽ
		 * @param line
		 * @return
		 */
		@SuppressWarnings("unchecked")
		public static double simpleEval(String line){
			Stack<Double> valueStack = new Stack<Double>();//����ֵ�Ķ�ջ
			Stack<Character> markStack = new Stack<Character>();//�����ŵĶ�ջ
			
			char ch[] = line.toCharArray();
			
			//����˳����
			String tmpValue = "";
			boolean isOper = false;
			for(int i=0; i< ch.length; i++){
				if( ch[i] == PLUS || ch[i] == MINUS || ch[i] == MULTI || ch[i] == DEVIDE) {
					double dv = Double.valueOf(tmpValue).doubleValue();
					if(isOper){
						double dv1 = valueStack.pop();
						char op = markStack.pop();
						double result = simpleTwoEval(op, dv1, dv);
						dv = result;
					}
					valueStack.push(dv);
					markStack.push(ch[i]);
					tmpValue = "";
					isOper = false;
					if( ch[i] == MULTI || ch[i] == DEVIDE )
						isOper = true;
				}else{
					tmpValue += ch[i] + "";
					
					if(i == ch.length -1){
						double dv = Double.valueOf(tmpValue).doubleValue();
						if(isOper){
							double dv1 = valueStack.pop();
							char op = markStack.pop();
							double result = simpleTwoEval(op, dv1, dv);
							dv = result;
						}
						valueStack.push(dv);
					}
				}
			}
			
			//����Ӽ�����
			valueStack = (Stack<Double>) reverseStack(valueStack);
			markStack = (Stack<Character>) reverseStack(markStack);
			while(valueStack.size() > 1){
				double v1 = valueStack.pop();
				double v2 = valueStack.pop();
				char op = markStack.pop();
				double result = simpleTwoEval(op, v1, v2);
				valueStack.push(result);
			}
			return valueStack.get(0);
		}
		
		/**
		 * �������ջ��ת
		 * @param stack
		 * @return
		 */
		@SuppressWarnings("unchecked")
		private static Stack<?> reverseStack(Stack<?> stack){
			Stack reverse = new Stack();
			int stackSize = stack.size();
			for(int i=0; i< stackSize; i++){
				reverse.push(stack.pop());
			}
			return reverse;
		}
		
		/**
		 * ֻ����򵥵���������
		 * @param op
		 * @param value1
		 * @param value2
		 * @return
		 */
		private static double simpleTwoEval(char op, double value1, double value2){
			BigDecimal bd1 = new BigDecimal(Double.toString(value1));
	        BigDecimal bd2 = new BigDecimal(Double.toString(value2));
			if(op == PLUS){
				return bd1.add(bd2).doubleValue();
			}else if(op == MINUS){
				return bd1.subtract(bd2).doubleValue();
			}else if(op == MULTI){
				return bd1.multiply(bd2).doubleValue();
			}else if(op == DEVIDE){
				return bd1.divide (bd2,2,BigDecimal.ROUND_HALF_UP).doubleValue();
			}
			return 0;
		}
		
		public static void main(String[] args) {
			//double result = FormulaHelper.eval("1+(2*(3+2))-6+(3/2)+4/2");
			double result = FormulaHelper.eval("22.0*2.3");
			System.out.println(result);
		}
}
