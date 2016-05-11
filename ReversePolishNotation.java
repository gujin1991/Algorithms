import java.util.*;
public class ReversePolishNotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String postOrder = inOrderToPostOrder("11+44*(22-33)-601");
		System.out.println(postOrder);

		System.out.println(calReversePolishNotation(postOrder));
	}
	
	static private String inOrderToPostOrder(String equation) {
		String postEq = "";
		int len = equation.length();
		if(len == 0) {
			System.out.println("Wrong Input Format");
			return postEq;
		}
		Stack<Character> nums = new Stack<>();
		Stack<Character> ops = new Stack<>();
		
		
		for(int i = 0; i < len; i++) {
			char c = equation.charAt(i);
			if(Character.isDigit(c)) {
				nums.push(c);
			} else if(c == '(') {
				ops.push(c);
			} else if(c == ')') {
				nums.push(' ');
				char chars; 
				while((chars = ops.pop()) != '(') {
					nums.push(chars);
				}
			} else {
				nums.push(' ');
				if(c == '+' || c == '-') {
					//char peek = ops.peek();
					while(!ops.isEmpty() && ((ops.peek() == '*') || (ops.peek() == '/'))) {
						nums.push(ops.pop());	
					}
				} 			
				ops.push(c);
			}
		}
		nums.push(' ');
		
		while(!ops.isEmpty()) {
			postEq += ops.pop() + ""; 
		}
		
		while(!nums.isEmpty()) {
			postEq = nums.pop() + postEq;
		}
		
		return postEq;
	}
	
	static private int calReversePolishNotation(String notation) {
		int len = notation.length();
		if(len == 0) {
			System.out.println("Wrong input format!");
			return -1;
		}
		
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < len; i++) {
			char c = notation.charAt(i);
			
			if(Character.isDigit(c)) {
				int sum = 0;
				while(Character.isDigit(c)) {
					sum = sum * 10 + (c - '0');
					i++;
					c = notation.charAt(i);
				}
				stack.push(sum);
			} else if(c != ' '){
				int second = stack.pop();
				int first = stack.pop();
				
				stack.push(calculate(first, second, c));
			}
		}
		
		return stack.pop();
	}

	private static Integer calculate(int first, int second, char c) {
		// TODO Auto-generated method stub
		if(c == '+') {
			return first + second;
		} else if(c == '-') {
			return first - second;
		} else if(c == '*') {
			return first * second;
		} else {
			return first / second;
		}


		
		
	}

}
