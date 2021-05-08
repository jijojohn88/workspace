import java.util.Arrays;

public class KthLargestElement {

	public static int partition = 0;

	public int partition(int[] array, int k, int start, int end) {

		System.out.println("partition = " + partition);

		int pivot = array[start];

		int i = start;
		int j = end;

		print(array);
		while (i < j) {
			while (i < array.length - 1 && pivot >= array[i]) {
				i++;
			}

			while (j > 0 && pivot < array[j]) {
				j--;
			}

			if (i < j) {
				swap(array, i, j);
			}

		}
		swap(array, start, j);
		System.out.println("I did fix the element at " + j);
		return j;

	}

	public int findKthLargest(int[] array, int k, int start, int end) {
		partition = array.length - k;

		if (start < end) {
			int index = partition(array, k, start, end);

			if (index < partition) {
				findKthLargest(array, k, index + 1, array.length - 1);
			} else if (index > partition) {
				findKthLargest(array, k, 0, index - 1);
			}

		}

		return array[partition];

	}

	public void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
		print(array, i, j);
	}

	public static void print(int[] array) {
		for (int i = 0; i < array.length; i++) {

			if (i == partition) {
				System.out.print("{" + array[i] + "},");
			} else
				System.out.print(array[i] + ",");
		}
		System.out.println();
	}

	public static void print(int[] array, int k, int j) {
		for (int i = 0; i < array.length; i++) {

			if (i == partition) {
				System.out.print("{" + array[i] + "},");
			} else if (i == k || i == j) {
				System.out.print("[" + array[i] + "],");
			} else
				System.out.print(array[i] + ",");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] array = { 5, 2, 3, 6, 0, 8, 4, 9, 1, 7 };
		int index = new KthLargestElement().findKthLargest(array, 4, 0, array.length - 1);
		System.out.println("value = " + array[index]);
		System.out.println("-------------");
		Arrays.sort(array);
		print(array);

	}

}
