public class ClosestPalindrome {
	public String nearestPalindromic(String n) {
		String returnValue = "";
		if (n == null || n.length() <= 0) {
			return returnValue;
		} else {
			long number = -1;
			try {
				number = Long.parseLong(n);
			} catch (NumberFormatException nfe) {
			}

			int leftOffset = 1, rightOffset = 1;
			while (!isPalindrome(number - leftOffset)) {
				leftOffset++;
			}
			while (!isPalindrome(number + rightOffset)) {
				rightOffset++;
			}
			if (leftOffset <= rightOffset) {
				returnValue = "" + (number - leftOffset);
			} else {
				returnValue = "" + (number + rightOffset);
			}
		}

		return returnValue;
	}

	public boolean isPalindrome(long number) {
		long temp = number;
		long sum = 0;
		while (number > 0) {
			sum = (sum * 10) + (number % 10);
			number = number / 10;
		}

		return temp == sum;
	}

	public static void main(String[] args) {
		String result = new ClosestPalindrome().nearestPalindromic("2147483647");
		System.out.println("Result:" + result);
	}
}
