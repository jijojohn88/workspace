

import java.util.Hashtable;

/*
 * Given an array of integers nums and an integer target, 
 * return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, 
 * and you may not use the same element twice.
 * can return the answer in any order.


 */
public class TwoSum {

	/**
	 * create a hashtable and save the compliment value from the target then check
	 * for the compliment value against each of the array item
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] twoSum(int[] nums, int target) {
		Hashtable<Integer, Integer> complimentSet = new Hashtable<Integer, Integer>(2);
		for (int i = 0; i < nums.length; i++) {
			int compliment = target - nums[i];
			if (complimentSet.containsKey(compliment)) {
				return new int[] { i, complimentSet.get(compliment) };
			} else {
				complimentSet.put(nums[i], i);
			}
		}
		return null;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 7, 11, 15 };
		int[] result = twoSum(nums, 9);
		if (result != null) {
			for (int a : result) {
				System.out.print(a + ",");
			}
		}
	}

}
