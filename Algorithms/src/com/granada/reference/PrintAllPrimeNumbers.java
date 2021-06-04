package com.granada.reference;

public class PrintAllPrimeNumbers {

	public static boolean isPrime(int number) {

		for (int i = 2; i <= number / 2; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static boolean isPalindrome(int n) {
		int number = n;
		int reverseNumber = 0;
		while (number > 0) {
			int temp = number % 10;
			reverseNumber = 10 * reverseNumber + temp;
			number = number / 10;
		}
//		System.out.println(n + " vs " + reverseNumber);

		return (reverseNumber == n);
	}

	public static void main(String[] args) {

		for (int i = 0; i < 20000; i++) {
			if (isPrime(i) && isPalindrome(i)) {
				if(i % 11 == 0) {
					System.out.println(i + " ");
				} else {
					System.out.println(i + " - not 11 ");
				}
			}
		}

	}

}
