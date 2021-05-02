package com.lab.exercise;

public class Medianof2SortedArrays {

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		// Check if num1 is smaller than num2
		// If not, then we will swap num1 with num2
		if (nums1.length > nums2.length) {
			return findMedianSortedArrays(nums2, nums1);
		}
		// Lengths of two arrays
		int nums1Length = nums1.length;
		int nums2Length = nums2.length;
		// Pointers for binary search
		int start = 0;
		int end = nums1Length;
		// Binary search starts from here
		while (start <= end) {
			// Partitions of both the array
			int partitionNums1 = (start + end) / 2;
			int partitionNums2 = (nums1Length + nums2Length + 1) / 2 - partitionNums1;
			// Edge cases
			// If there are no elements left on the left side after partition
			int maxLeftNums1 = partitionNums1 == 0 ? Integer.MIN_VALUE : nums1[partitionNums1 - 1];
			// If there are no elements left on the right side after partition
			int minRightNums1 = partitionNums1 == nums1Length ? Integer.MAX_VALUE : nums1[partitionNums1];
			// Similarly for nums2
			int maxLeftNums2 = partitionNums2 == 0 ? Integer.MIN_VALUE : nums2[partitionNums2 - 1];
			int minRightNums2 = partitionNums2 == nums2Length ? Integer.MAX_VALUE : nums2[partitionNums2];
			// Check if we have found the match
			if (maxLeftNums1 <= minRightNums2 && maxLeftNums2 <= minRightNums1) {
				// Check if the combined array is of even/odd length
				if ((nums1Length + nums2Length) % 2 == 0) {
					return (Math.max(maxLeftNums1, maxLeftNums2) + Math.min(minRightNums1, minRightNums2)) / 2.0;
				} else {
					return Math.max(maxLeftNums1, maxLeftNums2);
				}
			}
			// If we are too far on the right, we need to go to left side
			else if (maxLeftNums1 > minRightNums2) {
				end = partitionNums1 - 1;
			}
			// If we are too far on the left, we need to go to right side
			else {
				start = partitionNums1 + 1;
			}
		}
		// If we reach here, it means the arrays are not sorted
		throw new IllegalArgumentException();
	}

	public static void main(String[] args) {

		int[] nums1 = { 4,7,8,9,10,20 };
		int[] nums2 = { 1,3 };

		System.out.println("value = " + findMedianSortedArrays(nums1, nums2));

	}
}
