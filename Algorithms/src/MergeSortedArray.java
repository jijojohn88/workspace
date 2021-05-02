

//https://leetcode.com/problems/merge-sorted-array/

public class MergeSortedArray {

	public int[] sort(int[] nums1, int m, int[] nums2, int n) {

		int totalLength = m + n - 1;

		int mPosition = m - 1;
		int nPosition = n - 1;
		for (int i = totalLength; i >= 0; i--) {

			if (mPosition >= 0 && nPosition >= 0) {

				System.out.println(nums2[nPosition] + " vs " + nums1[mPosition]);
				if (nums2[nPosition] >= nums1[mPosition]) {
					nums1[i] = nums2[nPosition--];
				} else {
					nums1[i] = nums1[mPosition--];
				}
				System.out.println("mposition = " + mPosition);
				System.out.println("nPosition = " + nPosition);

			} else if (nPosition >= 0) {
				System.out.println("nums1 over");
				nums1[i] = nums2[nPosition--];
			}
		}

		return nums1;
	}

	public static void main(String[] args) {
		int[] nums1 = { 2, 4, 6, 8, 8, 0, 0 };
		int[] nums2 = { 1, 7, 9, 10 };

		MergeSortedArray msa = new MergeSortedArray();
		int[] result = msa.sort(nums1, 3, nums2, 4);
		for (int a : result) {
			System.out.print(a + ",");
		}

	}

}