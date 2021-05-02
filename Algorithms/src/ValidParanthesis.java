

import java.util.Stack;

public class ValidParanthesis {

	public static char SIMPLE_OPEN = '(';
	public static char SIMPLE_CLOSE = ')';
	public static char DOUBLE_OPEN = '{';
	public static char DOUBLE_CLOSE = '}';
	public static char SQUARE_OPEN = '[';
	public static char SQUARE_CLOSE = ']';

	public static void main(String[] args) {
		String s = "(()})";
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (SIMPLE_OPEN == c || DOUBLE_OPEN == c || SQUARE_OPEN == c) {
				stack.push(c);
			} else if (c == SIMPLE_CLOSE) {
				char popChar = stack.pop();
				if (popChar != SIMPLE_OPEN) {
					System.err.println("Not a valid String");
				}

			} else if (c == DOUBLE_CLOSE) {
				char popChar = stack.pop();
				if (popChar != DOUBLE_OPEN) {
					System.err.println("Not a valid String");
				}

			} else if (c == SQUARE_CLOSE) {
				char popChar = stack.pop();
				if (popChar != SQUARE_OPEN) {
					System.err.println("Not a valid String");
				}

			}

		}
		
		System.out.println("VALID STRING");
	}

}
