
public class FoldStringWithNumbers {

	public static void main(String[] args) {

		String input = "aabbbcdeeef";

		char[] array = input.toCharArray();
		String result = "";
		char previous = '\0';
		int counter = 0;
		for (char c : array) {

			if (previous == '\0') {
				counter=1;
				previous = c;
			} else if (previous == c) {
				counter++;
			} else if (previous != c) {
				
				if(counter > 1) {
					result += "" + previous + counter;
				} else {
					result += previous;
				}
				counter = 1;
				previous = c;
			}
		}
		result += previous;
		if(counter >1) {
			result += counter;
		}
		
		System.out.println("input=" + input);
		System.out.println("result=" + result);

	}

}
