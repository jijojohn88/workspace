
public class ProductExceptSelfArray {

	public static int[] productExceptSelf(int[] nums) {
		int n = nums.length;
		int[] result = new int[n];

		int right = 1;

		result[0] = 1;

		for (int i = 1; i < n; i++) {
			result[i] = nums[i - 1] * result[i - 1];
		}
		right = 1;
		for (int i = n - 1; i >= 0; i--) {
			result[i] *= right;
			right = right * nums[i];
		}

		return result;
	}

	public static void print(int[] array) {
		for (int a : array) {
			System.out.print(a + ",");
		}
		System.out.println();
	}

	public static void main(String[] args) {

		int[] array = { 1, 2, 3, 4 };
		int[] product = productExceptSelf(array);

		print(array);
		print(product);

	}

}
