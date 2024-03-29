package com.granada.reference;

/* Class HeapSort */
public class HeapSort {
	private static int totalSize;

	/* Sort Function */
	public static void sort(int arr[]) {
		heapify(arr);
		for (int i = totalSize; i > 0; i--) {
			swap(arr, 0, i);
			totalSize = totalSize - 1;
			maxheap(arr, 0);
		}
	}

	/* Function to build a heap */
	public static void heapify(int arr[]) {
		totalSize = arr.length - 1;
		System.out.println("Total Size = " + totalSize);

		for (int i = totalSize / 2; i >= 0; i--) {
			System.out.println("Working on parent at = " + i + " value = " + arr[i]);
			maxheap(arr, i);
			print(arr);
		}
	}

	/* Function to swap largest element in heap */
	public static void maxheap(int arr[], int i) {
		int left = 2 * i;
		int right = 2 * i + 1;
		System.out.println("maxHeap(array," + i + ") - val = " + arr[i] + " - left = " + left + " - right = " + right);

		int max = i;
		if (left <= totalSize && arr[left] > arr[i])
			max = left;
		if (right <= totalSize && arr[right] > arr[max])
			max = right;

		if (max != i) {
			swap(arr, i, max);
			maxheap(arr, max);
		}
	}

	/* Function to swap two numbers in an array */
	public static void swap(int arr[], int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
		print(arr);
	}

	/* Main method */
	public static void main(String[] args) {
		System.out.println("Heap Sort Test\n");
		int arr[] = { 9, 8, 2, 1, 5, 3, 4, 7, 6 };
		print(arr);
		sort(arr);
		System.out.println("\nElements after sorting ");
		print(arr);
	}

	private static void print(int[] arr) {
		System.out.println();
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
}