import java.io.File;
import java.io.FileReader;

/**
 * This merge sort i have written all out of blue 8th May 2021
 * 
 * @author jjijo
 *
 */
public class MergeSortLatest {

	public void printArray(int[] array) {
		for (int a : array) {
			System.out.print(a + ",");
		}
		System.out.println();
	}

	public int[] mergeSort(int[] array) {

		if (array.length <= 1) {
			return array;
		}

		int midPoint = array.length / 2;

		int[] left = new int[midPoint];
		int[] right = new int[midPoint];
		if (array.length % 2 != 0) {
			right = new int[midPoint + 1];
		}

		for (int i = 0; i < left.length; i++) {
			left[i] = array[i];
		}

		for (int j = 0; j < right.length; j++) {
			right[j] = array[j + midPoint];
		}

		left = mergeSort(left);
		right = mergeSort(right);
		return merge(left, right);

	}

	public int[] merge(int[] left, int[] right) {

		int[] result = new int[left.length + right.length];
		int leftPointer = 0, rightPointer = 0, resultPointer = 0;

		while (leftPointer < left.length || rightPointer < right.length) {

			if (leftPointer < left.length && rightPointer < right.length) {

				if (left[leftPointer] < right[rightPointer]) {
					result[resultPointer++] = left[leftPointer++];
				} else {
					result[resultPointer++] = right[rightPointer++];
				}

			} else if (leftPointer < left.length) {
				result[resultPointer++] = left[leftPointer++];
			} else if (rightPointer < right.length) {
				result[resultPointer++] = right[rightPointer++];
			}

		}

		printArray(result);
		return result;

	}

	public static void main(String[] args) {

//		int[] array = { 3, 2, 5, 4, 1, 6, 8, 7, 9, 0 };
		int[] array = new LoadTestIntArray().read().stream().mapToInt(i -> i).toArray();
		int[] result = new MergeSortLatest().mergeSort(array);

		new MergeSortLatest().printArray(result);

	}

}
