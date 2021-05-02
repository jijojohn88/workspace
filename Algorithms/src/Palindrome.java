

/*
 * https://leetcode.com/problems/palindrome-number/
 * Given an integer x, return true if x is palindrome integer.
 * An integer is a palindrome when it reads the same backward 
 * as forward. For example, 121 is palindrome while 123 is not.
 */

public class Palindrome {

	
	public static void main(String[] args) {

		int valueToCheck=1321;
		
		String x = String.valueOf(valueToCheck);
		
		for(int i=0;i<x.length();i++) {
			if(x.charAt(i)!=x.charAt(x.length()-1-i)) {
				System.out.println("not a palindrome");
			}
		}
		
	}
}
