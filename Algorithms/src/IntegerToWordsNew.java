
public class IntegerToWordsNew {

	public static final String[] TENs = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" };
	public static final String[] TWENTYs = { "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
			"Seventeen", "Eighteen", "Ninteen" };
	public static final String[] HUNDREDs = { "", "Ten", "Twenty", "Thirty", "Fourty", "Fifty", "Sixty", "Seventy",
			"Eighty", "Ninty" };

	public static String toString(int number) {

		String result = new String();
		if (number < 10) {
			result = TENs[number];
		} else if (number < 20) {
			result = TWENTYs[number - 10];
		} else if (number < 100) {
			result = HUNDREDs[number / 10] + " " + toString(number % 10);
		} else if (number < 1000) {
			result = toString(number / 100) + " Hundred " + toString(number % 100);
		} else if (number < 1000000) {
			result = toString(number / 1000) + " Thousand " + toString(number % 1000);
		} else if (number < 1000000000) {
			result = toString(number / 1000000) + " Million " + toString(number % 1000000);
		} else {
			result = toString(number / 1000000000) + " billion " + toString(number % 1000000000);
		}

		return result.trim();
	}

	public static void main(String[] args) {

		for (int i = 0; i < 1000; i++) {
			String name = toString(i);
			System.out.println(i + "=" + name);
		}

	}

}
