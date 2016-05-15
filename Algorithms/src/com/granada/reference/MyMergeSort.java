package com.granada.reference;

public class MyMergeSort {

	public int[] doMergeSort(int[] list) {
		int length = list.length;
		divide(list, 0, length - 1);
		return list;
	}

	public void divide(int[] list, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
			int middle = leftIndex + (rightIndex - leftIndex) / 2;
			divide(list, leftIndex, middle);
			divide(list, middle + 1, rightIndex);
			merge(list, leftIndex, middle, rightIndex);
		}
		
	}

	private void print(int[] list) {
		System.out.println();
		for(int n: list) {
			System.out.print("\t" + n);
		}
		System.out.println();
	}

	public void merge(int[] array, int lowerIndex, int middle, int higherIndex) {
//		System.out.println("-----Before Merge-------");
//		print(array);
		int[] tempMergeArray = new int[higherIndex + 1];
		for (int i = lowerIndex; i <= higherIndex; i++) {
			tempMergeArray[i] = array[i];
		}
		
		int i = lowerIndex;
		int j = middle+1;
		int k = lowerIndex;
		

		while (i <= middle && j <= higherIndex) {

			if (tempMergeArray[i] <= tempMergeArray[j]) {
				array[k] = tempMergeArray[i];
				i++;
			} else {
				array[k] = tempMergeArray[j];
				j++;
			}
			k++;

		}
		
		while(i <= middle) {
			array[k] = tempMergeArray[i];
			i++;
			k++;
		}

	}

	public static void main(String[] args) {
		int[] abcd = {8,5,3,2,4,1,6,9,7};
		MyMergeSort mm = new MyMergeSort();
		System.out.println("\n-----Initial Array-------");
		mm.print(abcd);
		abcd = mm.doMergeSort(abcd);
		System.out.println("\n-----Final Array-------");
		mm.print(abcd);
	}

}
