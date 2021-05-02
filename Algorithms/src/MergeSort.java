
public class MergeSort {
	void merge(int arr[], int leftIndex, int middleIndex, int rightIndex) {
		int leftArraySize = middleIndex - leftIndex + 1;
		int rightArraySize = rightIndex - middleIndex;

		int L[] = new int[leftArraySize];
		int R[] = new int[rightArraySize];

		for (int i = 0; i < leftArraySize; ++i)
			L[i] = arr[leftIndex + i];
		for (int j = 0; j < rightArraySize; ++j)
			R[j] = arr[middleIndex + 1 + j];

		int i = 0, j = 0;

		int k = leftIndex;
		while (i < leftArraySize && j < rightArraySize) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		while (i < leftArraySize) {
			arr[k] = L[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < rightArraySize) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	void sort(int arr[], int left, int right) {
		if (left < right) {
			int middle = left + (right - left) / 2;
			sort(arr, left, middle);
			sort(arr, middle + 1, right);
			merge(arr, left, middle, right);
		}
	}

	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void main(String args[]) {
		int arr[] = { 12, 11, 13, 5, 6, 7 };

		System.out.println("Given Array");
		printArray(arr);

		MergeSort ob = new MergeSort();
		ob.sort(arr, 0, arr.length - 1);

		System.out.println("\nSorted array");
		printArray(arr);
	}
}
