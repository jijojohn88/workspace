
public class HeapSortLatest {

	private int endIndex = 0;

	public void printArray(int[] array) {
		for (int a : array) {
			System.out.print(a + ",");
		}
		System.out.println();
	}

	public void sort(int[] array) {

		endIndex = array.length - 1;

		for (int i = endIndex; i > 0; i--) {
			maxHeapify(array, i);
			endIndex -= 1;
			printArray(array);

		}

	}

	public void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public void heapify(int[] array, int index) {

		printArray(array);
		int left = 2 * index;
		int right = left + 1;

		int maxPointer = index;

		if (left <= endIndex && array[index] < array[left]) {
			maxPointer = left;
		}
		if (right <= endIndex && array[maxPointer] < array[right]) {
			maxPointer = right;
		}

		if (maxPointer != index) {
			swap(array, index, maxPointer);
			heapify(array, maxPointer);
		}

		printArray(array);
	}

	public void maxHeapify(int[] array, int endIndex) {

		int midIndex = endIndex / 2;

		for (int i = midIndex; i >= 0; i--) {
			heapify(array, i);
		}
		swap(array, 0, endIndex);

	}

	public static void main(String[] args) {

		int[] array = { 3, 4, 2, 5, 6, 8, 9, 7, 0, 1 };

		HeapSortLatest hp = new HeapSortLatest();
		hp.printArray(array);
		hp.sort(array);

	}

}
