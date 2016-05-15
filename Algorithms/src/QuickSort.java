public class QuickSort {

	
	public static void print(int[] array) {
		System.out.println();
		for(int i: array) {
			System.out.print("[" + i + "]");
		}
		System.out.println();
	}
	public static void main(String[] args) {
//		int[] array = {53,5,7,3,8,24,32,30,22,21,20,43,1,4,6,9,19,11,10,42,2};
		int[] array = {4,3,5,7,1,2};
		sort(array, 0, array.length-1);
		print(array);
	}
	private static void sort(int[] array, int p, int r) {
		if(p < r) {
			print(array);

			p = partition(array, p, r);
			
			
			if((p+1)< array.length && (p-1) >= 0)
				System.out.println("Left - [" + array[p] +"..." + array[r] + "]");
			sort(array,0,p-1);
			if((p+1)< array.length && (p+1) >= 0)
				System.out.println("Right - [" + array[p+1] +"..." + array[r] + "]");
			sort(array,p+1,r);
		}
	}
	
	public static int partition(int[] array, int partitionIndex , int endIndex) {
		
		int pivot = array[endIndex];
		System.out.println("partition(array," + partitionIndex + "," + endIndex + ") - Start , Pivot Element = " + pivot);
		int left = partitionIndex-1;
		int right = partitionIndex;
		
		while(right <= (endIndex-1)) {
			
			if(array[right] <= pivot) {
				left++;
				swap(array, left, right);
				
			}
			right++;
		}
//		System.out.println("EndIndex = " + endIndex);
//		System.out.println("Right = " + right);
//		System.out.println("Left = " + left);
		System.out.println("Pivot shift");
		swap(array, endIndex, left+1);
		print(array);
		System.out.println("partition(array," + partitionIndex + "," + endIndex + ") - End , returnVal = " + (left+1));
		return left+1;
	}
	private static void swap(int[] array, int i, int j) {
		if(i==j) {
//			System.out.println("swap(array," + array[i] + "," + array[j] + ") - Action:No Swap");
			return;
		}
		System.out.println("swap(array," + array[i] + "," + array[j] + ")");
		int temp = array[j];
		array[j] = array[i];
		array[i] = temp;
	}
	
}
