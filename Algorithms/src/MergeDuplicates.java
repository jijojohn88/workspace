import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * questions asked in coding round
 */

public class MergeDuplicates {

	public static List<Integer> minimalOperations(List<String> words) {
		// Write your code here
		List<Integer> returnList = new ArrayList<Integer>();
		if (words == null || words.size() <= 0) {
			return returnList;
		}

		for (String str : words) {

			char previous = 'a';
			int finalResult = 0;
			int localResult = 0;
			for (int i = 0; i < str.length(); i++) {
				if (i == 0) {
					previous = str.charAt(i);
				} else if (previous != str.charAt(i)) {
					previous = str.charAt(i);
					if (localResult != 0) {
						localResult = 0;
						finalResult++;
					}

				} else {
					localResult++;
				}

			}
			returnList.add(finalResult);

		}

		return returnList;

	}

	public static void main(String[] args) throws IOException {

		List<String> words = new ArrayList<>();

		words.add("book");
		words.add("boook");
		words.add("boookoo");

		List<Integer> result = minimalOperations(words);

		for (Integer value : result) {
			System.out.println(value);
		}

	}
}