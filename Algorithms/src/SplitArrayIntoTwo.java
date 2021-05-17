import java.util.ArrayList;
import java.util.List;

public class SplitArrayIntoTwo {

	public static List<Integer> partA = new ArrayList<>();

	public static boolean halfSum(int[] nums) {

		// check edge case
		if (nums == null || nums.length == 0) {
			return true;
		}
		// preprocess
		int totalSum = 0;
		for (int num : nums) {
			totalSum += num;
		}
		if (totalSum % 2 != 0) {
			return false;
		}
		totalSum /= 2;
		boolean[] dp = new boolean[totalSum + 1];
		dp[0] = true;
		for (int i = 1; i <= nums.length; i++) {
			for (int j = totalSum; j >= nums[i - 1]; j--) {
				dp[j] = dp[j] || dp[j - nums[i - 1]];
			}
		}
		return dp[totalSum];

	}

	public static void main(String[] args) {

		int[] array = { 5, 2, 3 };
		System.out.println(partA);

	}

}
