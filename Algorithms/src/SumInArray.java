import java.util.HashMap;
import java.util.Map;

public class SumInArray {
	public static int subarraySum(int[] nums, int k) {
		int sum = 0, result = 0;
		Map<Integer, Integer> preSum = new HashMap<>();
		preSum.put(0, 1);

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			System.out.println(preSum + " and key = " + (sum - k) + ": sum = " + sum + ": result= " + result);

			if (preSum.containsKey(sum - k)) {
				result += preSum.get(sum - k);
			}
			preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
		}

		return result;
	}
	

	public static void main(String[] args) {
//		System.out.println("result = " + subarraySum(new int[] {1,1,0},0));
//		System.out.println("result = " + subarraySum(new int[] {1,-1,1},2));
		System.out.println("Array = {10,3,5,8,6,12,20,15,31,31}");
		System.out.println("result = " + subarraySum(new int[] {10,3,5,8,6,12,20,15,31,0,0,0,0,0,31},31));
	}
}
