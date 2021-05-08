
public class EqualSubsetSum {

	public boolean canPartition(int[] nums) {

		if (nums.length == 1) {
			return false;
		}

		// check the sum %2 is zero
		int totalSum = 0;
		for (int num : nums) {
			totalSum += num;
		}

		if (totalSum % 2 != 0) {
			return false;
		}
		int halfSum = totalSum / 2;
		boolean[] combinationMapper = new boolean[halfSum + 1];
		combinationMapper[0] = true;

		for (int curr : nums) {
			for (int counter = halfSum; counter >= curr; counter--) {
				combinationMapper[counter] |= combinationMapper[counter - curr];
			}
		}

		return combinationMapper[halfSum];
	}

	public static void main(String[] args) {

		int[] array = { 5,5,6,6 };
		System.out.println(new EqualSubsetSum().canPartition(array));

	}
}
