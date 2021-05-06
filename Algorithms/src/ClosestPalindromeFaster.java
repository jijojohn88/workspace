/**
 * https://leetcode.com/problems/find-the-closest-palindrome/submissions/
 * 
 * @author jjijo
 *
 */
public class ClosestPalindromeFaster {
	public String nearestPalindromic(String number) {
		char[] chars = number.toCharArray();
		int left = 0, right = chars.length - 1;
		// 12345->12321
		while (left < right) {
			chars[right] = chars[left];
			right--;
			left++;
		}
		String leftRightSwapperString = new String(chars);
		System.out.println("a = " + leftRightSwapperString);
		// 12421
		String leftRightSwappedPlusOne = find(leftRightSwapperString, 1);
		System.out.println("b = " + leftRightSwappedPlusOne);

		// 12221
		String leftRightSwapperMinusOne = find(leftRightSwapperString, -1);
		System.out.println("c = " + leftRightSwapperMinusOne);

		long realNumber = Long.valueOf(number), plusOne = Long.valueOf(leftRightSwapperString), minusOne = Long.valueOf(leftRightSwappedPlusOne), c1 = Long.valueOf(leftRightSwapperMinusOne);
		// diff1=12345-12321,diff2=abs(12345-12421),diff3=12345-12221.Only this three
		// possible cases.
		long diff1 = Math.abs(realNumber - plusOne), diff2 = Math.abs(realNumber - minusOne), diff3 = Math.abs(realNumber - c1);
		if (realNumber == plusOne) {
			// choose 12421 and 12221
			return diff2 < diff3 ? leftRightSwappedPlusOne : leftRightSwapperMinusOne;
		} else if (realNumber < plusOne) {
			return diff1 < diff3 ? leftRightSwapperString : leftRightSwapperMinusOne;
		} else {
			return diff1 <= diff2 ? leftRightSwapperString : leftRightSwappedPlusOne;
		}
	}

	private String find(String s, int flag) {
		// 2
		long right = s.length() / 2;
		// 3
		long left = s.length() - right;
		// 123
		long l = Long.valueOf(s.substring(0, (int) left));
		// 124 or 122
		l += flag;
		// edge cases1: if s=10 return 9; if s=1 return 0
		if (l == 0)
			return right == 0 ? "0" : "9";
		// 124 or 122
		StringBuilder l1 = new StringBuilder(String.valueOf(l));
		// 421 or 221
		StringBuilder r1 = new StringBuilder(l1).reverse();
		// edge cases2: deal with 1001 ---->> right=2 left=2 l1=9 r1=9(need change r1 to
		// 99)
		if (right > l1.length())
			r1.append(9);
		// 12421 or 12221
		return l1.append(r1.substring(r1.length() - (int) right)).toString();
	}

	public static void main(String[] args) {
		// String result = new
		// ClosestPalindrome().nearestPalindromic("807045053224792883");
		// 807045053350540708
		// 807045053350540708
		String result = new ClosestPalindromeFaster().nearestPalindromic("807045053224792883");
		System.out.println("Result:" + result);
	}
}
