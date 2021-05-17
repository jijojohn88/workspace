
public class TransformToLowest {
	public static String minInteger(String num, int k) {
		char[] ca = num.toCharArray();
		helper(ca, 0, k);
		return new String(ca);
	}

	public static void helper(char[] ca, int I, int k) {
		if (k == 0 || I == ca.length)
			return;
		System.out.println("begin = " + new String(ca));
		int min = ca[I], minIdx = I;
		int scopeEndIndex = I + k + 1;
		for (int i = I + 1; i < Math.min(scopeEndIndex, ca.length); i++)
			if (ca[i] < min) {
				min = ca[i];
				minIdx = i;
			}
		char temp = ca[minIdx];
		System.out.println("minIndex=" + minIdx);
		for (int i = minIdx; i > I; i--) {
			System.out.println(new String(ca));
			ca[i] = ca[i - 1];
		}
		ca[I] = temp;
		System.out.println("swap=" + new String(ca));
		System.out.println("k-(minIndex-I)" + (k - (minIdx - I)));

		helper(ca, I + 1, k - (minIdx - I));
	}

	public static void main(String[] args) {
		System.out.println("result=" + minInteger("898989891", 5));
	}
}
