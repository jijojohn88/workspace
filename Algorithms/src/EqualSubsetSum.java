
public class EqualSubsetSum {

	public boolean canPartition(int[] nums) {
		if (nums.length == 0)
			return false;
		int totalSum = 0;
		// find sum of all array elements
		for (int num : nums) {
			totalSum += num;
		}
		// if totalSum is odd, it cannot be partitioned into equal sum subset
		if (totalSum % 2 != 0)
			return false;
		int subSetSum = totalSum / 2;
		boolean dp[] = new boolean[subSetSum + 1];
		dp[0] = true;
		for (int curr : nums) {
			System.out.println("Number = " + curr);
			for (int counter = subSetSum; counter >= curr; counter--) {
				if (dp[counter - curr]) {
					System.out.println("Counter = " + counter + "-" + dp[counter] + "-[" + (counter - curr) + "]-"
							+ dp[counter - curr]);
				}
				dp[counter] |= dp[counter - curr];
				if (dp[subSetSum]) {
					break;
				}
			}
		}
		return dp[subSetSum];
	}

	public static void main(String[] args) {

		int[] array = { 11, 5, 8, 4, 6, 4 };
		System.out.println(new EqualSubsetSum().canPartition(array));

	}
}
