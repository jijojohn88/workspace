

import java.util.Iterator;

/*
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 * accepted answer too
 */

public class MedianOfTwoSortedArrays {

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

		int sizeNums1 = nums1.length;
		int sizeNums2 = nums2.length;
		int totalSize = nums1.length + nums2.length;
		float returnValue = 0;

		int[] mergedArray = new int[totalSize];

		int i = 0, j = 0, k = 0;
		while (i < sizeNums1 && j < sizeNums2) {
			if (nums1[i] <= nums2[j]) {
				mergedArray[k++] = nums1[i++];
			} else {
				mergedArray[k++] = nums2[j++];
			}
		}
		while (i < sizeNums1) {
			mergedArray[k++] = nums1[i++];
		}
		while (j < sizeNums2) {
			mergedArray[k++] = nums2[j++];
		}

		printArray(mergedArray);

		int midIndex = mergedArray.length / 2;
		System.out.println("midindex = " + midIndex);
		returnValue = mergedArray[midIndex];
		if (mergedArray.length % 2 == 0) {
			System.out.println("Sum = " + (mergedArray[midIndex - 1] + mergedArray[midIndex]));
			returnValue = (mergedArray[midIndex - 1] + mergedArray[midIndex]) / 2f;
		}

		return returnValue;
	}
	
	public float findMedian(int[] array) {
		float returnValue=0;
		int midIndex = array.length / 2;
		System.out.println("midindex = " + midIndex);
		returnValue = array[midIndex];
		if (array.length % 2 == 0) {
			System.out.println("Sum = " + (array[midIndex - 1] + array[midIndex]));
			returnValue = (array[midIndex - 1] + array[midIndex]) / 2f;
		}
		return returnValue;
	}

	public static void printArray(int[] arrray) {
		for (int a : arrray) {
			System.out.print(a + ",");
		}
		System.out.println();
	}

	public static void main(String[] args) {

		int[] nums1 = { 4,7,8,9,10,20 };
		int[] nums2 = { 1,3 };

		System.out.println("value = " + findMedianSortedArrays(nums1, nums2));

	}

}
