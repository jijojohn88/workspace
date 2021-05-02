package com.lab.exercise;

public class merge2sortedArrays {

	public static void main(String[] args) {

		int[] array = { 3, 4 };
		int[] secondArray = { 4, 6 };

		int firstArraySize = array.length;
		int secondArraySize = secondArray.length;

		int[] mergedArray = new int[firstArraySize + secondArraySize];

		int i = 0, j = 0, k = 0;

		while (i < firstArraySize && j < secondArraySize) {

			if (array[i] <= secondArray[j]) {
				mergedArray[k] = array[i];
				i++;
				k++;
			} else {
				mergedArray[k] = secondArray[j];
				j++;
				k++;
			}

		}

		while (i < firstArraySize) {
			mergedArray[k] = array[i];
			i++;
			k++;
		}

		while (j < secondArraySize) {
			mergedArray[k] = secondArray[j];
			j++;
			k++;
		}

		for (int value : mergedArray) {
			System.out.print(value + ",");
		}

	}
}
