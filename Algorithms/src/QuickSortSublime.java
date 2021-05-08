//QuickSort-in-sublime-mode

public class QuickSortSublime {

	public int[] quicksort(int[] array, int start, int end) {

		if (start < end) {
			int partition = partition(array, start, end);
			// important : never try to sort including the partitioned element
			// exclude it by -1 and +1 with partition
			quicksort(array, start, partition - 1);
			quicksort(array, partition + 1, end);
		}
		return array;
	}

	public void printArray(int[] array) {
		for (int a : array) {
			System.out.print(a + ",");
		}
		System.out.println();
	}

	public int partition(int[] array, int start, int end) {

		int pivot = array[start];
		int i = start;
		int j = end;
		System.out.println("pivot=" + pivot + ", index = " + start);
		while (i < j) {

			// Makesure the value of i go beyond the array last index
			while (i < (array.length - 1) && pivot >= array[i]) {
				i++;
			}
			// make sure j dont go beyond 0
			while (j > 0 && pivot < array[j]) {
				j--;
			}
			if (i < j) {
				swap(array, i, j);
			}
		}
		swap(array, start, j);
		return j;

	}

	public void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
		printArray(array);
	}

	public static void main(String[] args) {
		int[] array = { 5, 2, 3, 6, 0, 8, 4, 9, 1, 7};
		array = new QuickSortSublime().quicksort(array, 0, array.length - 1);

	}
}